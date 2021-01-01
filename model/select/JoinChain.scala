package kuzminki.model.select

import kuzminki.model._


class JoinOn[A <: Model, B <: Model, R](join: Join[A, B], coll: TypedCollector[R]) {

  def joinOn(pickLeft: A => ModelCol, pickRight: B => ModelCol) = {
    new WhereJoin(
      join,
      coll.extend(Array(
        InnerJoinSec(ModelTable(join.b)),
        OnSec(pickLeft(join.a), pickRight(join.b))
      ))
    )
  }
}


class WhereJoin[A <: Model, B <: Model, R](join: Join[A, B], coll: TypedCollector[R]) {

  def all() = new OrderByJoin(join, coll)

  def whereOne(pick: Join[A, B] => Filter) = {
    new OrderByJoin(
      join,
      coll.add(
        WhereAllSec(
          Seq(pick(join))
        )
      )
    )
  }

  def whereAll(pick: Join[A, B] => Seq[Filter]) = {
    new OrderByJoin(
      join,
      coll.add(
        WhereAllSec(pick(join))
      )
    )
  }

  def whereAny(pick: Join[A, B] => Seq[Filter]) = {
    new OrderByJoin(
      join,
      coll.add(
        WhereAnySec(pick(join))
      )
    )
  }

  def whereAllOpt(pick: Join[A, B] => Seq[Option[Filter]]) = {
    pick(join).flatten match {
      case Nil =>
        new OrderByJoin(join, coll)
      case conds =>
        new OrderByJoin(
          join,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereAnyOpt(pick: Join[A, B] => Seq[Option[Filter]]) = {
    pick(join).flatten match {
      case Nil =>
        new OrderByJoin(join, coll)
      case conds =>
        new OrderByJoin(
          join,
          coll.add(WhereAnySec(conds))
        )
    }
  }

  def whereChain(pick: JoinChainStart[A, B] => JoinFilteringChain[A, B]) = {
    new OrderByJoin(
      join,
      coll.add(
        WhereChainSec(pick(JoinChainStart(join)).filters)
      )
    )
  }
}


class OrderByJoin[A <: Model, B <: Model, R](join: Join[A, B], coll: TypedCollector[R]) extends OffsetJoin(coll) {

  def orderBy(pick: Join[A, B] => Seq[Sorting]) = {
    new OffsetJoin(
      coll.add(
        OrderBySec(pick(join))
      )
    )
  }

  def orderByOne(pick: Join[A, B] => Sorting) = {
    new OffsetJoin(
      coll.add(
        OrderBySec(
          Seq(pick(join))
        )
      )
    )
  }
}


class OffsetJoin[A <: Model, B <: Model, R](coll: TypedCollector[R]) extends LimitJoin(coll) {

  def offset(num: Int) = {
    new LimitJoin(
      coll.add(
        OffsetSec(num)
      )
    )
  }
}


class LimitJoin[A <: Model, B <: Model, R](coll: TypedCollector[R]) extends RunTyped(coll) {

  def limit(num: Int) = {
    new RunTyped(
      coll.add(
        LimitSec(num)
      )
    )
  }
}


























