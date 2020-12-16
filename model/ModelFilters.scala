package kuzminki.model

import kuzminki.builder._


trait Underlying {
  def col: ModelCol
}


trait UniversalFilters[T] extends Underlying {
  
  def matches(value: T): Filter = FilterMatches(col, value)
  def ===(value: T): Filter = matches(value)

  def not(value: T): Filter = FilterNot(col, value)
  def !==(value: T): Filter = not(value)
  
  def isNull: Filter = FilterIsNull(col)
  def isNotNull: Filter = FilterIsNotNull(col)

  def in(value: Seq[T]): Filter = FilterIn(col, value)
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













