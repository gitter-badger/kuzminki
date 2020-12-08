package kuzminki


object implicits {

    import kuzminki.containers._

    implicit val stringToColumn: String => Col = name => Col(name)
    implicit val stringToFilter: String => Filter = name => Filter(name)

    implicit val stringToTableName: String => TableName = name => TableName(name)
    implicit val tupleToTableNameAlias: Tuple2[String, String] => TableNameAlias = pair => TableNameAlias(pair._1, pair._2)

    implicit val stringToDefaultOrder: String => DefaultOrder = name => DefaultOrder(name)
    implicit val tupleToChange: Tuple2[String, Any] => Change = pair => Change(Col(pair._1), Change.wrap(pair._2))
}


object Filtering {
  def init: FilteringStart = FilteringChain(PartCollector.init)
  def continue(parts: PartCollector): FilteringStart = FilteringChain(parts)
}


trait Filtering {
  def and(part: Part): Filtering
  def and(sub: FilteringStart => Filtering): Filtering
  def or(part: Part): Filtering
  def or(sub: FilteringStart => Filtering): Filtering
  def parts: PartCollector
}


trait FilteringStart {
  def col(part: Part): Filtering
}


case class FilteringChain(conds: FilteringCollector) extends Filtering
                                                   with FilteringStart{

  private def next(cond: DirectiveCond) = FilteringChain(conds.add(cond))

  private def wrapped(sub: FilteringStart => Filtering): Part = {
    sub(Filtering.init).parts.asNested
  }

  def col(cond: Cond): Filtering = next(cond.where)

  def and(cond: Cond): Filtering = next(cond.and)

  def and(sub: FilteringStart => Filtering): Filtering = {
    next("AND", wrapped(sub))
  }

  def or(part: Part): Filtering = next(cond.or)

  def or(sub: FilteringStart => Filtering): Filtering = {
    next("OR", wrapped(sub))
  }
}










