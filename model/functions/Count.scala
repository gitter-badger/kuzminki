package kuzminki.model


object Count {
  def all = Count(AllCols)
}

object AllCols extends RenderableCol with NoArgs {
  def render = "*"
  def prefix(picker: Prefix) = render
}

trait AggCount extends AggNumeric {
  def name = "count"
  def template = "COUNT(%s)"
}


case class Count(col: RenderableCol) extends AggCount
                                 with LongColValue
                                 with UniversalFilters[Long]
                                 with ComparativeFilters[Long]

