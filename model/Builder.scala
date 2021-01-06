package kuzminki.model

import scala.reflect.ClassTag
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global
import io.rdbc.sapi._
import kuzminki.model.select.{Select, SelectJoin}
import kuzminki.model.operation.{Update, Insert, Delete}
import kuzminki.model.aggregate.{Aggregate, AggregateJoin, SubqueryNumber, SubqueryNumberJoin}
import kuzminki.model.implicits._


object Builder {

  def db(implicit ec: ExecutionContext) = new DummyConn()

  def select[M <: Model](implicit tag: ClassTag[M]) = {
    new Select(Model.from[M], db)
  }

  def select[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
    new SelectJoin(Join(Model.from[A], Model.from[B]), db)
  }

  def update[M <: Model](implicit tag: ClassTag[M]) = {
    new Update(Model.from[M], db)
  }

  def insert[M <: Model](implicit tag: ClassTag[M]) = {
    new Insert(Model.from[M], db)
  }

  def delete[M <: Model](implicit tag: ClassTag[M]) = {
    Delete.from(Model.from[M], db)
  }

  def aggregate[M <: Model](implicit tag: ClassTag[M]) = {
    new Aggregate(Model.from[M], db).cols1(t => Count.all)
  }
  
  def aggregate[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
    new AggregateJoin(Join(Model.from[A], Model.from[B]), db)
  }

  def count[M <: Model](implicit tag: ClassTag[M]) = {
    new Aggregate(Model.from[M], db).cols1(t => Count.all)
  }
  
  def count[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
    new AggregateJoin(Join(Model.from[A], Model.from[B]), db)
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
}









