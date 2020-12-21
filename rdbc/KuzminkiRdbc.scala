package kuzminki.rdbc

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.util.{Try, Success, Failure}
import scala.concurrent.duration._
import scala.reflect.ClassTag

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

import kuzminki.model.select._
import kuzminki.model._
import kuzminki.model.implicits._


class KuzminkiRdbc(conf: SystemConfig)(implicit system: ActorSystem) {

  implicit val ec = system.dispatcher
  implicit val materializer = ActorMaterializer()(system)
  implicit val timeout = 5.seconds.timeout

  val db = new RdbcConn(conf)
  val conn = Connection(db, ec)

  def select[M <: Model](implicit tag: ClassTag[M]) = {
    new Columns(Model.from[M], conn)
  }

  /*
  def select[M <: Model](cols: M => Seq[ModelCol])(implicit tag: ClassTag[M]): ModelSelectStages.Columns[M] = {
    new ModelSelect[M](Model.from[M], exec)
  }
  */

  def shutdown(): Future[Unit] = db.shutdown()
}






