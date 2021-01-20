package kuzminki.model.aggregate

import kuzminki.model._


class SubqueryNumberJoinOn[A <: Model, B <: Model](join: Join[A, B], coll: SubCollector) {

  def joinOn(pickLeft: A => ModelCol, pickRight: B => ModelCol) = {
    new WhereSubqueryNumber(
      join,
      coll.extend(Array(
        InnerJoinSec(ModelTable(join.b)),
        OnSec(pickLeft(join.a), pickRight(join.b))
      ))
    )
  }
}