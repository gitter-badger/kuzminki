package kuzminki

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

import kuzminki.model._
import kuzminki.model.implicits._


class Kuzminki(conf: SystemConfig)(implicit system: ActorSystem) {

  implicit val ec = system.dispatcher
  implicit val materializer = ActorMaterializer()(system)
  implicit val timeout = 5.seconds.timeout

  val db = new Conn(conf)

  def select[M <: Model](model: M): Select[M] = {
    new Select(model, db)
  }

  def select[A <: Model, B <: Model](a: A, b: B): SelectJoin[A, B] = {
    select(DefaultJoin(a, b))
  }

  def select[A <: Model, B <: Model](join: Join[A, B]): SelectJoin[A, B] = {
    new SelectJoin(join, db)
  }

  def insert[M <: Model](model: M): Insert[M] = {
    new Insert(model, db)
  }

  def update[M <: Model](model: M): Update[M] = {
    new Update(model, db)
  }

  def delete[M <: Model](model: M): OperationWhere[M] = {
    Delete.from(model, db)
  }

  def count[M <: Model](model: M): Where[M, Long] = {
    new Select(model, db).cols1(t => Count.all)
  }

  def count[A <: Model, B <: Model](a: A, b: B): JoinOn[A, B, Long] = {
    count(DefaultJoin(a, b))
  }

  def count[A <: Model, B <: Model](join: Join[A, B]): JoinOn[A, B, Long] = {
    new SelectJoin(join, db).cols1(t => Count.all)
  }

  def shutdown(): Future[Unit] = db.shutdown()
}






