package kuzminki


trait FilterWithOperator extends Renderable {
  def filter: Renderable
  def template: String
  def render = template.format(filter.render)
  def wrap = template.format(filter.wrap)
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
  def init = NestedFilters(1, Array.empty[FilterWithOperator])
}


case class NestedFilters(level: Int, filters: Array[FilterWithOperator]) extends RenderablePretty {
  
  def add(filter: FilterWithOperator) = NestedFilters(level, filters :+ filter)
  def child = NestedFilters(level + 1, Array.empty[FilterWithOperator])

  def padding = " " * level * 4
  def base = " " * (level - 1) * 4

  def template = {
    level match {
      case 1 => "%s"
      case _ => "(%s)"
    }
  }

  def prettyTemplate = {
    level match {
      case 1 => "%s\n%s"
      case _ => "(%s\n%s)"
    }
  }

  def render = {
    template.format(
      filters
        .map(_.render)
        .mkString(" ")
    )
  }

  def wrap = {
    template.format(
      filters
        .map(_.wrap)
        .mkString(" ")
    )
  }

  def pretty = {
    prettyTemplate.format(
      filters
        .map(_.render)
        .map(padding + _)
        .mkString("\n"),
      base
    )
  }

  def args = filters.toSeq.map(_.args).flatten
}


trait Filtering {
  def and(filter: Filter): Filtering
  def and(nested: FilteringStart => Filtering): Filtering
  def or(filter: Filter): Filtering
  def or(nested: FilteringStart => Filtering): Filtering
  def filters: NestedFilters
}


trait FilteringStart {
  def col(filter: Filter): Filtering
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










