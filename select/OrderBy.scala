package kuzminki.model


class OrderBy[M, R](model: M, coll: SelectCollector[R]) extends Offset(model, coll) {

  private def toOffset(sorting: Seq[Sorting]) = {
    new Offset(
      model,
      coll.add(
        OrderBySec(sorting)
      )
    )
  }

  def orderBy(pick: M => Seq[Sorting]) = {
    toOffset(pick(model))
  }

  def orderByOne(pick: M => Sorting) = {
    toOffset(
      Seq(pick(model))
    )
  }
}