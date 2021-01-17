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
    case "java.time.Instant"       => "Instant"
    case "java.time.ZonedDateTime" => "ZonedDateTime"
    case "java.time.LocalDateTime" => "LocalDateTime"
    case "java.time.LocalDate"     => "LocalDate"
    case "java.util.UUID"          => "UUID"
    case name                      => name
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

  def create[T](
        cols: Seq[TypeCol[_]],
        cTag: ClassTag[T],
        tTag: TypeTag[T]
      ) = {
    
    val colTypes = cols.map(colStringType)
    val memberTypes = productMembers(tTag)

    if (colTypes != memberTypes) {
      throw KuzminkiModelException(
        Seq(
          "Read error",
          "Column types: (%s)".format(colTypes.mkString(", ")),
          "Type members: (%s)".format(memberTypes.mkString(", "))
        ).mkString("\n")
      )
    }

    new RowReader(cols)(cTag)
  }
}


class RowReader[R](val cols: Seq[TypeCol[_]])
                  (implicit tag: ClassTag[R]) extends RowShape[R] {

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
        throw KuzminkiModelException(
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



















