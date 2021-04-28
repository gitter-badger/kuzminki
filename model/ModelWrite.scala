package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


trait ModelWrite {
  def write[T](cols: TypeCol[_]*)(implicit cTag: ClassTag[T], tTag: TypeTag[T]) = {
    RowWriter.create(RowTypeInfo(cols, cTag, tTag))
  }
}