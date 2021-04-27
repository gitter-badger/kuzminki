package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


trait ModelRead {
  def read[T](cols: TypeCol[_]*)(implicit cTag: ClassTag[T], tTag: TypeTag[T]) = {
    RowReader.create(RowTypeInfo(cols, cTag, tTag))
  }
}