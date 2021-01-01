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


class OrderBy[M <: Model, R](model: M, coll: TypedCollector[R]) extends Offset(coll) {

  def orderBy(pick: M => Seq[Sorting]) = {
    new Offset(
      coll.add(
        OrderBySec(pick(model))
      )
    )
  }

  def orderByOne(pick: M => Sorting) = {
    new Offset(
      coll.add(
        OrderBySec(
          Seq(pick(model))
        )
      )
    )
  }
}


class Offset[M <: Model, R](coll: TypedCollector[R]) extends Limit(coll) {

  def offset(num: Int) = {
    new Limit(
      coll.add(
        OffsetSec(num)
      )
    )
  }
}


class Limit[M <: Model, R](coll: TypedCollector[R]) extends RunTyped(coll) {

  def limit(num: Int) = {
    new RunTyped(
      coll.add(
        LimitSec(num)
      )
    )
  }
}

























