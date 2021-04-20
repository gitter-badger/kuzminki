package kuzminki.model


class Offset[M, R](model: M, coll: SelectCollector[R]) extends Limit(model, coll) {

  def offset(num: Int) = {
    new Limit(
      model,
      coll.add(
        OffsetSec(num)
      )
    )
  }
}