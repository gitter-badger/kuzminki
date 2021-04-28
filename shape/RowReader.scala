package kuzminki.model

import scala.language.implicitConversions
import scala.util.{ Try, Success, Failure }
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


object RowReader extends RowTypeNames { 

  def create[T](rti: RowTypeInfo[T]) = {
    validate(rti)
    new RowReader(rti.cols, rti.cTag)
  }
}


class RowReader[R](val cols: Seq[TypeCol[_]], tag: ClassTag[R]) extends RowShape[R] {
  def conv = new RowConvReader(cols.map(_.conv))(tag)
}

























