package kuzminki.model.select

import kuzminki.model._


class JoinOn[A <: Model, B <: Model, R](join: Join[A, B], coll: TypedCollector[R]) {

  def joinOn(pickLeft: A => ModelCol, pickRight: B => ModelCol) = {
    new Where(
      join,
      coll.extend(Array(
        InnerJoinSec(ModelTable(join.b)),
        OnSec(pickLeft(join.a), pickRight(join.b))
      ))
    )
  }
}