package kuzminki.model


class Having[M, R](
      model: M,
      coll: SelectCollector[R]
    ) {

  private def toOrderBy(section: Section) = {
    new OrderBy(
      model,
      coll.add(section)
    )
  }

  def all() = {
    toOrderBy(HavingBlankSec)
  }

  def having(pick: M => Seq[Filter]) = {
    toOrderBy(
      HavingSec(pick(model)) 
    )
  }

  def havingOne(pick: M => Filter) = {
    toOrderBy(
      HavingSec(
        Seq(pick(model))
      )
    )
  }

  def havingOpts(pick: M => Seq[Option[Filter]]) = {
    toOrderBy(
      pick(model).flatten match {
        case Nil =>
          HavingBlankSec
        case filters =>
          HavingSec(pick(model).flatten)
      }
    )
  }

  def havingOpt(pick: M => Option[Filter]) = {
    toOrderBy(
      pick(model) match {
        case Some(cond) =>
          HavingSec(Seq(cond))
        case None =>
          HavingBlankSec
      }
    )
  }
}