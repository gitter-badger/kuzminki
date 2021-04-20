package kuzminki.model


object Delete {

  def from[M <: Model](model: M, conn: Conn) = {
    new OperationWhere(
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