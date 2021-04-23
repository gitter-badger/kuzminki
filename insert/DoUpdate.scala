package kuzminki.model


class DoUpdate[M, P](
      model: M,
      coll: InsertCollector[P],
      conflictCol: ModelCol
    ) extends ValidateUpsert {

  def doNothing = {
    new RunInsertDoNothing(
      model,
      coll.extend(Array(
        InsertBlankValuesSec(coll.paramShape.size),
        InsertOnConflictColumnSec(conflictCol),
        InsertDoNothingSec
      ))
    )
  }

  def doUpdate(pick: M => Seq[ModelCol]) = {
    doUpdateApply(
      pick(model)
    )
  }

  def doUpdateOne(pick: M => ModelCol) = {
    doUpdateApply(
      Seq(pick(model))
    )
  }

  private def doUpdateApply(updateCols: Seq[ModelCol]) = {
    validate(conflictCol, updateCols)
    new RunUpsert(
      model,
      Reuse.fromIndex(coll.paramShape.cols, updateCols),
      coll.extend(Array(
        InsertBlankValuesSec(coll.paramShape.size),
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateNoArgsSec(updateCols.map(SetUpsert(_)))
      ))
    )
  }
}












