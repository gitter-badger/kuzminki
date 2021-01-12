package kuzminki.model.insert

import kuzminki.model._


trait WhereNotExists[M, S] {

  protected val model: M,
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

    val insertCols = coll.form.colSeq

    val indexes = uniqueCols.map { col => 
      insertCols.indexOf(col) match {
        case -1 =>
          throw KuzminkiModelException(
            "column [%s] is not among inserted columns".format(col.name)
          )
        case index: Int => index
      }
    }

    new InsertStreamUniqueRun(
      model,
      indexes.toVector,
      coll.add(
        InsertBlankWhereNotExistsSec(
          coll.form.size,
          ModelTable(model),
          WhereAllSec(
            uniqueCols.map(FilterMatchesNoArg(_))
          )
        )
      )
    )
  }
}