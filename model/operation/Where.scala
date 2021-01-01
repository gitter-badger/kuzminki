package kuzminki.model.operation

import kuzminki.model._


class Where[M <: Model](model: M, coll: Collector) {

  def all = new Returning(model, coll)

  def whereOne(pick: M => Filter) = {
    new Returning(
      model,
      coll.add(
        WhereAllSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereAll(pick: M => Seq[Filter]) = {
    new Returning(
      model,
      coll.add(
        WhereAllSec(pick(model))
      )
    )
  }

  def whereAny(pick: M => Seq[Filter]) = {
    new Returning(
      model,
      coll.add(
        WhereAnySec(pick(model))
      )
    )
  }

  def whereAllOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new Returning(model, coll)
      case conds =>
        new Returning(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereAnyOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new Returning(model, coll)
      case conds =>
        new Returning(
          model,
          coll.add(WhereAnySec(conds))
        )
    }
  }

  def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
    new Returning(
      model,
      coll.add(
        WhereChainSec(pick(ChainStart(model)).filters)
      )
    )
  }
}


















