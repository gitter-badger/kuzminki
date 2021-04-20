package kuzminki.model


class SubqueryNumberJoin[A <: Model, B <: Model](join: Join[A, B]) {

  def cols1(pick: Join[A, B] => AggNumeric) = {
    new SubqueryNumberJoinOn(
      join,
      SubCollector(
        Prefix.forJoin(join),
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
