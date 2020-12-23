package kuzminki.model


trait Underlying {
  def col: ModelCol
}


trait UniversalFilters[T] extends Underlying {
  
  def matches(value: T): ModelFilter = FilterMatches(col, value)
  def ===(value: T): ModelFilter = matches(value)

  def not(value: T): ModelFilter = FilterNot(col, value)
  def !==(value: T): ModelFilter = not(value)
  
  def isNull: ModelFilter = FilterIsNull(col)
  def isNotNull: ModelFilter = FilterIsNotNull(col)

  def in(value: Seq[T]): ModelFilter = FilterIn(col, value)

  // optional

  def matches(opt: Option[T]): OptionalFilter = {
    opt match {
      case Some(value) => matches(value)
      case None => VoidFilter
    }
  }

  def ===(opt: Option[T]): OptionalFilter = matches(opt)

  def not(opt: Option[T]): OptionalFilter = {
    opt match {
      case Some(value) => not(value)
      case None => VoidFilter
    }
  }

  def !==(opt: Option[T]): OptionalFilter = not(opt)
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

  def gt(opt: Option[T]): OptionalFilter = {
    opt match {
      case Some(value) => gt(value)
      case None => VoidFilter
    }
  }

  def >(opt: Option[T]): OptionalFilter = gt(opt)

  def gte(opt: Option[T]): OptionalFilter = {
    opt match {
      case Some(value) => gte(value)
      case None => VoidFilter
    }
  }

  def >=(opt: Option[T]): OptionalFilter = gte(opt)

  def lt(opt: Option[T]): OptionalFilter = {
    opt match {
      case Some(value) => lt(value)
      case None => VoidFilter
    }
  }

  def <(opt: Option[T]): OptionalFilter = lt(opt)

  def lte(opt: Option[T]): OptionalFilter = {
    opt match {
      case Some(value) => lte(value)
      case None => VoidFilter
    }
  }

  def <=(opt: Option[T]): OptionalFilter = lte(opt)
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













