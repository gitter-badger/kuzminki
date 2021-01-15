package kuzminki.model

import java.time._
import java.util.UUID

import scala.language.implicitConversions
import scala.util.{ Try, Success, Failure }
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import io.rdbc.sapi._


trait AnyCol {
  def resolve(row: Row, index: Int): Any
}

object TypedCol {
  def apply[T: ClassTag] = new TypedCol[T]
}

class TypedCol[T: ClassTag] extends AnyCol {
  def resolve(row: Row, index: Int): T = row.col[T](index)
}

trait RowFormat[T] {
  def resolve(row: Row): T
}

object RowFormater {

  private val stringToCol: String => AnyCol = {
    case "String" => TypedCol[String]
    case "Int" => TypedCol[Int]
    case "Boolean" => TypedCol[Boolean]
    case "Char" => TypedCol[Char]
    case "Short" => TypedCol[Short]
    case "Long" => TypedCol[Long]
    case "BigDecimal" => TypedCol[BigDecimal]
    case "DecimalNumber" => TypedCol[DecimalNumber]
    case "Double" => TypedCol[Double]
    case "Float" => TypedCol[Float]
    case "java.time.Instant" => TypedCol[Instant]
    case "java.time.ZonedDateTime" => TypedCol[ZonedDateTime]
    case "java.time.LocalDateTime" => TypedCol[LocalDateTime]
    case "java.time.LocalDate" => TypedCol[LocalDate]
    case "java.util.UUID" => TypedCol[UUID]
    case name => throw new Exception(s"Unsupported type: $name")
  }

  private def members[T : TypeTag]: Seq[AnyCol] = {
    typeOf[T].members
             .sorted
             .collect { case m: MethodSymbol if m.isCaseAccessor => m }
             .map(_.returnType.toString)
             .toSeq
             .map(stringToCol)
  }
  
  def read[T : ClassTag : TypeTag]: RowFormat[T] = new RowFormater[T](members[T])

}

class RowFormater[T: ClassTag](members: Seq[AnyCol]) extends RowFormat[T] {

  //println("RowFormat", classTag[T].runtimeClass.getName)

  private def args(row: Row): Seq[AnyRef] = {
    members.zipWithIndex.map {
      case (member, index) =>
        member.resolve(row, index).asInstanceOf[AnyRef]
    }
  }

  def resolve(row: Row): T = {
    Try {
      classTag[T].runtimeClass.getConstructors.head.newInstance(args(row): _*).asInstanceOf[T]
    } match {
      case Success(res) => res
      case Failure(ex) =>
        val name = classTag[T].runtimeClass.getName
        val message = ex.getMessage
        throw KuzminkiException(s"Format ($name) $message")
    }
  }
}
