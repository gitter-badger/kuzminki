/*
* Copyright 2021 Kári Magnússon
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package kuzminki.rdbc

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.util.{Try, Success, Failure}
import scala.concurrent.duration._

import com.typesafe.config.Config
import com.typesafe.scalalogging.LazyLogging

import akka.stream.scaladsl._
import akka.stream.Materializer
import akka.actor.ActorSystem
import akka.{NotUsed, Done}

import io.rdbc.sapi._

import io.rdbc.pgsql.core.config.sapi.Auth
import io.rdbc.pgsql.transport.netty.sapi.NettyPgConnectionFactory
import io.rdbc.pgsql.transport.netty.sapi.NettyPgConnectionFactory.{Config => RdbcConfig}

import io.rdbc.pool.sapi.ConnectionPool
import io.rdbc.pool.sapi.ConnectionPoolConfig


case class DriverConf(host: String,
                      db: String,
                      user: String,
                      pwd: String,
                      threads: Option[Int],
                      port: Option[Int])

object DriverPool {

  def forConfig(conf: Config, ec: ExecutionContext) = {
    
    val host = conf.getString("host")
    val db = conf.getString("db")
    val user = conf.getString("user")
    val pwd = conf.getString("password")

    val threads = Try[Int] {
      conf.getInt("threads")
    } match {
      case Success(value) => Some(value)
      case Failure(ex) => None
    }

    val port = Try[Int] {
      conf.getInt("port")
    } match {
      case Success(value) => Some(value)
      case Failure(ex) => None
    }

    create(DriverConf(host, db, user, pwd, threads, port), ec)
  }

  def create(conf: DriverConf, ec: ExecutionContext) = {

    val dbConfig = RdbcConfig(
      conf.host,
      conf.port.getOrElse(5432),
      Auth.password(conf.user, conf.pwd),
      Some(conf.db)
    )
    
    val poolConfig = ConnectionPoolConfig(
      name = s"${conf.db}-pool",
      size = conf.threads.getOrElse(10),
      ec = ec
    )

    ConnectionPool(NettyPgConnectionFactory(dbConfig), poolConfig)
  }
}


object Driver {
  def create(pool: ConnectionPool, system: ActorSystem,  ec: ExecutionContext) = {
    new Driver(pool)(system, ec)
  }
}


class Driver(pool: ConnectionPool)(implicit system: ActorSystem,  ec: ExecutionContext) {

  private implicit val materializer = Materializer(system)
  private implicit val timeout = 5.seconds.timeout
  private val inf = Timeout(Duration.Inf)

  def select[R](statement: SqlWithParams)(transform: Row => R): Future[Seq[R]] = {
    pool.withConnection(_.statement(statement).executeForSet).map(_.rows).map { rows =>
      rows.map { row =>
        transform(row)
      }
    }
  }

  def selectHead[R](statement: SqlWithParams)(transform: Row => R): Future[R] = {
    pool.withConnection(_.statement(statement).executeForSet).map { rows =>
      transform(rows.head)
    }
  }

  def selectHeadOption[R](statement: SqlWithParams)(transform: Row => R): Future[Option[R]] = {
    pool.withConnection(_.statement(statement).executeForSet).map { rows =>
      rows.headOption.map(transform)
    }
  }

  def count(statement: SqlWithParams): Future[Int] = {
    pool.withConnection(_.statement(statement).executeForSet).map { rows =>
      rows.head.col[Int]("count")
    }
  }

  def exec(statement: SqlWithParams): Future[Unit] = {
    pool.withConnection(_.statement(statement).execute)
  }

  def execNum(statement: SqlWithParams): Future[Long] = {
    pool.withConnection(_.statement(statement).executeForRowsAffected)
  }

  def stream[R](statement: SqlWithParams, sink: Sink[R, Future[Done]])(transform: Row => R): Future[Done] = {
    pool.withConnection { conn =>
      Source.fromPublisher(
        conn.statement(statement).stream()(inf)
      ).map(transform).runWith(sink)
    }
  }

  def streamAsSource[R](statement: SqlWithParams)(transform: Row => R): Source[R, Future[NotUsed]] = {
    Source.lazyFutureSource { () =>
      pool.connection().map { conn =>
        Source.fromPublisher(
          conn.statement(statement).stream()(inf)
        ).map(transform).alsoTo(Sink.onComplete(_ => conn.release()))
      }
    }
  }

  def fromSource[T](template: String, source: Source[Vector[Any], T]): Future[Unit] = {
    pool.withConnection { conn =>
      conn.withTransaction {
        conn.statement(template).streamArgsByIdx(
          source.runWith(Sink.asPublisher(fanout = false))
        )
      }
    }
  }

  def rawSelect[R](statement: SqlWithParams): Future[Seq[Row]] = {
    pool.withConnection(_.statement(statement).executeForSet).map(_.rows)
  }

  def rawSelectHead[R](statement: SqlWithParams): Future[Option[Row]] = {
    pool.withConnection(_.statement(statement).executeForFirstRow)
  }

  def rawSelectHeadOpt[R](statement: SqlWithParams): Future[Row] = {
    pool.withConnection(_.statement(statement).executeForFirstRow).map(_.get)
  }

  def rawExec(statement: SqlWithParams): Future[Unit] = {
    pool.withConnection(_.statement(statement).execute)
  }

  def rawExecNum(statement: SqlWithParams): Future[Long] = {
    pool.withConnection(_.statement(statement).executeForRowsAffected)
  }

  def shutdown(): Future[Unit] = pool.shutdown()
}

















