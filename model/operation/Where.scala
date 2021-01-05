package kuzminki.model.operation

import kuzminki.model._


class Where[M](model: M, coll: Collector) {

  def all() = new Returning(model, coll)

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
    pick(model) match {
      case Nil =>
        throw KuzminkiModelException("WHERE conditions cannot be empty")
      case conds =>
        new Returning(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
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
}


















