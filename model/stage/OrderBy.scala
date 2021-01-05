package kuzminki.model


class OrderBy[M <: Model, R](model: M, coll: TypedCollector[R]) extends Offset(coll) {

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