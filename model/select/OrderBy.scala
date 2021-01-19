package kuzminki.model


class OrderBy[M, R](model: M, coll: SelectCollector[R]) extends Offset(coll) {

  def orderBy(pick: M => Seq[Sorting]) = {
    new Offset(
      coll.add(
        OrderBySec(pick(model))
      )
    )
  }

  def orderByOne(pick: M => Sorting) = {
    new Offset(
      coll.add(
        OrderBySec(
          Seq(pick(model))
        )
      )
    )
  }
}