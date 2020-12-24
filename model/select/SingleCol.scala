package kuzminki.model

import io.rdbc.sapi._
import kuzminki.model._
import kuzminki.model.implicits._

  
case class SingleCol[T](col: TypeCol[T]) extends TupleTransformer[T] {

  def toSeq: Seq[ModelCol] = Seq(col)

  def transform(row: Row): T = col.get(row)
}