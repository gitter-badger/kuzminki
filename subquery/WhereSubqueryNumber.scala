package kuzminki.model


class WhereSubqueryNumber[M](model: M, coll: SubCollector) {

  def all = new SingleNumberSubquery(coll)

  def where(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiException("WHERE cannot be empty")
      case conds =>
        new SingleNumberSubquery(
          coll.add(WhereSec(conds))
        )
    }
  }

  def whereOne(pick: M => Filter) = {
    new SingleNumberSubquery(
      coll.add(
        WhereSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereOpts(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new SingleNumberSubquery(coll)
      case conds =>
        new SingleNumberSubquery(
          coll.add(WhereSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Option[Filter]) = {
    toOrderBy(
      pick(model) match {
        case Some(filter) =>
          WhereSec(Seq(filter))
        case None =>
          new SingleNumberSubquery(coll)
      }
    )
  }
}















