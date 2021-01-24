package kuzminki.model


object Count {
  def all = Count(AllCols)
}

object AllCols extends RenderableCol with NoArgs {
  def render(prefix: Prefix) = "*"
}

trait AggCount extends AggNumeric {
  def template = "COUNT(%s)"
}


case class Count(col: RenderableCol) extends AggCount
                                 with LongColValue
                                 with UniversalFilters[Long]
                                 with ComparativeFilters[Long]

