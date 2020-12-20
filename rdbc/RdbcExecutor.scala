package kuzminki.rdbc

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._
import kuzminki.model._


case class RdbcExecutor(db: RdbcConn, ec: ExecutionContext) extends Executor {

  def select(template: String, args: Seq[Any]): Future[List[Row]] = {
    db.modelSelect(template, args)
  }
}

object Extractor {

  def pick[T](typeCol: TypeCol[T], index: Int): Ex[T] = {
    typeCol match {
      case col: StringCol => StringEx(index)
      case col: IntCol => IntEx(index)
      case col: BooleanCol => BooleanEx(index)
    }
  }
}

trait Ex[T] {
  def get(row: Row): T
}

case class StringEx(index: Int) extends Ex[String] {
  def get(row: Row): String = row.str(index)
}

case class IntEx(index: Int) extends Ex[Int] {
  def get(row: Row): Int = row.int(index)
}

case class BooleanEx(index: Int) extends Ex[Boolean] {
  def get(row: Row): Boolean = row.bool(index)
}


object TupleTransformer {

  implicit val modelColToStringCol: Ex[String] => StringEx = ex => ex.asInstanceOf[StringEx]
  implicit val modelColToIntCol: Ex[Int] => IntEx = ex => ex.asInstanceOf[IntEx]
  implicit val modelColToBooleanCol: Ex[Boolean] => BooleanEx = ex => ex.asInstanceOf[BooleanEx]

  def getTransformer(cols: Seq[Ex[_]]) = {
    cols match {
      case Seq(c1, c2) =>
        new Tuple2Transformer(Tuple2(c1, c2))
      case _ =>
        throw new Exception("only 2 arguments")
    }
  }
}


class Tuple2Transformer[T1, T2](extractors: Tuple2[Ex[T1], Ex[T2]]) {

  def run(row: Row): Tuple2[T1, T2] = {
    extractors match {
      case (e1, e2) =>
        (e1.get(row), e2.get(row))
    }
  }
}


class Results(template: String, args: Seq[Any], cols: Seq[TypeCol[_]], exec: Executor)(implicit ec: ExecutionContext) {

  def select[T](transform: Row => T): Future[List[T]] = {
    exec.select(template, args).map { rows =>
      rows.map(transform)
    }
  }

  def extractors = {
    cols.zipWithIndex.map {
      case (col, index) =>
        Extractor.pick(col, index)
    }
  }

  val rowToSeq: Row => Seq[Any] = row => cols.map(col => extract(col, row))

  val rowToMap: Row => Map[String, Any] = row => cols.map(col => col.name -> extract(col, row)).toMap

  def extract[T](typeCol: TypeCol[T], row: Row): T = {
    typeCol match {
      case col: StringCol => col.get(row)
      case col: IntCol => col.get(row)
      case col: BooleanCol => col.get(row)
    }
  }

  def asSeq() = select(rowToSeq)

  def asMap() = select(rowToMap)

  def asTuple() = {
    val transformer = TupleTransformer.getTransformer(extractors)
    exec.select(template, args).map { rows =>
      rows.map(row => transformer.run(row))
    }
  }
}










