package kuzminki.model.aggregate

import kuzminki.model._


class Where[M <: Model, R](model: M, coll: TypedCollector[R]){

  def all() = new RunAggregation(coll)

  def whereAll(pick: M => Seq[Filter]) = {
    new RunAggregation(
      coll.add(
        WhereAllSec(pick(model))
      )
    )
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    new RunAggregation(
      coll.add(
        WhereAllSec(pick(model).flatten)
      )
    )
  }

  def whereOne(pick: M => Filter) = {
    new RunAggregation(
      coll.add(
        WhereAllSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
    new RunAggregation(
      coll.add(
        WhereChainSec(pick(ChainStart(model)).filters)
      )
    )
  }
}




























