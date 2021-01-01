package kuzminki.model.operation

import kuzminki.model._


object Delete {

  def from[M <: Model](model: M, conn: Conn) = {
    new Where(
      model,
      Collector(
        conn,
        Array(
          DeleteFromSec(ModelTable(model))
        )
      )
    )
  }
}