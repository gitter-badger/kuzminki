package kuzminki.model


trait Underlying {
  def col: ModelCol
}


trait UniversalFilters[T] extends Underlying {
  
  def matches(value: T): Filter = FilterMatches(col, value)
  def ===(value: T): Filter = matches(value)

  def not(value: T): Filter = FilterNot(col, value)
  def !==(value: T): Filter = not(value)
  
  // not optional

  def isNull: Filter = FilterIsNull(col)
  def isNotNull: Filter = FilterIsNotNull(col)

  def in(value: Seq[T]): Filter = FilterIn(col, value)

  //def in(subquery: nested: NestedSelect[V]): Filter = FilterInSubquery

  // optional

  def matches(opt: Option[T]): Option[Filter] = opt.map(matches)
  def ===(opt: Option[T]): Option[Filter] = opt.map(matches)

  def not(opt: Option[T]): Option[Filter] = opt.map(not)
  def !==(opt: Option[T]): Option[Filter] = opt.map(not)

  def in(opt: Option[Seq[T]]): Option[Filter] = opt.map(in)

  // update

  def ==>(value: T) = SetValue(col, value)
}

trait IncrementUpdate[T] extends Underlying {
  def +=(value: T) = Increment(col, value)
  def -=(value: T) = Decrement(col, value)
}

trait ComparativeFilters[T] extends Underlying {

  def gt(value: T): Filter = FilterGt(col, value)
  def >(value: T): Filter = gt(value)

  def gte(value: T): Filter = FilterGte(col, value)
  def >=(value: T): Filter = gte(value)

  def lt(value: T): Filter = FilterLt(col, value)
  def <(value: T): Filter = lt(value)

  def lte(value: T): Filter = FilterLte(col, value)
  def <=(value: T): Filter = lte(value)

  // optional

  def gt(opt: Option[T]): Option[Filter] = opt.map(gt)
  def >(opt: Option[T]): Option[Filter] = opt.map(gt)

  def gte(opt: Option[T]): Option[Filter] = opt.map(gte)
  def >=(opt: Option[T]): Option[Filter] = opt.map(gte)

  def lt(opt: Option[T]): Option[Filter] = opt.map(lt)
  def <(opt: Option[T]): Option[Filter] = opt.map(lt)

  def lte(opt: Option[T]): Option[Filter] = opt.map(lte)
  def <=(opt: Option[T]): Option[Filter] = opt.map(lte)
}


trait StringFilters extends Underlying {

  def like(value: String): Filter = FilterLike(col, value)
  def startsWith(value: String): Filter = FilterStartsWith(col, value)
  def endsWith(value: String): Filter = FilterEndsWith(col, value)
  def similarTo(value: String): Filter = FilterSimilarTo(col, value)

  // re

  def reMatch(value: String): Filter = FilterReIMatch(col, value)
  def ~(value: String): Filter = reMatch(value)

  def reIMatch(value: String): Filter = FilterReIMatch(col, value)
  def ~*(value: String): Filter = reIMatch(value)

  def reNotMatch(value: String): Filter = FilterReNotMatch(col, value)
  def !~(value: String): Filter = reNotMatch(value)

  def reNotIMatch(value: String): Filter = FilterReNotImatch(col, value)
  def !~*(value: String): Filter = reNotIMatch(value)
}













