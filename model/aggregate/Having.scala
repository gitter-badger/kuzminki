package kuzminki.model


class Having[M, R](model: M, coll: SelectCollector[R]) extends OrderBy(model, coll) {

  def havingOne(pick: M => Filter) = {
    new OrderBy(
      model,
      coll.add(
        HavingSec(
          Seq(pick(model))
        )
      )
    )
  }

  def havingAll(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiException("WHERE cannot be empty")
      case conds =>
        new OrderBy(
          model,
          coll.add(HavingSec(conds))
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
          coll.add(HavingSec(conds))
        )
    }
  }
}




























