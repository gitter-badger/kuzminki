package kuzminki.model


class OrderBy[M, R](model: M, coll: SelectCollector[R]) extends Offset(model, coll) {

  def orderBy(pick: M => Seq[Sorting]) = {
    new Offset(
      model,
      coll.add(
        OrderBySec(pick(model))
      )
    )
  }

  def orderByOne(pick: M => Sorting) = {
    new Offset(
      model,
      coll.add(
        OrderBySec(
          Seq(pick(model))
        )
      )
    )
  }
}