package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


object Model {
  
  def from[M <: Model](implicit tag: ClassTag[M]): M = {
    tag.runtimeClass.newInstance.asInstanceOf[M]
  }

  def join[A <: Model, B <: Model] = new AnyJoin[A, B]
}

abstract class Model(val __name: String) extends ModelRead {

  var __prefix: Option[String] = None

  def column[T](name: String)(implicit creator: ColConf => TypeCol[T]) = {
    creator(ColConf(name, this))
  }
}


















