package kuzminki.model

import scala.language.implicitConversions
import scala.util.{ Try, Success, Failure }
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


trait RowTypeNames {

  protected val colTypeName: TypeCol[_] => String = {
    case col: StringCol         => "String"
    case col: BooleanCol        => "Boolean"
    case col: ShortCol          => "Short"
    case col: IntCol            => "Int"
    case col: LongCol           => "Long"
    case col: FloatCol          => "Float"
    case col: DoubleCol         => "Double"
    case col: DecimalNumberCol  => "String"
    case col: BigDecimalCol     => "BigDecimal"
    case col: InstantCol        => "Instant"
    case col: ZonedDateTimeCol  => "ZonedDateTime"
    case col: LocalDateTimeCol  => "LocalDateTime"
    case col: LocalDateCol      => "LocalDate"
    case col: UUIDCol           => "UUID"
    case col => throw KuzminkiException(s"Unsupported column type: [$col]")
  }

  protected val simplifyName: String => String = {
    case "java.time.Instant"        => "Instant"
    case "java.time.ZonedDateTime"  => "ZonedDateTime"
    case "java.time.LocalDateTime"  => "LocalDateTime"
    case "java.time.LocalDate"      => "LocalDate"
    case "java.util.UUID"           => "UUID"
    case name                       => name
  }

  protected def productTypeNames[T](implicit tag: TypeTag[T]) = {
    typeOf[T]
      .members
      .sorted
      .collect { case m: MethodSymbol if m.isCaseAccessor => m }
      .map(_.returnType.toString)
      .toSeq
      .map(simplifyName)
  }

  protected def validate[T](rti: RowTypeInfo[T]) = {

    val colTypeNames = rti.cols.map(colTypeName)
    val memberTypeNames = productTypeNames(rti.tTag)

    if (colTypeNames != memberTypeNames) {
      throw KuzminkiException(
        Seq(
          "Read error",
          "Column types: (%s)".format(colTypeNames.mkString(", ")),
          "Type members: (%s)".format(memberTypeNames.mkString(", "))
        ).mkString("\n")
      )
    }
  }
}