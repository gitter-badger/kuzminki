package kuzminki.model.select

import kuzminki.model._


class Where[M <: Model, R](model: M, coll: TypedCollector[R]) {

  def all() = new OrderBy(model, coll)

  def whereOne(pick: M => Filter) = {
    new OrderBy(
      model,
      coll.add(
        WhereAllSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereAll(pick: M => Seq[Filter]) = {
    new OrderBy(
      model,
      coll.add(
        WhereAllSec(pick(model))
      )
    )
  }

  def whereAny(pick: M => Seq[Filter]) = {
    new OrderBy(
      model,
      coll.add(
        WhereAnySec(pick(model))
      )
    )
  }

  def whereAllOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new OrderBy(model, coll)
      case conds =>
        new OrderBy(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereAnyOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new OrderBy(model, coll)
      case conds =>
        new OrderBy(
          model,
          coll.add(WhereAnySec(conds))
        )
    }
  }

  def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
    new OrderBy(
      model,
      coll.add(
        WhereChainSec(pick(ChainStart(model)).filters)
      )
    )
  }
}



























