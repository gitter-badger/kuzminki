package kuzminki.model



import scala.collection.mutable.ArrayBuffer


trait ChainFilter extends Render {
  val filter: Render
  def template: String
  def render = template.format(filter.render)
  def args = filter.args
}

trait NestedFilters extends Render {
  val filters: Array[Render]
  def template: String
  def render = template.format(filters.map(_.render).mkString(" "))
  def args = filters.toSeq.map(_.args).flatten
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


case class AndChain(filters: Array[Render]) extends NestedFilters {
  def template = "AND (%s)"
}


case class OrChain(filters: Array[Render]) extends NestedFilters {
  def template = "OR (%s)"
}


case class ChainStart[M <: Model](model: M) {

  def col(pick: M => Filter) = {
    FilteringChain(
      model,
      Array(
        StartFilter(pick(model))
      )
    )
  }
}


case class FilteringChain[M <: Model](model: M, filters: Array[Render]) {

  private def next(filter: Render) = this.copy(filters = filters :+ filter)

  def and(pick: M => Filter) = {
    next(
      AndFilter(pick(model))
    )
  }

  def or(pick: M => Filter) = {
    next(
      OrFilter(pick(model))
    )
  }

  def andChain(pick: ChainStart[M] => FilteringChain[M]) = {
    next(
      AndChain(pick(ChainStart(model)).filters)
    )
  }

  def orChain(pick: ChainStart[M] => FilteringChain[M]) = {
    next(
      OrChain(pick(ChainStart(model)).filters)
    )
  }
}


case class JoinChainStart[A <: Model, B <: Model](join: Join[A, B]) {

  def col(pick: Join[A, B] => Filter) = {
    JoinFilteringChain(
      join,
      Array(
        StartFilter(pick(join))
      )
    )
  }
}


case class JoinFilteringChain[A <: Model, B <: Model](join: Join[A, B], filters: Array[Render]) {

  private def next(filter: Render) = this.copy(filters = filters :+ filter)

  def and(pick: Join[A, B] => Filter) = {
    next(
      AndFilter(pick(join))
    )
  }

  def or(pick: Join[A, B] => Filter) = {
    next(
      OrFilter(pick(join))
    )
  }

  def andChain(pick: JoinChainStart[A, B] => JoinFilteringChain[A, B]) = {
    next(
      AndChain(pick(JoinChainStart(join)).filters)
    )
  }

  def orChain(pick: JoinChainStart[A, B] => JoinFilteringChain[A, B]) = {
    next(
      OrChain(pick(JoinChainStart(join)).filters)
    )
  }
}









