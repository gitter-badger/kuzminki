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


object TupleResults {

  type Res2 = Tuple2[_, _]
  type Res3 = Tuple3[_, _, _]

  implicit val modelColToStringCol: Ex[String] => StringEx = ex => ex.asInstanceOf[StringEx]
  implicit val modelColToIntCol: Ex[Int] => IntEx = ex => ex.asInstanceOf[IntEx]
  implicit val modelColToBooleanCol: Ex[Boolean] => BooleanEx = ex => ex.asInstanceOf[BooleanEx]

  def getTransformer(cols: Seq[Ex[_]]) = {
    cols match {
      case Seq(e1, e2) =>
        new Tuple2Transformer(Tuple2(e1, e2))
      case Seq(e1, e2, e3) =>
        new Tuple3Transformer(Tuple3(e1, e2, e3))
      case _ =>
        throw new Exception("only 2 arguments")
    }
  }
}


trait TupleTransformer[T] {
  def run(row: Row): T
}


class Tuple2Transformer[T1, T2](extractors: Tuple2[Ex[T1], Ex[T2]]) extends TupleTransformer[Tuple2[T1, T2]] {

  def run(row: Row): Tuple2[T1, T2] = {
    extractors match {
      case (e1, e2) =>
        (e1.get(row), e2.get(row))
    }
  }
}

class Tuple3Transformer[T1, T2, T3](extractors: Tuple3[Ex[T1], Ex[T2], Ex[T3]]) extends TupleTransformer[Tuple3[T1, T2, T3]] {

  def run(row: Row): Tuple3[T1, T2, T3] = {
    extractors match {
      case (e1, e2, e3) =>
        (e1.get(row), e2.get(row), e3.get(row))
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

  def asMap() = {
    val transformer = extractors
    exec.select(template, args).map { rows =>
      rows.map(row => transformer.map(ex => ex.get(row)))
    }
  }

  def asTuple() = {
    val transformer = TupleResults.getTransformer(extractors)
    exec.select(template, args).map { rows =>
      rows.map(row => transformer.run(row))
    }
  }

  def asTupleType[T](): Future[List[T]] = {
    val transformer = TupleResults.getTransformer(extractors)
    exec.select(template, args).map { rows =>
      rows.map(row => transformer.run(row).asInstanceOf[T])
    }
  }
}










