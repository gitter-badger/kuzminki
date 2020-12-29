package kuzminki.model.operation

import kuzminki.model._


class Where[M <: Model](coll: OperationCollector[M]){

  def whereAll(pick: M => Seq[Filter]) = {
    new Returning(
      coll.add(
        WhereAllSec(pick(coll.model))
      )
    )
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    new Returning(
      coll.add(
        WhereAllSec(pick(coll.model).flatten)
      )
    )
  }

  def whereOne(pick: M => Filter) = {
    new Returning(
      coll.add(
        WhereAllSec(
          Seq(pick(coll.model))
        )
      )
    )
  }

  def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
    new Returning(
      coll.add(
        WhereChainSec(pick(ChainStart(coll.model)).filters)
      )
    )
  }
}