package kuzminki.model

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


class Conn(conf: SystemConfig)(implicit system: ActorSystem) extends LazyLogging {

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

  def insertStream(template: String, source: Source[Vector[Any], NotUsed]): Future[Unit] = {
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


class RdbcOldConn(conf: SystemConfig)(implicit system: ActorSystem) extends LazyLogging {

  logger.info("Start")

  implicit val ec = system.dispatcher
  implicit val materializer = ActorMaterializer()(system)
  implicit val timeout = 5.seconds.timeout

  private val inf = Timeout(Duration.Inf)

  private val pool = RdbcPool.forConfig(conf, system.dispatcher)

  private def transformError(message: String, statement: SqlWithParams): KuzminkiException = {
    val localFormat = s"Query ($message) \n [${statement.sql}]"
    logger.error(localFormat)
    KuzminkiException(localFormat)
  }

  private def noArgs(statement: String) = SqlWithParams(statement, Vector.empty[Any])

  // model

  def select(statement: SqlWithParams): Future[List[Row]] = {
    pool.withConnection(_.statement(statement).executeForSet).map(_.toList)
  }

  // find

  def find(statement: SqlWithParams): ResponseData = {
    ResponseData(
      pool.withConnection(_.statement(statement).executeForSet).map(_.toList).recover {
        case ex: Exception => throw transformError(ex.getMessage, statement)
      }
    )
  }

  def find(statement: String): ResponseData = find(noArgs(statement))

  // count

  def count(statement: SqlWithParams): Future[Int] = {
    pool.withConnection(_.statement(statement).executeForSet).map { rows =>
      Try {
        rows.toList.head.col[Int]("count")
      } match {
        case Success(num) => num
        case Failure(ex) => throw new Exception("invalid statement for count")
      }
    }.recover {
      case ex: Exception => throw transformError(ex.getMessage, statement)
    }
  }

  def count(statement: String): Future[Int] = count(noArgs(statement))

  // exec

  def exec(statement: SqlWithParams): Future[Unit] = {
    pool.withConnection(_.statement(statement).execute).recover {
      case ex: Exception => throw transformError(ex.getMessage, statement)
    }
  }

  def exec(statement: String): Future[Unit] = exec(noArgs(statement))

  // execNum

  def execNum(statement: SqlWithParams): Future[Long] = {
    pool.withConnection(_.statement(statement).executeForRowsAffected).recover {
      case ex: Exception => throw transformError(ex.getMessage, statement)
    }
  }

  def execNum(statement: String): Future[Long] = execNum(noArgs(statement))

  // stream

  def stream(statement: SqlWithParams)(dest: Row => Unit): Future[Done] = {
    pool.withConnection { conn =>
      Source.fromPublisher(
        conn.statement(statement).stream()(inf)
      ).runWith(Sink.foreach(dest(_)))
    }.recover {
      case ex: Exception => throw transformError(ex.getMessage, statement)
    }
  }

  def stream(statement: String)(dest: Row => Unit): Future[Done] = {
    stream(noArgs(statement))(dest)
  }

  // streamCount

  def streamCount(statement: SqlWithParams)(dest: Row => Unit) = {
    var counter = 0
    pool.withConnection { conn =>
      Source.fromPublisher(
        conn.statement(statement).stream()(inf)
      ).runWith(Sink.foreach { row =>
        counter += 1
        dest(row)
      }) 
    }.map(_ => counter)
  }

  def shutdown(): Future[Unit] = pool.shutdown()
}























