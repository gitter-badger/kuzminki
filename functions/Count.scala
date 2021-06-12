package kuzminki.model


object Count {
  def all = Count(AllCols)
}

object AllCols extends AnyCol with NoArgs {
  def col = this
  def render(prefix: Prefix) = "*"
}

trait AggCount extends AggNumeric {
  def template = "count(%s)"
}


case class Count(col: AnyCol) extends AggCount
                                 with LongColValue
                                 with UniversalFilters[Long]
                                 with ComparativeFilters[Long]

