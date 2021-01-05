package kuzminki.model.select

import kuzminki.model._


class Where[M, R](model: M, coll: TypedCollector[R]) {

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
    pick(model) match {
      case Nil =>
        throw KuzminkiModelException("WHERE conditions cannot be empty")
      case conds =>
        new OrderBy(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
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
}




























