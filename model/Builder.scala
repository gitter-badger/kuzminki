package kuzminki.model

import scala.reflect.ClassTag
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global
import io.rdbc.sapi._
import kuzminki.model.select.{Columns, JoinColumns}
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
}

/*
class Users extends Model("users") {
  def name = column[String]("name")
  def email = column[String]("email")
  def age = column[Int]("age")
}


object Models {
  val user = Model.from[Users]
}
*/