package kuzminki.model

import scala.reflect.ClassTag
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global
import io.rdbc.sapi._
import kuzminki.model.select.{Columns, JoinColumns}
import kuzminki.model.operation.{Update, Insert, Delete}
import kuzminki.model.count.Count
import kuzminki.model.implicits._


object Builder {

  def conn(implicit ec: ExecutionContext) = {
    Connection(new DummyConn(), ec)
  }

  def select[M <: Model](implicit tag: ClassTag[M]) = {
    new Columns(Model.from[M], conn)
  }

  def select[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
    new JoinColumns(Join(Model.from[A], Model.from[B]), conn)
  }

  def update[M <: Model](implicit tag: ClassTag[M]) = {
    new Update(Model.from[M], conn)
  }

  def insert[M <: Model](implicit tag: ClassTag[M]) = {
    new Insert(Model.from[M], conn)
  }

  def delete[M <: Model](implicit tag: ClassTag[M]) = {
    Delete.from(Model.from[M], conn)
  }

  def count[M <: Model](implicit tag: ClassTag[M]) = {
    Count.from(Model.from[M], conn)
  }

  def count[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
    Count.fromJoin(Join(Model.from[A], Model.from[B]), conn)
  }
}






