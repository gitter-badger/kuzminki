package kuzminki.model


class DoUpdate[M, P](model: M, coll: InsertCollector[P], conflictCol: AnyCol) {

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

  private def validate(cols: Seq[AnyCol]): Unit = {

    if (cols.isEmpty) {
      throw KuzminkiException("no update columns selected")
    }

    if (cols.contains(conflictCol)) {
      throw KuzminkiException("cannot update the conflicting column")
    }
  }

  def doUpdate(pick: M => Seq[AnyCol]) = {
    doUpdateApply(
      pick(model)
    )
  }

  def doUpdateOne(pick: M => AnyCol) = {
    doUpdateApply(
      Seq(pick(model))
    )
  }

  private def doUpdateApply(updateCols: Seq[AnyCol]) = {
    validate(updateCols)
    new RunUpsert(
      model,
      Reuse.fromIndex(coll.paramShape.cols, updateCols),
      coll.extend(Array(
        InsertBlankValuesSec(coll.paramShape.size),
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(
          updateCols.map(NoArgMatches(_))
        )
      ))
    )
  }
}












