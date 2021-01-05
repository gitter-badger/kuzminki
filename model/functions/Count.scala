package kuzminki.model


object Count {
  def all = Count(AllCols)
}

object AllCols extends Render {
  def render = "*"
  def args = Seq.empty[Any]
}

trait AggCount extends AggFunction {
  def name = "count"
  def template = "COUNT(%s)"
}


case class Count(col: Render) extends AggCount
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]

