package kuzminki.model


class AggregateWhere[M, R](model: M, coll: SelectCollector[R]) {

  def all() = new RunAggregation(coll)

  def whereOne(pick: M => Filter) = {
    new RunAggregation(
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
        throw KuzminkiException("WHERE cannot be empty")
      case conds =>
        new RunAggregation(
          coll.add(WhereSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new RunAggregation(coll)
      case conds =>
        new RunAggregation(
          coll.add(WhereSec(conds))
        )
    }
  }

  def groupByOne(pick: M => ModelCol) = {
    new Having(
      model,
      coll.add(
        GroupBySec(
          Seq(pick(model))
        )
      )
    )
  }

  def groupBy(pick: M => Seq[ModelCol]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiException("GROUP BY cannot be empty")
      case cols =>
        new Having(
          model,
          coll.add(GroupBySec(cols))
        )
    }
  }
}




























