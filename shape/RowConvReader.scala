package kuzminki.model

import scala.language.implicitConversions
import scala.util.{ Try, Success, Failure }
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import io.rdbc.sapi.Row


class RowConvReader[R](val cols: Seq[ValConv[_]])(implicit tag: ClassTag[R]) extends RowConv[R] {

  private val indexedCols = cols.zipWithIndex

  private def read(row: Row): Seq[AnyRef] = {
    indexedCols.map {
      case (col, index) =>
        col.get(row, index).asInstanceOf[AnyRef]
    }
  }

  def fromRow(row: Row) = {
    Try {
      
      classTag[R]
        .runtimeClass
        .getConstructors
        .head
        .newInstance(read(row): _*)
        .asInstanceOf[R]
    
    } match {
      case Success(res) => res
      case Failure(ex) =>
        val name = classTag[R].runtimeClass.getName
        val message = ex.getMessage
        throw KuzminkiException(
          s"Failed to read ($name) $message"
        )
    }
  }
}