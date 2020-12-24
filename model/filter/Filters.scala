package kuzminki.model


trait Underlying {
  def col: ModelCol
}


trait UniversalFilters[T] extends Underlying {
  
  def matches(value: T): ModelFilter = FilterMatches(col, value)
  def ===(value: T): ModelFilter = matches(value)

  def not(value: T): ModelFilter = FilterNot(col, value)
  def !==(value: T): ModelFilter = not(value)
  
  // not optional

  def isNull: ModelFilter = FilterIsNull(col)
  def isNotNull: ModelFilter = FilterIsNotNull(col)

  def in(value: Seq[T]): ModelFilter = FilterIn(col, value)

  // optional

  def matches(opt: Option[T]): Option[ModelFilter] = opt.map(matches)
  def ===(opt: Option[T]): Option[ModelFilter] = opt.map(matches)

  def not(opt: Option[T]): Option[ModelFilter] = opt.map(not)
  def !==(opt: Option[T]): Option[ModelFilter] = opt.map(not)

  def in(opt: Option[Seq[T]]): Option[ModelFilter] = opt.map(in)

  // update

  def ==>(value: T) = SetValue(col, value)
}

trait IncrementUpdate[T] extends Underlying {
  def +=(value: T) = Increment(col, value)
  def -=(value: T) = Decrement(col, value)
}

trait ComparativeFilters[T] extends Underlying {

  def gt(value: T): ModelFilter = FilterGt(col, value)
  def >(value: T): ModelFilter = gt(value)

  def gte(value: T): ModelFilter = FilterGte(col, value)
  def >=(value: T): ModelFilter = gte(value)

  def lt(value: T): ModelFilter = FilterLt(col, value)
  def <(value: T): ModelFilter = lt(value)

  def lte(value: T): ModelFilter = FilterLte(col, value)
  def <=(value: T): ModelFilter = lte(value)

  // optional

  def gt(opt: Option[T]): Option[ModelFilter] = opt.map(gt)
  def >(opt: Option[T]): Option[ModelFilter] = opt.map(gt)

  def gte(opt: Option[T]): Option[ModelFilter] = opt.map(gte)
  def >=(opt: Option[T]): Option[ModelFilter] = opt.map(gte)

  def lt(opt: Option[T]): Option[ModelFilter] = opt.map(lt)
  def <(opt: Option[T]): Option[ModelFilter] = opt.map(lt)

  def lte(opt: Option[T]): Option[ModelFilter] = opt.map(lte)
  def <=(opt: Option[T]): Option[ModelFilter] = opt.map(lte)
}


trait StringFilters extends Underlying {

  def like(value: String): ModelFilter = FilterLike(col, value)
  def startsWith(value: String): ModelFilter = FilterStartsWith(col, value)
  def endsWith(value: String): ModelFilter = FilterEndsWith(col, value)
  def similarTo(value: String): ModelFilter = FilterSimilarTo(col, value)

  // re

  def reMatch(value: String): ModelFilter = FilterReIMatch(col, value)
  def ~(value: String): ModelFilter = reMatch(value)

  def reIMatch(value: String): ModelFilter = FilterReIMatch(col, value)
  def ~*(value: String): ModelFilter = reIMatch(value)

  def reNotMatch(value: String): ModelFilter = FilterReNotMatch(col, value)
  def !~(value: String): ModelFilter = reNotMatch(value)

  def reNotIMatch(value: String): ModelFilter = FilterReNotImatch(col, value)
  def !~*(value: String): ModelFilter = reNotIMatch(value)
}













