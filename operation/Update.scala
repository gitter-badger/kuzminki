package kuzminki.model


class Update[M <: Model](model: M, db: Conn) {

  def set(pick: M => Seq[Assign]) = {
    new OperationWhere(
      model,
      OperationCollector(
        db,
        Array(
          UpdateSec(ModelTable(model)),
          UpdateSetSec(pick(model))
        )
      )
    )
  }

  def setOne(pick: M => Assign) = {
    new OperationWhere(
      model,
      OperationCollector(
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





















