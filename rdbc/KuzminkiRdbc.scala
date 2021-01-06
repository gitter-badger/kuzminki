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

import kuzminki.model.select.{Select, SelectJoin}
import kuzminki.model.operation.{Insert, Update, Delete}
import kuzminki.model.aggregate.{Aggregate, AggregateJoin, SubqueryNumber, SubqueryNumberJoin}
import kuzminki.model._
import kuzminki.model.implicits._


class KuzminkiRdbc(conf: SystemConfig)(implicit system: ActorSystem) {

  implicit val ec = system.dispatcher
  implicit val materializer = ActorMaterializer()(system)
  implicit val timeout = 5.seconds.timeout

  val db = new RdbcConn(conf)

  def select[M <: Model](implicit tag: ClassTag[M]) = {
    new Select(Model.from[M], db)
  }

  def select[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
    new SelectJoin(Join(Model.from[A], Model.from[B]), db)
  }

  def insert[M <: Model](implicit tag: ClassTag[M]) = {
    new Insert(Model.from[M], db)
  }

  def update[M <: Model](implicit tag: ClassTag[M]) = {
    new Update(Model.from[M], db)
  }

  def delete[M <: Model](implicit tag: ClassTag[M]) = {
    Delete.from(Model.from[M], db)
  }

  def aggregate[M <: Model](implicit tag: ClassTag[M]) = {
    new Aggregate(Model.from[M], db)
  }

  def aggregate[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
    new AggregateJoin(Join(Model.from[A], Model.from[B]), db)
  }

  def count[M <: Model](implicit tag: ClassTag[M]) = {
    new Aggregate(Model.from[M], db).cols1(t => Count.all)
  }

  def count[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
    new AggregateJoin(Join(Model.from[A], Model.from[B]), db).cols1(t => Count.all)
  }

  // sub query

  def subqueryNumber[M <: Model](implicit tag: ClassTag[M]): SubqueryNumber[M] = {
    subqueryNumber(Model.from[M])
  }

  def subqueryNumber[M <: Model](model: M): SubqueryNumber[M] = {
    new SubqueryNumber(model)
  }

  def subqueryNumber[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]): SubqueryNumberJoin[A, B] = {
    subqueryNumber(Model.from[A], Model.from[B])
  }

  def subqueryNumber[A <: Model, B <: Model](a: A, b: B): SubqueryNumberJoin[A, B] = {
    new SubqueryNumberJoin(Join(a, b))
  }

  def shutdown(): Future[Unit] = db.shutdown()
}






