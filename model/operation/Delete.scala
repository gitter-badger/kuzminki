package kuzminki.model.operation

import kuzminki.model._


object Delete {

  def from[M <: Model](model: M, conn: Connection) = {
    new Where(
      OperationCollector(
        model,
        conn,
        Array(
          DeleteFromSec(ModelTable(model))
        )
      )
    )
  }
}