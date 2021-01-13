package kuzminki.model.insert

import kuzminki.model._


trait WhereNotExists[M <: Model, S] {

  protected val model: M
  protected val coll: InsertCollector[S]

  def whereNotExistsOne(pick: M => ModelCol) = {
    whereNotExistsApply(
      Seq(pick(model))
    )
  }

  def whereNotExistsAll(pick: M => Seq[ModelCol]) = {
    whereNotExistsApply(pick(model))
  }

  private def whereNotExistsApply(uniqueCols: Seq[ModelCol]) = {

    if (uniqueCols.isEmpty) {
      throw KuzminkiModelException("whereNotExists")
    }

    new RunConditionalInsert(
      model,
      Reuse.fromIndex(coll.shape.cols, uniqueCols),
      coll.add(
        InsertBlankWhereNotExistsSec(
          coll.shape.size,
          ModelTable(model),
          WhereAllSec(
            uniqueCols.map(FilterMatchesNoArg(_))
          )
        )
      )
    )
  }
}