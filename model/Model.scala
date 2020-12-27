package kuzminki.model

import scala.reflect.ClassTag


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


















