package kuzminki.model


object CountAll extends AggFunction
                   with LongColValue
                   with UniversalFilters[Long]
                   with ComparativeFilters[Long] {

  def col = this
  def name = "count"
  def render = "COUNT(*)"
  def args = Seq.empty[Any]
}

trait AggCount extends ColFunction {
  def name = "count"
  def template = "COUNT(%s)"
}

case class Count(col: RealCol) extends AggCount
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]

