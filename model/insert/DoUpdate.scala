package kuzminki.model.insert

import kuzminki.model._


class DoUpdate[M, S](model: M, coll: InsertCollector[S], conflictCol: ModelCol) {

  def doNothing = {
    new RunInsertDoNothing(
      model,
      coll.extend(Array(
        InsertBlankValuesSec(coll.shape.size),
        InsertOnConflictColumnSec(conflictCol),
        InsertDoNothingSec
      ))
    )
  }

  private def validate(cols: Seq[ModelCol]): Unit = {

    if (cols.isEmpty) {
      throw KuzminkiException("no update columns selected")
    }

    if (cols.contains(conflictCol)) {
      throw KuzminkiException("cannot update the conflicting column")
    }
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
    validate(updateCols)
    new RunUpsert(
      model,
      Reuse.fromIndex(coll.shape.cols, updateCols),
      coll.extend(Array(
        InsertBlankValuesSec(coll.shape.size),
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(
          updateCols.map(NoArgMatches(_))
        )
      ))
    )
  }
}












