package kuzminki.model.aggregate

import kuzminki.model._


class SubqueryNumberJoin[A <: Model, B <: Model](join: Join[A, B]) {

  def cols1(pick: Join[A, B] => AggNumeric) = {
    new SubqueryNumberJoinOn(
      join,
      JoinSubCollector(
        Prefix.fromJoin(join),
        Array(
          SelectSec(
            Seq(pick(join))
          ),
          FromSec(ModelTable(join.a))
        )
      )
    )
  }
}
