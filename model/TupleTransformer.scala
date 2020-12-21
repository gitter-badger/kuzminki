package kuzminki.model.select

import io.rdbc.sapi._
import kuzminki.model._
import kuzminki.model.implicits._


trait TupleTransformer[T] {
  def toSeq: Seq[ModelCol]
  def transform(row: Row): T
}


case class Tuple2Cols[A1, A2](cols: Tuple2[TypeCol[A1], TypeCol[A2]]) extends TupleTransformer[Tuple2[A1, A2]] {

  def toSeq = {
    cols match {
      case (col1, col2) => Seq(col1, col2)
    }
  }

  def transform(row: Row) = {
    cols match {
      case (col1, col2) => (col1.get(row), col2.get(row))
    }
  }
}

case class Tuple3Cols[A1, A2, A3](cols: Tuple3[TypeCol[A1],
                                          TypeCol[A2],
                                          TypeCol[A3]]) extends TupleTransformer[Tuple3[A1, A2, A3]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3) => Seq(col1, col2, col3)
    }
  }

  def transform(row: Row) = {
    cols match {
      case (col1, col2, col3) => (col1.get(row), col2.get(row), col3.get(row))
    }
  }
}

case class Tuple4Cols[A1, A2, A3, A4](cols: Tuple4[TypeCol[A1],
                                          TypeCol[A2],
                                          TypeCol[A3],
                                          TypeCol[A4]]) extends TupleTransformer[Tuple4[A1, A2, A3, A4]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4) => Seq(col1, col2, col3, col4)
    }
  }

  def transform(row: Row) = {
    cols match {
      case (col1, col2, col3, col4) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row))
    }
  }
}


