package kuzminki.model


class Limit[M, R](coll: SelectCollector[R]) extends RunSelect(coll) {

  def limit(num: Int) = {
    new RunSelect(
      coll.add(
        LimitSec(num)
      )
    )
  }
}