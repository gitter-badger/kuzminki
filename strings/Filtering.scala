package kuzminki.strings

import kuzminki.builder._


trait ChainFilter extends Renderable {
  val filter: Renderable
  def template: String
  def render = template.format(filter.render)
  def wrap = template.format(filter.wrap)
  def args = filter.args
}


case class StartFilter(filter: Filter) extends ChainFilter {
  def template = "%s"
}


case class AndFilter(filter: Filter) extends ChainFilter {
  def template = "AND %s"
}


case class OrFilter(filter: Filter) extends ChainFilter {
  def template = "OR %s"
}


case class AndChain(filter: NestedFilters) extends ChainFilter {
  def template = "AND (%s)"
}


case class OrChain(filter: NestedFilters) extends ChainFilter {
  def template = "OR (%s)"
}


object NestedFilters {
  def init = NestedFilters(Array.empty[ChainFilter])
}


case class NestedFilters(filters: Array[ChainFilter]) extends Renderable {
  def add(filter: ChainFilter) = NestedFilters(filters :+ filter)
  def render = filters.map(_.render).mkString(" ")
  def wrap = filters.map(_.wrap).mkString(" ")
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

  private def next(filter: ChainFilter) = FilteringChain(filters.add(filter))

  def col(filter: Filter): Filtering = next(StartFilter(filter))

  def and(filter: Filter): Filtering = next(AndFilter(filter))

  def and(nested: FilteringStart => Filtering): Filtering = {
    next(AndChain(nested(Filtering.init).filters))
  }

  def or(filter: Filter): Filtering = next(OrFilter(filter))

  def or(nested: FilteringStart => Filtering): Filtering = {
    next(OrChain(nested(Filtering.init).filters))
  }
}










