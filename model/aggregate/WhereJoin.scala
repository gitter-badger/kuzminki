package kuzminki.model.aggregate

import kuzminki.model._


class WhereJoin[A <: Model, B <: Model, R](join: Join[A, B], coll: TypedCollector[R]) {

  def all() = new RunAggregation(coll)

  def whereOne(pick: Join[A, B] => Filter) = {
    new RunAggregation(
      coll.add(
        WhereAllSec(
          Seq(pick(join))
        )
      )
    )
  }

  def whereAll(pick: Join[A, B] => Seq[Filter]) = {
    new RunAggregation(
      coll.add(
        WhereAllSec(pick(join))
      )
    )
  }

  def whereOpt(pick: Join[A, B] => Seq[Option[Filter]]) = {
    pick(join).flatten match {
      case Nil =>
        new RunAggregation(coll)
      case conds =>
        new RunAggregation(
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereChain(pick: JoinChainStart[A, B] => JoinFilteringChain[A, B]) = {
    new RunAggregation(
      coll.add(
        WhereChainSec(pick(JoinChainStart(join)).filters)
      )
    )
  }
}