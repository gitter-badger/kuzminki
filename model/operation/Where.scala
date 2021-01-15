package kuzminki.model.operation

import kuzminki.model._


class Where[M](model: M, coll: Collector) {

  def all() = new RunOperation(model, coll)

  def whereOne(pick: M => Filter) = {
    new RunOperation(
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
        new RunOperation(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new RunOperation(model, coll)
      case conds =>
        new RunOperation(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }
}


















