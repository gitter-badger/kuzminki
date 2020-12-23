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

  def col(pick: M => TypeCol[_]) = {
    new tupled.Where(
      Collector.tuple(
        model,
        SingleCol(pick(model)),
        conn
      )
    )
  }
}


case class JoinColumns[A <: Model, B <: Model](join: Join[A, B], conn: Connection) extends TupleJoinCols[A, B] {

  def cols(pick: Join[A, B] => Seq[TypeCol[_]]) = {
    new standardJoin.JoinOn(
      Collector.standardJoin(
        join,
        pick(join),
        conn
      )
    )
  }

  def col(pick: Join[A, B] => TypeCol[_]) = {
    new tupledJoin.Where(
      Collector.tupleJoin(
        join,
        SingleCol(pick(join)),
        conn
      )
    )
  }
}