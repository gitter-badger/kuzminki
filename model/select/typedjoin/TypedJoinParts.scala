package kuzminki.model.select.typedjoin

import kuzminki.model._


class JoinOn[A <: Model, B <: Model, R](coll: TypedJoinCollector[A, B, R]) {

  def joinOn(pickLeft: A => ModelCol, pickRight: B => ModelCol) = {
    new Where(
      coll.extend(Array(
        InnerJoinSec(ModelTable(coll.join.b)),
        OnSec(pickLeft(coll.join.a), pickRight(coll.join.b))
      ))
    )
  }
}

class Where[A <: Model, B <: Model, R](coll: TypedJoinCollector[A, B, R]) extends OrderBy(coll) {

  def whereAll(pick: Join[A, B] => Seq[Filter]) = {
    new OrderBy(
      coll.add(
        WhereAllSec(pick(coll.join))
      )
    )
  }

  def whereOpt(pick: Join[A, B] => Seq[Option[Filter]]) = {
    new OrderBy(
      coll.add(
        WhereAllSec(pick(coll.join).flatten)
      )
    )
  }

  def whereOne(pick: Join[A, B] => Filter) = {
    new OrderBy(
      coll.add(
        WhereAllSec(
          Seq(pick(coll.join))
        )
      )
    )
  }

  def whereChain(pick: JoinChainStart[A, B] => JoinFilteringChain[A, B]) = {
    new OrderBy(
      coll.add(
        WhereChainSec(pick(JoinChainStart(coll.join)).filters)
      )
    )
  }
}

class OrderBy[A <: Model, B <: Model, R](coll: TypedJoinCollector[A, B, R]) extends Offset(coll) {

  def orderBy(pick: Join[A, B] => Seq[Sorting]) = {
    new Offset(
      coll.add(
        OrderBySec(pick(coll.join))
      )
    )
  }

  def orderByOne(pick: Join[A, B] => Sorting) = {
    new Offset(
      coll.add(
        OrderBySec(
          Seq(pick(coll.join))
        )
      )
    )
  }
}

class Offset[A <: Model, B <: Model, R](coll: TypedJoinCollector[A, B, R]) extends Limit(coll) {

  def offset(num: Int) = {
    new Limit(
      coll.add(
        OffsetSec(num)
      )
    )
  }
}

class Limit[A <: Model, B <: Model, R](coll: TypedJoinCollector[A, B, R]) extends Run(coll) {

  def limit(num: Int) = {
    new Run(
      coll.add(
        LimitSec(num)
      )
    )
  }
}

class Run[A <: Model, B <: Model, R](coll: TypedJoinCollector[A, B, R]) extends Printing {

  def run = coll.executor
  def render = coll.render
}






