package kuzminki.model


class Where[M, R](model: M, coll: SelectCollector[R]) {

  def all() = {
    new OrderBy(
      model,
      coll.add(
        WhereBlankSec
      )
    )
  }

  def whereOne(pick: M => Filter) = {
    new OrderBy(
      model,
      coll.add(
        WhereSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereAll(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiException("WHERE conditions cannot be empty")
      case conds =>
        new OrderBy(
          model,
          coll.add(WhereSec(conds))
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
          coll.add(WhereSec(conds))
        )
    }
  }
}




























