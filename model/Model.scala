package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


object Model {
  
  def from[M <: Model](implicit tag: ClassTag[M]): M = {
    tag.runtimeClass.newInstance.asInstanceOf[M]
  }

  def join[A <: Model, B <: Model](implicit aTag: ClassTag[A], bTag: ClassTag[B]) = {
    new DefaultJoin(from[A], from[B])
  }
}

abstract class Model(val __name: String) extends ModelRead {

  def column[T](name: String)(implicit creator: ColInfo => TypeCol[T]) = {
    creator(ColInfo(name, __name))
  }
}


















