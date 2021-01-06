package kuzminki.model.aggregate

import kuzminki.model._


class SubqueryNumber[M <: Model](model: M) {

  def cols1(pick: M => AggFunction) = {
    new WhereSubqueryNumber(
      model,
      SubCollector(
        Array(
          SelectSec(
            Seq(pick(model))
          ),
          FromSec(ModelTable(model))
        )
      )
    )
  }
}


class SubqueryNumberJoin[A <: Model, B <: Model](join: Join[A, B]) {

  def cols1(pick: Join[A, B] => AggFunction) = {
    new SubqueryNumberJoinOn(
      join,
      SubCollector(
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


class SubqueryNumberJoinOn[A <: Model, B <: Model](join: Join[A, B], coll: SubCollector) {

  def joinOn(pickLeft: A => ModelCol, pickRight: B => ModelCol) = {
    new WhereSubqueryNumber(
      join,
      coll.extend(Array(
        InnerJoinSec(ModelTable(join.b)),
        OnSec(pickLeft(join.a), pickRight(join.b))
      ))
    )
  }
}


class WhereSubqueryNumber[M](model: M, coll: SubCollector) {

  def all() = new SingleNumberSubquery(coll)

  def whereOne(pick: M => Filter) = {
    new SingleNumberSubquery(
      coll.add(
        WhereAllSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereAll(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiModelException("WHERE cannot be empty")
      case conds =>
        new SingleNumberSubquery(
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new SingleNumberSubquery(coll)
      case conds =>
        new SingleNumberSubquery(
          coll.add(WhereAllSec(conds))
        )
    }
  }
}















