package kuzminki.model.aggregate

import kuzminki.model._


class Where[M, R](model: M, coll: TypedCollector[R]) {

  def all() = new RunAggregation(coll)

  def whereOne(pick: M => Filter) = {
    new RunAggregation(
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
        throw KuzminkiModelException("WHERE conditions cannot be empty")
      case conds =>
        new RunAggregation(
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new RunAggregation(coll)
      case conds =>
        new RunAggregation(
          coll.add(WhereAllSec(conds))
        )
    }
  }
}




























