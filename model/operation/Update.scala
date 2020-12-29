package kuzminki.model.operation

import kuzminki.model._


class Update[M <: Model](model: M, conn: Connection) {

  def set(pick: M => Seq[Assign]) = {
    new Where(
      OperationCollector(
        model,
        conn,
        Array(
          UpdateSec(ModelTable(model)),
          UpdateSetSec(pick(model))
        )
      )
    )
  }

  def setOne(pick: M => Assign) = {
    new Where(
      OperationCollector(
        model,
        conn,
        Array(
          UpdateSec(ModelTable(model)),
          UpdateSetSec(
            Seq(pick(model))
          )
        )
      )
    )
  }
}





















