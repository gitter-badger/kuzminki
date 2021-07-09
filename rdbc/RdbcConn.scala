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

import org.reactivestreams.Publisher

import scala.concurrent.ExecutionContext
import scala.concurrent.{Future, Promise}
import scala.util.{Try, Success, Failure}
import scala.concurrent.duration._

import com.typesafe.config.{Config => SystemConfig, ConfigFactory => SystemConfigFactory}
import com.typesafe.scalalogging.LazyLogging

import akka.stream.scaladsl._
import akka.stream.ActorMaterializer
import akka.actor.{ActorRef, ActorSystem}
import akka.{NotUsed, Done}

import io.rdbc.sapi._

import io.rdbc.pgsql.core.config.sapi.Auth
import io.rdbc.pgsql.transport.netty.sapi.NettyPgConnectionFactory
import io.rdbc.pgsql.transport.netty.sapi.NettyPgConnectionFactory.Config

import io.rdbc.pool.sapi.ConnectionPool
import io.rdbc.pool.sapi.ConnectionPoolConfig

import org.reactivestreams.Publisher

//import kuzminki.model.Conn

//import transport.actions.{Action, Batch}



object RdbcPool {

  def forConfig(conf: SystemConfig, ec: ExecutionContext): ConnectionPool = {
    
    val host = conf.getString("host")
    val port = conf.getInt("port")
    val user = conf.getString("user")
    val pwd = conf.getString("password")
    val db = conf.getString("db")
    val threads = conf.getInt("threads")

    val dbConfig = Config(host, port, Auth.password(user, pwd), Some(db))
    
    val poolConfig = ConnectionPoolConfig(
      name = s"${db}-pool",
      size = threads,
      ec = ec
    )

    ConnectionPool(NettyPgConnectionFactory(dbConfig), poolConfig)
  }
}


class Driver(conf: SystemConfig)(implicit system: ActorSystem) extends LazyLogging {

  logger.info("Start")

  implicit val ec = system.dispatcher
  implicit val materializer = ActorMaterializer()(system)
  implicit val timeout = 5.seconds.timeout

  private val inf = Timeout(Duration.Inf)

  private val pool = RdbcPool.forConfig(conf, system.dispatcher)

  def select[R](statement: SqlWithParams)(transform: Row => R): Future[List[R]] = {
    pool.withConnection(_.statement(statement).executeForSet).map(_.toList).map { rows =>
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
        ).map(transform)
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

  def shutdown(): Future[Unit] = pool.shutdown()
}

















