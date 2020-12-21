package kuzminki.model.select

import kuzminki.model._


trait TupleCols[M <: Model] {

  val model: M

  def tupledWhere[R](transformer: TupleTransformer[R]): tupled.Where[M, R]

  def cols2[A1, A2](pick: M => Tuple2[TypeCol[A1], TypeCol[A2]]) = {
    tupledWhere(Tuple2Cols(pick(model)))
  }

  def cols3[A1, A2, A3](pick: M => Tuple3[TypeCol[A1], TypeCol[A2], TypeCol[A3]]) = {
    tupledWhere(Tuple3Cols(pick(model)))
  }
}


case class Columns[M <: Model](model: M, conn: Connection) extends TupleCols[M] {

  def cols(pick: M => Seq[TypeCol[_]]) = {
    new standard.Where(
      SeqCollector.create(
        model,
        pick(model),
        conn
      )
    )
  }

  def tupledWhere[R](transformer: TupleTransformer[R]) = {
    new tupled.Where(
      TupleCollector.create(
        model,
        transformer,
        conn
      )
    )
  }
}