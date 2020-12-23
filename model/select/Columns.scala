package kuzminki.model.select

import kuzminki.model._


case class Columns[M <: Model](model: M, conn: Connection) extends TupleCols[M] {

  def cols(pick: M => Seq[TypeCol[_]]) = {
    new standard.Where(
      Collector.standard(
        model,
        pick(model),
        conn
      )
    )
  }
}


case class JoinColumns[A <: Model, B <: Model](join: Join[A, B], conn: Connection) extends TupleJoinCols[A, B] {

  def cols(pick: Join[A, B] => Seq[TypeCol[_]]) = {
    new standardJoin.Where(
      Collector.standardJoin(
        join,
        pick(join),
        conn
      )
    )
  }
}