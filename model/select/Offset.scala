package kuzminki.model


class Offset[M, R](coll: SelectCollector[R]) extends Limit(coll) {

  def offset(num: Int) = {
    new Limit(
      coll.add(
        OffsetSec(num)
      )
    )
  }
}