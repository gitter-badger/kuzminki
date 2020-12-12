package kuzminki


trait Filter extends Renderable {
  val col: ColName
  def template: String
  def render = template.format(col.render)
  def wrap = template.format(col.wrap)
}

trait SingleArgFilter extends Filter {
  val arg: Any
  def args = Seq(arg)
}

trait NoArgFilter extends Filter {
  def args = Seq.empty[Any]
}

case class FilterMatches(col: ColName, arg: Any) extends SingleArgFilter {
  def template = "%s = ?"
}

case class FilterNot(col: ColName, arg: Any) extends SingleArgFilter {
  def template = "%s != ?"
}

case class FilterGt(col: ColName, arg: Any) extends SingleArgFilter {
  def template = "%s > ?"
}

case class FilterGte(col: ColName, arg: Any) extends SingleArgFilter {
  def template = "%s >= ?"
}

case class FilterLt(col: ColName, arg: Any) extends SingleArgFilter {
  def template = "%s < ?"
}

case class FilterLte(col: ColName, arg: Any) extends SingleArgFilter {
  def template = "%s <= ?"
}

case class FilterIn(col: ColName, arg: Seq[Any]) extends SingleArgFilter {
  def template = "%s = ANY(?)"
}

case class FilterBetween(col: ColName, args: Seq[Any]) extends Filter {
  def template = "%s = BETWEEN ? AND ?"
}

case class FilterIsNull(col: ColName) extends NoArgFilter {
  def template = "%s IS NULL"
}

case class FilterIsNotNull(col: ColName) extends NoArgFilter {
  def template = "%s = IS NOT NULL"
}

case class FilterLike(col: ColName, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?%"
}

case class FilterStartsWith(col: ColName, arg: String) extends SingleArgFilter {
  def template = "%s LIKE ?%"
}

case class FilterEndsWith(col: ColName, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?"
}

case class FilterSimilarTo(col: ColName, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReMatch(col: ColName, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReIMatch(col: ColName, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotMatch(col: ColName, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotImatch(col: ColName, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}



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























