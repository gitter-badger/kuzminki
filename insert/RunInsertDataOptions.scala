package kuzminki.model


class RunInsertDataOptions[M <: Model](
      model: M,
      coll: InsertDataCollector
    ) extends RunInsertData(coll) {

  def onConflictDoNothing = {
    new RunInsertData(
      coll.extend(Array(
        InsertOnConflictSec,
        InsertDoNothingSec
      ))
    )
  }

  def onConflictOnColumn(pick: M => ModelCol) = {
    new DoUpdateData(
      model,
      coll,
      pick(model)
    )
  }
}



