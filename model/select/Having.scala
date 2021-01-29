package kuzminki.model


class Having[M, R](model: M, coll: SelectCollector[R]) extends OrderBy(model, coll) {

  private def toOrderBy(section: Section) = {
    new OrderBy(
      model,
      coll.add(section)
    )
  }

  def having(pick: M => Seq[Filter]) = {
    toOrderBy(
      HavingSec(pick(model)) 
    )
  }

  def all() = {
    toOrderBy(HavingBlankSec)
  }

  def havingOne(pick: M => Filter) = {
    toOrderBy(
      HavingSec(
        Seq(pick(model))
      )
    )
  }

  def havingOpt(pick: M => Seq[Option[Filter]]) = {
    toOrderBy(
      pick(model).flatten match {
        case Nil =>
          HavingBlankSec
        case filters =>
          HavingSec(pick(model).flatten)
      }
    )
  }
}