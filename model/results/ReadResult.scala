package kuzminki.model

import java.time._
import java.util.UUID

import scala.language.implicitConversions
import scala.util.{ Try, Success, Failure }
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import io.rdbc.sapi._


trait AnyMember {
  def resolve(row: Row, index: Int): Any
}

class TypedMember[T : ClassTag] extends AnyMember {
  def resolve(row: Row, index: Int): T = row.col[T](index)
}

object RowReader {

  private val standardName: String => String = {
    case "java.time.Instant" => "Instant"
    case "java.time.ZonedDateTime" => "ZonedDateTime"
    case "java.time.LocalDateTime" => "LocalDateTime"
    case "java.time.LocalDate" => "LocalDate"
    case "java.util.UUID" => "UUID"
    case name => name
  }  

  private val stringToMember: String => AnyMember = {
    case "String" => new TypedMember[String]
    case "Int" => new TypedMember[Int]
    case "Boolean" => new TypedMember[Boolean]
    case "Char" => new TypedMember[Char]
    case "Short" => new TypedMember[Short]
    case "Long" => new TypedMember[Long]
    case "BigDecimal" => new TypedMember[BigDecimal]
    case "DecimalNumber" => new TypedMember[DecimalNumber]
    case "Double" => new TypedMember[Double]
    case "Float" => new TypedMember[Float]
    case "java.time.Instant" => new TypedMember[Instant]
    case "java.time.ZonedDateTime" => new TypedMember[ZonedDateTime]
    case "java.time.LocalDateTime" => new TypedMember[LocalDateTime]
    case "java.time.LocalDate" => new TypedMember[LocalDate]
    case "java.util.UUID" => new TypedMember[UUID]
    case name => throw KuzminkiModelException(s"Unsupported type: $name")
  }

  private val modelColTypeName: ModelCol => String = {
    case c: StringColValue => "String"
    case c: BooleanColValue => "Boolean"
    case c: ShortColValue => "Short"
    case c: IntColValue => "Int"
    case c: LongColValue => "Long"
    case c: FloatColValue => "Float"
    case c: DoubleColValue => "Double"
    case c: DecimalNumberColValue => "DecimalNumber"
    case c: BigDecimalColValue => "BigDecimal"
    case c => throw KuzminkiModelException("Unsupported column (%s)".format(c.getClass.getName))
  }

  def getQueryTypes(cols: Seq[ModelCol]) = cols.map(modelColTypeName)

  private def getMemberTypes[T : TypeTag]: Seq[String] = {
    typeOf[T].members
             .sorted
             .collect { case m: MethodSymbol if m.isCaseAccessor => m }
             .map(_.returnType.toString)
             .toSeq
             .map(standardName)
  }
  
  def create[T : ClassTag : TypeTag](cols: Seq[ModelCol]): RowRead[T] = {

    val queryTypes = getQueryTypes(cols)
    val memberTypes = getMemberTypes[T]

    if (queryTypes != memberTypes) {
      throw KuzminkiModelException(
        Seq(
          "Data type does not match query result",
          "    Found: (%s)".format(memberTypes).mkString(", "),
          "    Expecting: (%s)".format(queryTypes).mkString(", ")
        ).mkString("\n")
      )
    }

    val members = memberTypes.map(stringToMember)

    new RowReader[T](members)
  }
}

trait RowRead[T] {
  def read(row: Row): T
}

class RowReader[T : ClassTag](members: Seq[AnyMember]) extends RowRead[T] {

  //println("RowFormat", classTag[T].runtimeClass.getName)

  private def args(row: Row): Seq[AnyRef] = {
    members.zipWithIndex.map {
      case (member, index) =>
        member.resolve(row, index).asInstanceOf[AnyRef]
    }
  }

  def read(row: Row): T = {
    Try {
      
      classTag[T]
        .runtimeClass
        .getConstructors
        .head
        .newInstance(args(row): _*)
        .asInstanceOf[T]
    
    } match {
      case Success(res) => res
      case Failure(ex) =>
        val name = classTag[T].runtimeClass.getName
        val message = ex.getMessage
        throw KuzminkiModelException(s"Failed to read ($name) $message")
    }
  }
}




