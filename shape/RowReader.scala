package kuzminki.model

import java.time._
import java.util.UUID

import scala.language.implicitConversions
import scala.util.{ Try, Success, Failure }
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import io.rdbc.sapi.Row


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


object RowWriter extends RowTypeNames {

  def create[T](rti: RowTypeInfo[T]) = {
    validate(rti)
    new RowWriter(rti.cols, rti.cTag)
  }
}


class RowWriter[P](val cols: Seq[TypeCol[_]], tag: ClassTag[P]) extends ParamConv[P] {

  def fromShape(product: P): Vector[Any] = {
    product.getClass.getDeclaredFields.map { f =>
      f.setAccessible(true)
      val value = f.get(product)
      f.setAccessible(false)
      value
    }.toVector
  }
}


object RowReader extends RowTypeNames { 

  def create[T](rti: RowTypeInfo[T]) = {
    validate(rti)
    new RowReader(rti.cols, rti.cTag)
  }
}


class RowReader[R](val cols: Seq[TypeCol[_]], tag: ClassTag[R]) extends RowShape[R] {
  def conv = new RowConvReader(cols.map(_.conv))(tag)
}


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



/*
class AsReader[M](cols: Seq[TypeCol[_]], mTag: ClassTag[M]) {

    def as[T](implicit cTag: ClassTag[T], tTag: TypeTag[T]) = {
      create(cols, mTag, cTag, tTag)
    }
  }

  class PickCols[M](model: M, mTag: ClassTag[M]) {

    def cols(pick: M => Seq[TypeCol[_]]) = {
      new AsReader(pick(model), mTag)
    }
  }

  def model[M <: Model](implicit mTag: ClassTag[M]) = {
    val model = Model.from[M]
    new PickCols(model, mTag)
  }

  def model[M <: Model](model: M)(implicit mTag: ClassTag[M]) = {
    new PickCols(model, mTag)
  }

  class ModelCreate[M](mTag: ClassTag[M]) {

    def createFrom[T](cols: Seq[TypeCol[_]], cTag: ClassTag[T], tTag: TypeTag[T]) = {
      create(cols, mTag, cTag, tTag)
    }
  }  

  def modelTag[M >: Model](model: M)(implicit mTag: ClassTag[M]) = {
    println("< - - - >")
    println(model.getClass.getName)
    println(mTag)
    println("< - - - >")
    new ModelCreate(mTag)
  }
  */



















