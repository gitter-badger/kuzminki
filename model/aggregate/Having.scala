package kuzminki.model.aggregate

import kuzminki.model._


class Having[M, R](model: M, coll: TypedCollector[R]) extends OrderBy(model, coll) {

  def havingOne(pick: M => Filter) = {
    new OrderBy(
      model,
      coll.add(
        WhereAllSec(
          Seq(pick(model))
        )
      )
    )
  }

  def havingAll(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiModelException("WHERE cannot be empty")
      case conds =>
        new OrderBy(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def havingOpt(pick: M => Seq[Option[Filter]]) = {
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



























