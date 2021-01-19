package kuzminki.model


trait Filter extends Renderable {
  val col: RenderableCol
  def template: String
}

trait SingleFilter extends Filter {
  val col: RenderableCol
  def template: String
  def render = template.format(col.render)
  def prefix(picker: Prefix) = template.format(col.prefix(picker))
}

trait SingleArgFilter extends SingleFilter {
  val arg: Any
  def args = Seq(arg)
}

trait NoArgFilter extends SingleFilter with NoArgs

trait SubQueryFilter extends SingleFilter {
  val sub: UntypedSubQuery
  def args = sub.args
}

case class FilterMatches(col: RenderableCol, arg: Any) extends SingleArgFilter {
  def template = "%s = ?"
}

case class FilterNot(col: RenderableCol, arg: Any) extends SingleArgFilter {
  def template = "%s != ?"
}

case class FilterGt(col: RenderableCol, arg: Any) extends SingleArgFilter {
  def template = "%s > ?"
}

case class FilterGte(col: RenderableCol, arg: Any) extends SingleArgFilter {
  def template = "%s >= ?"
}

case class FilterLt(col: RenderableCol, arg: Any) extends SingleArgFilter {
  def template = "%s < ?"
}

case class FilterLte(col: RenderableCol, arg: Any) extends SingleArgFilter {
  def template = "%s <= ?"
}

case class FilterIn(col: RenderableCol, args: Seq[Any]) extends Filter {
  def template = "%s = ANY(ARRAY[%s])"
  def render = template.format(col.render, Vector.fill(args.size)("?").mkString(", "))
}

case class FilterNotIn(col: RenderableCol, args: Seq[Any]) extends Filter {
  def template = "%s != ANY(ARRAY[%s])"
  def render = template.format(col.render, Vector.fill(args.size)("?").mkString(", "))
}

case class FilterBetween(col: RenderableCol, args: Seq[Any]) extends Filter {
  def template = "%s = BETWEEN ? AND ?"
  def render = template.format(col.render)
}

case class FilterIsNull(col: RenderableCol) extends NoArgFilter {
  def template = "%s IS NULL"
}

case class FilterIsNotNull(col: RenderableCol) extends NoArgFilter {
  def template = "%s IS NOT NULL"
}

case class FilterLike(col: RenderableCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?%"
}

case class FilterStartsWith(col: RenderableCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE ?%"
}

case class FilterEndsWith(col: RenderableCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?"
}

case class FilterSimilarTo(col: RenderableCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReMatch(col: RenderableCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReIMatch(col: RenderableCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotMatch(col: RenderableCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotImatch(col: RenderableCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

// sub query

case class FilterInSubquery(col: RenderableCol, sub: UntypedSubQuery) extends SubQueryFilter {
  def template = "%s = ANY(%s)".format(sub.render)
}

case class FilterNotInSubquery(col: RenderableCol, sub: UntypedSubQuery) extends SubQueryFilter {
  def template = "%s != ANY(%s)".format(sub.render)
}

case class FilterAggMatches(col: RenderableCol, sub: UntypedSubQuery) extends SubQueryFilter {
  def template = "%s = (%s)".format(sub.render)
}

case class FilterAggNot(col: RenderableCol, sub: UntypedSubQuery) extends SubQueryFilter {
  def template = "%s != (%s)".format(sub.render)
}

case class FilterAggGt(col: RenderableCol, sub: UntypedSubQuery) extends SubQueryFilter {
  def template = "%s > (%s)".format(sub.render)
}

case class FilterAggGte(col: RenderableCol, sub: UntypedSubQuery) extends SubQueryFilter {
  def template = "%s >= (%s)".format(sub.render)
}

case class FilterAggLt(col: RenderableCol, sub: UntypedSubQuery) extends SubQueryFilter {
  def template = "%s < (%s)".format(sub.render)
}

case class FilterAggLte(col: RenderableCol, sub: UntypedSubQuery) extends SubQueryFilter {
  def template = "%s <= (%s)".format(sub.render)
}

// where not exists

case class FilterMatchesNoArg(col: RenderableCol) extends NoArgFilter {
  def template = "%s = ?"
}
























