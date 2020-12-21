package kuzminki.model.select

import kuzminki.model._


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
}