package kuzminki


object implicits {

    import kuzminki.containers._

    implicit val stringToColumn: String => Col = name => Col(name)
    implicit val stringToFilter: String => Condition = name => Condition(name)

    implicit val stringToTableName: String => TableName = name => TableName(name)
    implicit val tupleToTableNameAlias: Tuple2[String, String] => TableNameAlias = pair => TableNameAlias(pair._1, pair._2)

    implicit val stringToDefaultOrder: String => DefaultOrder = name => DefaultOrder(name)
    implicit val tupleToChange: Tuple2[String, Any] => Change = pair => Change(Col(pair._1), Change.wrap(pair._2))
}


case class Filter(name: Sting, op: String, args: Seq[Any]) extends Renderable {
  def render = "%s = ?".format(name)
  def wrap = "%s = ?".format(Renderable.wrapped(name))
}


trait FilterWithOperator extends Renderable {
  def filter: Renderable
  def template: String
  def render = template.format(filter.render)
  def wrapp = template.format(filter.wrap)
  def pretty = template.format(filter.pretty)
  def args = filter.args
}


case class StartFilter(filter: Renderable) extends FilterWithOperator {
  def template = "%s"
}


case class AndFilter(filter: Renderable) extends FilterWithOperator {
  def template = "AND %s"
}


case class OrFilter(filter: Renderable) extends FilterWithOperator {
  def template = "OR %s"
}


object NestedFilters {
  def init = NestedFilters(1, Array.empty[AndOrCond])
}


case class NestedFilters(level: Int, filters: Array[FilterWithOperator]) extends Renderable {
  
  def add(filter: FilterWithOperator) = NestedFilters(level, filters :+ filter)

  def child = CondCollector(level + 1, Array.empty[FilterWithOperator])

  def padding = " " * level * 4

  def base = " " * (level - 1) * 4

  def render = "(" + conds.map(_.render).mkString(" ") + ")"

  def wrap = "(" + conds.map(_.wrap).mkString(" ") + ")"

  def pretty = "(\n" + conds.map(_.render).map(padding + _).mkString("\n") + base + ")\n"
}


trait Filtering {
  def and(part: Part): Filtering
  def and(sub: FilteringStart => Filtering): Filtering
  def or(part: Part): Filtering
  def or(sub: FilteringStart => Filtering): Filtering
  def filters: NestedFilters
}


trait FilteringStart {
  def col(part: Part): Filtering
}


object Filtering {
  def init: FilteringStart = FilteringChain(NestedFilters.init)
}


case class FilteringChain(filters: NestedFilters) extends Filtering
                                                     with FilteringStart {

  private def next(filter: FilterWithOperator) = FilteringChain(filters.add(filter))

  private def child = FilteringChain(filters.child)

  def col(filter: Filter): Filtering = next(StartFilter(filter))

  def and(filter: Filter): Filtering = next(AndFilter(filter))

  def and(nested: FilteringStart => Filtering): Filtering = next(AndFilter(nested(child).filters))

  def or(filter: Filter): Filtering = next(OrFilter(filter))

  def or(nested: FilteringStart => Filtering): Filtering = next(OrFilter(nested(child).filters))
}










