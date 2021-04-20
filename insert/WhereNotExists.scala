package kuzminki.model


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
      throw KuzminkiException("whereNotExists")
    }

    new RunInsertWhereNotExists(
      model,
      Reuse.fromIndex(coll.paramShape.cols, uniqueCols),
      coll.add(
        InsertBlankWhereNotExistsSec(
          coll.paramShape.size,
          ModelTable(model),
          WhereSec(
            uniqueCols.map(FilterMatchesNoArg(_))
          )
        )
      )
    )
  }
}