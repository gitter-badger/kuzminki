package kuzminki.model


object Count {
  def all = Count(AllCols)
}

object AllCols extends Renderable {
  def render = "*"
  def prefix(picker: Prefix) = render
  def args = Seq.empty[Any]
}

trait AggCount extends AggNumeric {
  def name = "count"
  def template = "COUNT(%s)"
}


case class Count(col: Render) extends AggCount
                                 with LongColValue
                                 with UniversalFilters[Long]
                                 with ComparativeFilters[Long]

