package kuzminki.model.operation

import kuzminki.model._


class Update[M <: Model](model: M, db: Conn) {

  def set(pick: M => Seq[Assign]) = {
    new Where(
      model,
      Collector(
        db,
        Array(
          UpdateSec(ModelTable(model)),
          UpdateSetSec(pick(model))
        )
      )
    )
  }

  def setOne(pick: M => Assign) = {
    new Where(
      model,
      Collector(
        db,
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





















