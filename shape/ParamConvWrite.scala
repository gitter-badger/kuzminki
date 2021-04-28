package kuzminki.model

import scala.reflect.{classTag, ClassTag}


class ParamConvWrite[P](tag: ClassTag[P]) extends ParamConv[P] {

  def fromShape(product: P): Vector[Any] = {
    product.getClass.getDeclaredFields.map { f =>
      f.setAccessible(true)
      val value = f.get(product)
      f.setAccessible(false)
      value
    }.toVector
  }
}