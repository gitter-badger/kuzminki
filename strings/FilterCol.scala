package kuzminki.strings

import kuzminki.builder._


case class FilterCol(col: ColName) {

  //def samasem(value: Any): Filter = Filter.create(s"$name = ?", value)

  // written

  def matches(value: Any): Filter = FilterMatches(col, value)

  def not(value: Any): Filter = FilterNot(col, value)

  def gt(value: Any): Filter = FilterGt(col, value)

  def gte(value: Any): Filter = FilterGte(col, value)

  def lt(value: Any): Filter = FilterLt(col, value)

  def lte(value: Any): Filter = FilterLte(col, value)

  // operators

  def ===(value: Any): Filter = matches(value)

  def !==(value: Any): Filter = not(value)

  def >(value: Any): Filter = gt(value)

  def >=(value: Any): Filter = gte(value)

  def <(value: Any): Filter = lt(value)

  def <=(value: Any): Filter = lte(value)

  // range

  def in(value: Seq[Any]): Filter = FilterIn(col, value)

  def between(first: Any, second: Any): Filter = FilterBetween(col, Seq(first, second))

  // null

  def isNull: Filter = FilterIsNull(col)

  def isNotNull: Filter = FilterIsNotNull(col)

  // pattern

  def like(value: String): Filter = FilterLike(col, value)

  def startsWith(value: String): Filter = FilterStartsWith(col, value)

  def endsWith(value: String): Filter = FilterEndsWith(col, value)

  def similarTo(value: String): Filter = FilterSimilarTo(col, value)

  // re

  def reMatch(value: String): Filter = FilterReIMatch(col, value)

  def reIMatch(value: String): Filter = FilterReIMatch(col, value)

  def reNotMatch(value: String): Filter = FilterReNotMatch(col, value)

  def reNotIMatch(value: String): Filter = FilterReNotImatch(col, value)

  // re operators

  def ~(value: String): Filter = reMatch(value)

  def ~*(value: String): Filter = reIMatch(value)

  def !~(value: String): Filter = reNotMatch(value)

  def !~*(value: String): Filter = reNotIMatch(value)
}