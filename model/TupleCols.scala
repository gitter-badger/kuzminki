package kuzminki.model.select

import kuzminki.model._


abstract class TupleCols[T <: Model](model: T, exec: Executor) {

  def tupleCols[A1, A2](pick: T => Tuple2[TypeCol[A1], TypeCol[A2]]) = {
    new Where(
      Collector.create(
        model,
        Tuple2Cols(pick(model)),
        exec
      )
    )
  }
}
