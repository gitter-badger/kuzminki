package kuzminki


trait Filter extends Renerable {
  val name: String
  def template: String
  def render = template.format(name)
  def wrap: template.format(Renderable.wrapped(name))
}

trait SingleArgFilter extends Filter {
  val arg: Any
  def args = Seq(arg)
}

trait NoArgFilter extends Filter {
  def args = Seq.empty[Any]
}

case class FilterMatches(name: String, arg: Any) extends SingleArgFilter {
  def template = "%s = ?"
}

case class FilterNot(name: String, arg: Any) extends SingleArgFilter {
  def template = "%s != ?"
}

case class FilterGt(name: String, arg: Any) extends SingleArgFilter {
  def template = "%s > ?"
}

case class FilterGte(name: String, arg: Any) extends SingleArgFilter {
  def template = "%s >= ?"
}

case class FilterLt(name: String, arg: Any) extends SingleArgFilter {
  def template = "%s < ?"
}

case class FilterLte(name: String, arg: Any) extends SingleArgFilter {
  def template = "%s <= ?"
}

case class FilterIn(name: String, arg: Seq[Any]) extends SingleArgFilter {
  def template = "%s = ANY(?)"
}

case class FilterBetween(name: String, args: Seq[Any]) extends Filter {
  def template = "%s = BETWEEN ? AND ?"
}

case class FilterIsNull(name: String) extends NoArgFilter {
  def template = "%s IS NULL"
}

case class FilterIsNotNull(name: String) extends NoArgFilter {
  def template = "%s = IS NOT NULL"
}

case class FilterLike(name: String, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?%"
}

case class FilterStartsWith(name: String, arg: String) extends SingleArgFilter {
  def template = "%s LIKE ?%"
}

case class FilterEndsWith(name: String, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?"
}

case class FilterSimilarTo(name: String, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReMatch(name: String, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReIMatch(name: String, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotMatch(name: String, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotImatch(name: String, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}



case class Condition(name: String) {

  //def samasem(value: Any): Filter = Filter.create(s"$name = ?", value)

  // written

  def matches(value: Any): Filter = FilterMatches(name, value)

  def not(value: Any): Filter = FilterNot(name, value)

  def gt(value: Any): Filter = FilterGt(name, value)

  def gte(value: Any): Filter = FilterGte(name, value)

  def lt(value: Any): Filter = FilterLt(name, value)

  def lte(value: Any): Filter = FilterLte(name, value)

  // operators

  def ===(value: Any): Filter = matches(value)

  def !==(value: Any): Filter = not(value)

  def >(value: Any): Filter = gt(value)

  def >=(value: Any): Filter = gte(value)

  def <(value: Any): Filter = lt(value)

  def <=(value: Any): Filter = lte(value)

  // range

  def in(value: Seq[Any]): Filter = FilterIn(name, value)

  def between(first: Any, second: Any): Filter = FilterBetween(name, Seq(first, second))

  // null

  def isNull: Filter = FilterIsNull(name)

  def isNotNull: Filter = FilterIsNotNull(name)

  // pattern

  def like(value: String): Filter = FilterLike(name, value)

  def startsWith(value: String): Filter = FilterStartsWith(name, value)

  def endsWith(value: String): Filter = FilterEndsWith(name, value)

  def similarTo(value: String): Filter = FilterSimilarTo(name, value)

  // re

  def reMatch(value: String): Filter = FilterReIMatch(name, value)

  def reIMatch(value: String): Filter = FilterReIMatch(name, value)

  def reNotMatch(value: String): Filter = FilterReNotMatch(name, value)

  def reNotIMatch(value: String): Filter = FilterReNotImatch(name, value)

  // re operators

  def ~(value: String): Filter = reMatch(value)

  def ~*(value: String): Filter = reIMatch(value)

  def !~(value: String): Filter = reNotMatch(value)

  def !~*(value: String): Filter = reNotIMatch(value)
}























