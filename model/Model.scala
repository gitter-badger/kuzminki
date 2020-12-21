package kuzminki.model

import scala.reflect.ClassTag


case class Join[A <: Model, B <: Model](a: A, b: B) {
  a.__prefix = Some("a")
  b.__prefix = Some("b")
  def left = a
  def right = b
}


object Model {
  def from[M <: Model](implicit tag: ClassTag[M]): M = {
    tag.runtimeClass.newInstance.asInstanceOf[M]
  }
}

abstract class Model(val __name: String) {

  var __prefix: Option[String] = None

  def column[T](name: String)(implicit creator: ColConf => TypeCol[T]) = {
    creator(ColConf(name, this))
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

















