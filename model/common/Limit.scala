package kuzminki.model


class Limit[M, R](coll: TypedCollector[R]) extends RunTyped(coll) {

  def limit(num: Int) = {
    new RunTyped(
      coll.add(
        LimitSec(num)
      )
    )
  }
}