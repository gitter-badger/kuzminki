package kuzminki.model.operation

import kuzminki.model._


object Delete {

  def from[M <: Model](model: M, conn: Conn) = {
    new Where(
      model,
      OperationCollector(
        conn,
        Array(
          DeleteFromSec(ModelTable(model))
        )
      )
    )
  }
}