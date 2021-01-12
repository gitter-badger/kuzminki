package kuzminki.model.insert

import kuzminki.model._


class DoUpdate[M, S](model: M, coll: InsertCollector[S], conflictCol: ModelCol) {

  def doNothing = {
    new RunUpsert(
      model,
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoNothingSec
      ))
    )
  }

  private def validate(cols: Seq[ModelCol]): Unit = {

    if (cols.isEmpty) {
      throw KuzminkiModelException("no update columns selected")
    }

    if (cols.contains(conflictCol)) {
      throw KuzminkiModelException("cannot update the conflicting column")
    }
  }

  def doUpdate(pick: M => Seq[ModelCol]) = {
    doUpdateApply(
      pick(model).map(validate)
    )
  }

  def doUpdateOne(pick: M => ModelCol) = {
    doUpdateApply(
      Seq(
        validate(
          pick(model)
        )
      )
    )
  }

  private def doUpdateApply(cols: Seq[ModelCol]) = {
    validate(cols)
    new RunUpsert(
      model,
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(
          cols.map(NoArgMatches(_))
        )
      ))
    )
  }
}












