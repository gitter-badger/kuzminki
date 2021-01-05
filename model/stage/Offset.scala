package kuzminki.model


class Offset[M <: Model, R](coll: TypedCollector[R]) extends Limit(coll) {

  def offset(num: Int) = {
    new Limit(
      coll.add(
        OffsetSec(num)
      )
    )
  }
}