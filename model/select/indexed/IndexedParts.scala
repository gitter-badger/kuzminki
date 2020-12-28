package kuzminki.model.select.indexed

import kuzminki.model._


class Where[M <: Model](coll: IndexedCollector[M]) extends OrderBy(coll) {

  def whereAll(pick: M => Seq[Filter]) = {
    new OrderBy(
      coll.add(
        WhereAllSec(pick(coll.model))
      )
    )
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    new OrderBy(
      coll.add(
        WhereAllSec(pick(coll.model).flatten)
      )
    )
  }

  def whereOne(pick: M => Filter) = {
    new OrderBy(
      coll.add(
        WhereAllSec(
          Seq(pick(coll.model))
        )
      )
    )
  }

  def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
    new OrderBy(
      coll.add(
        WhereChainSec(pick(ChainStart(coll.model)).filters)
      )
    )
  }
}

class OrderBy[M <: Model](coll: IndexedCollector[M]) extends Offset(coll) {

  def orderBy(pick: M => Seq[Sorting]) = {
    new Offset(
      coll.add(
        OrderBySec(pick(coll.model))
      )
    )
  }

  def orderByOne(pick: M => Sorting) = {
    new Offset(
      coll.add(
        OrderBySec(
          Seq(pick(coll.model))
        )
      )
    )
  }
}

class Offset[M <: Model](coll: IndexedCollector[M]) extends Limit(coll) {

  def offset(num: Int) = {
    new Limit(
      coll.add(
        OffsetSec(num)
      )
    )
  }
}

class Limit[M <: Model](coll: IndexedCollector[M]) extends RunIndexed(coll) {

  def limit(num: Int) = {
    new RunIndexed(
      coll.add(
        LimitSec(num)
      )
    )
  }
}

class RunIndexed[M <: Model](coll: IndexedCollector[M]) extends Printing {

  def run = coll.executor
  def render = coll.render
}













