package kuzminki.model


class Where[M, R](
      model: M,
      coll: SelectCollector[R]
  ) {

  private def toOrderBy(section: Section) = {
    coll.canUseWhere()
    new OrderBy(
      model,
      coll.add(section)
    )
  }

  def where(pick: M => Seq[Filter]) = {
    toOrderBy(
      WhereSec(pick(model))
    )
  }

  def all() = {
    toOrderBy(WhereBlankSec)
  }

  def whereOne(pick: M => Filter) = {
    toOrderBy(
      WhereSec(
        Seq(pick(model))
      )
    )
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    toOrderBy(
      pick(model).flatten match {
        case Nil =>
          WhereBlankSec
        case filters =>
          WhereSec(pick(model).flatten)
      }
    )
  }

  // group by

  private def toHaving(cols: Seq[ModelCol]) = {
    coll.canUseHaving()
    new Having(
      model,
      coll.add(GroupBySec(cols))
    )
  }

  def groupByOne(pick: M => ModelCol) = {
    toHaving(
      Seq(pick(model))
    )
  }

  def groupBy(pick: M => Seq[ModelCol]) = {
    toHaving(pick(model))
  }
}




























