package kuzminki.model

import java.time._
import java.util.UUID

import scala.language.implicitConversions
import scala.util.{ Try, Success, Failure }
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import io.rdbc.sapi.Row


object RowReader { 

  private val colStringType: ModelCol => String = {
    case col: StringCol        => "String"
    case col: BooleanCol       => "Boolean"
    case col: ShortCol         => "Short"
    case col: IntCol           => "Int"
    case col: LongCol          => "Long"
    case col: FloatCol         => "Float"
    case col: DoubleCol        => "Double"
    case col: DecimalNumberCol => "String"
    case col: BigDecimalCol    => "BigDecimal"
    case col => throw KuzminkiModelException(s"Unsupported column type: [$col]")
  }

  private val cleanString: String => String = {
    case "java.time.Instant" => "Instant"
    case "java.time.ZonedDateTime" => "ZonedDateTime"
    case "java.time.LocalDateTime" => "LocalDateTime"
    case "java.time.LocalDate" => "LocalDate"
    case "java.util.UUID" => "UUID"
    case name => name
  }

  private def productMembers[T](implicit tag: TypeTag[T]) = {
    typeOf[T]
      .members
      .sorted
      .collect { case m: MethodSymbol if m.isCaseAccessor => m }
      .map(_.returnType.toString)
      .toSeq
      .map(cleanString)
  }

  def create[M <: Model, T <: Product](pick: M => Seq[TypeCol[_]])(implicit mTag: ClassTag[M], cTag: ClassTag[T], tTag: TypeTag[T]) = {
    
    val model = Model.from[M]
    val cols = pick(model)
    
    val colTypes = cols.map(colStringType)
    val memberTypes = productMembers(tTag)

    if (colTypes != memberTypes) {
      throw KuzminkiModelException(
        Seq(
          "RowReader error",
          "Column types: (%s)".format(colTypes.mkString(", ")),
          "Type members: (%s)".format(memberTypes.mkString(", "))
        ).mkString("\n")
      )
    }

    new RowReader(cols)(cTag)
  }
}


class RowReader[R](val cols: Seq[TypeCol[_]])(implicit tag: ClassTag[R]) extends RowShape[R] {

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
        throw KuzminkiModelException(s"Failed to read ($name) $message")
    }
  }
}




/*

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

*/


























