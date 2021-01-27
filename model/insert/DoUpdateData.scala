package kuzminki.model


class DoUpdateData[M](
      model: M,
      coll: InsertDataCollector,
      conflictCol: ModelCol
    ) extends ValidateUpsert {

  def doNothing = {
    new RunInsertData(
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoNothingSec
      ))
    )
  }

  def doUpdate(pick: M => Seq[SetValue]) = {
    doUpdateApply(
      pick(model)
    )
  }

  def doUpdateOne(pick: M => SetValue) = {
    doUpdateApply(
      Seq(pick(model))
    )
  }

  private def doUpdateApply(changes: Seq[SetValue]) = {
    validate(conflictCol, changes.map(_.col))
    new RunInsertData(
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(changes)
      ))
    )
  }
}