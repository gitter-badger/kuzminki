package kuzminki


object implicits {
    implicit val stringToFilter: String => Filter = name => Filter(name)
}


object Filtering {
  def init: FilteringStart = FilteringChain(PartCollector.init)
  def continue(parts: PartCollector): FilteringStart = FilteringChain(parts)
}


trait Filtering {
  def and(part: Part): Filtering
  def andMore(sub: FilteringStart => Filtering): Filtering
  def or(part: Part): Filtering
  def orMore(sub: FilteringStart => Filtering): Filtering
  def parts: PartCollector
}


trait FilteringStart {
  def col(part: Part): Filtering
}


case class FilteringChain(parts: PartCollector) extends Filtering
                                                   with FilteringStart{

  private def next(op: String, part: Part) = {
    FilteringChain(
      parts.extend(
        Seq(Part.create(op), part)
      )
    )
  }

  private def wrapped(sub: FilteringStart => Filtering): Part = {
    sub(Filtering.init).parts.asNested
  }

  def col(part: Part): Filtering = FilteringChain(parts.add(part))

  def and(part: Part): Filtering = next("AND", part)

  def andMore(sub: FilteringStart => Filtering): Filtering = {
    next("AND", wrapped(sub))
  }

  def or(part: Part): Filtering = next("OR", part)

  def orMore(sub: FilteringStart => Filtering): Filtering = {
    next("OR", wrapped(sub))
  }
}










