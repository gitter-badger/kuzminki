package kuzminki.model


trait Filter extends Render {
  val col: Render
  def template: String
}

trait SingleArgFilter extends Filter {
  val arg: Any
  def render = template.format(col.render)
  def args = Seq(arg)
}

trait NoArgFilter extends Filter {
  def render = template.format(col.render)
  def args = Seq.empty[Any]
}

case class FilterMatches(col: Render, arg: Any) extends SingleArgFilter {
  def template = "%s = ?"
}

case class FilterNot(col: Render, arg: Any) extends SingleArgFilter {
  def template = "%s != ?"
}

case class FilterGt(col: Render, arg: Any) extends SingleArgFilter {
  def template = "%s > ?"
}

case class FilterGte(col: Render, arg: Any) extends SingleArgFilter {
  def template = "%s >= ?"
}

case class FilterLt(col: Render, arg: Any) extends SingleArgFilter {
  def template = "%s < ?"
}

case class FilterLte(col: Render, arg: Any) extends SingleArgFilter {
  def template = "%s <= ?"
}

case class FilterIn(col: Render, args: Seq[Any]) extends Filter {
  def template = "%s = ANY(ARRAY[%s])"
  def render = template.format(col.render, Vector.fill(args.size)("?").mkString(", "))
}

case class FilterNotIn(col: Render, args: Seq[Any]) extends Filter {
  def template = "%s != ANY(ARRAY[%s])"
  def render = template.format(col.render, Vector.fill(args.size)("?").mkString(", "))
}

case class FilterInSubquery(col: Render, sub: UntypedSubQuery) extends Filter {
  def template = "%s = ANY(%s)"
  def render = template.format(col.render, sub.render)
  def args = sub.args
}

case class FilterNotInSubquery(col: Render, sub: UntypedSubQuery) extends Filter {
  def template = "%s != ANY(%s)"
  def render = template.format(col.render, sub.render)
  def args = sub.args
}

case class FilterBetween(col: Render, args: Seq[Any]) extends Filter {
  def template = "%s = BETWEEN ? AND ?"
  def render = template.format(col.render)
}

case class FilterIsNull(col: Render) extends NoArgFilter {
  def template = "%s IS NULL"
}

case class FilterIsNotNull(col: Render) extends NoArgFilter {
  def template = "%s IS NOT NULL"
}

case class FilterLike(col: Render, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?%"
}

case class FilterStartsWith(col: Render, arg: String) extends SingleArgFilter {
  def template = "%s LIKE ?%"
}

case class FilterEndsWith(col: Render, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?"
}

case class FilterSimilarTo(col: Render, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReMatch(col: Render, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReIMatch(col: Render, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotMatch(col: Render, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotImatch(col: Render, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}



























