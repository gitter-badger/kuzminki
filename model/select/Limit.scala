package kuzminki.model


class Limit[M, R](model: M, coll: SelectCollector[R]) extends RunSelect(model, coll) {

  def limit(num: Int) = {
    new RunSelect(
      model,
      coll.add(
        LimitSec(num)
      )
    )
  }
}