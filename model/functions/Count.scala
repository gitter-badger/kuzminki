package kuzminki.model


object Count {
  def all = Count(AllCols)
}

object AllCols extends RenderableCol with NoArgs {
  val col = this
  def render = "*"
  def prefix(picker: Prefix) = render
}

trait AggCount extends AggNumeric {
  def template = "COUNT(%s)"
}


case class Count(col: RenderableCol) extends AggCount
                                 with LongColValue
                                 with UniversalFilters[Long]
                                 with ComparativeFilters[Long]

