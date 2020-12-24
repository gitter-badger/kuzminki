package kuzminki.model



import scala.collection.mutable.ArrayBuffer


trait ChainFilter extends ModelRender {
  val filter: ModelRender
  def template: String
  def render = template.format(filter.render)
  def args = filter.args
}

trait NestedFilters extends ModelRender {
  val filters: Array[ModelRender]
  def template: String
  def render = template.format(filters.map(_.render).mkString(" "))
  def args = filters.toSeq.map(_.args).flatten
}


case class StartFilter(filter: ModelFilter) extends ChainFilter {
  def template = "%s"
}


case class AndFilter(filter: ModelFilter) extends ChainFilter {
  def template = "AND %s"
}


case class OrFilter(filter: ModelFilter) extends ChainFilter {
  def template = "OR %s"
}


case class AndChain(filters: Array[ModelRender]) extends NestedFilters {
  def template = "AND (%s)"
}


case class OrChain(filters: Array[ModelRender]) extends NestedFilters {
  def template = "OR (%s)"
}


case class ChainStart[M <: Model](model: M) {

  def col(pick: M => ModelFilter) = {
    FilteringChain(
      model,
      Array(
        StartFilter(pick(model))
      )
    )
  }
}


case class FilteringChain[M <: Model](model: M, filters: Array[ModelRender]) {

  private def next(filter: ModelRender) = this.copy(filters = filters :+ filter)

  def and(pick: M => ModelFilter) = {
    next(
      AndFilter(pick(model))
    )
  }

  def or(pick: M => ModelFilter) = {
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

  def col(pick: Join[A, B] => ModelFilter) = {
    JoinFilteringChain(
      join,
      Array(
        StartFilter(pick(join))
      )
    )
  }
}


case class JoinFilteringChain[A <: Model, B <: Model](join: Join[A, B], filters: Array[ModelRender]) {

  private def next(filter: ModelRender) = this.copy(filters = filters :+ filter)

  def and(pick: Join[A, B] => ModelFilter) = {
    next(
      AndFilter(pick(join))
    )
  }

  def or(pick: Join[A, B] => ModelFilter) = {
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









