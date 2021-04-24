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

  def all() = {
    toOrderBy(WhereBlankSec)
  }

  def where(pick: M => Seq[Filter]) = {
    toOrderBy(
      WhereSec(pick(model))
    )
  }

  def whereOne(pick: M => Filter) = {
    toOrderBy(
      WhereSec(
        Seq(pick(model))
      )
    )
  }

  def whereOpts(pick: M => Seq[Option[Filter]]) = {
    toOrderBy(
      pick(model).flatten match {
        case Nil =>
          WhereBlankSec
        case filters =>
          WhereSec(pick(model).flatten)
      }
    )
  }

  def whereOpt(pick: M => Option[Filter]) = {
    toOrderBy(
      pick(model) match {
        case Some(filter) =>
          WhereSec(Seq(filter))
        case None =>
          WhereBlankSec
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




























