package kuzminki.builder


trait Filter extends Renderable {
  val col: Renderable
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

case class FilterMatches(col: Renderable, arg: Any) extends SingleArgFilter {
  def template = "%s = ?"
}

case class FilterNot(col: Renderable, arg: Any) extends SingleArgFilter {
  def template = "%s != ?"
}

case class FilterGt(col: Renderable, arg: Any) extends SingleArgFilter {
  def template = "%s > ?"
}

case class FilterGte(col: Renderable, arg: Any) extends SingleArgFilter {
  def template = "%s >= ?"
}

case class FilterLt(col: Renderable, arg: Any) extends SingleArgFilter {
  def template = "%s < ?"
}

case class FilterLte(col: Renderable, arg: Any) extends SingleArgFilter {
  def template = "%s <= ?"
}

case class FilterIn(col: Renderable, arg: Seq[Any]) extends SingleArgFilter {
  def template = "%s = ANY(?)"
}

case class FilterBetween(col: Renderable, args: Seq[Any]) extends Filter {
  def template = "%s = BETWEEN ? AND ?"
}

case class FilterIsNull(col: Renderable) extends NoArgFilter {
  def template = "%s IS NULL"
}

case class FilterIsNotNull(col: Renderable) extends NoArgFilter {
  def template = "%s IS NOT NULL"
}

case class FilterLike(col: Renderable, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?%"
}

case class FilterStartsWith(col: Renderable, arg: String) extends SingleArgFilter {
  def template = "%s LIKE ?%"
}

case class FilterEndsWith(col: Renderable, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?"
}

case class FilterSimilarTo(col: Renderable, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReMatch(col: Renderable, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReIMatch(col: Renderable, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotMatch(col: Renderable, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotImatch(col: Renderable, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}



























