package kuzminki.model


trait Filter extends Renderable {
  def template: String
}

trait SingleFilter extends Filter with ColRef {
  def render(prefix: Prefix) = template.format(col.render(prefix))
}

trait SingleArgFilter extends SingleFilter {
  val arg: Any
  def args = col.args ++ Seq(arg)
}

trait NoArgFilter extends SingleFilter with ColArgs

trait SubQueryFilter extends Filter with ColRef {
  val sub: Renderable
  def render(prefix: Prefix) = template.format(col.render(prefix), sub.render(prefix))
  def args = col.args ++ sub.args
}

trait ArrayFilter extends Filter with ColRef {
  val argSeq: Seq[Any]
  def render(prefix: Prefix) = template.format(col.render(prefix), Vector.fill(args.size)("?").mkString(", "))
  def args = col.args ++ argSeq
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

case class FilterIn(col: RenderableCol, argSeq: Seq[Any]) extends ArrayFilter {
  def template = "%s = ANY(ARRAY[%s])"
}

case class FilterNotIn(col: RenderableCol, argSeq: Seq[Any]) extends ArrayFilter {
  def template = "%s != ANY(ARRAY[%s])"
}

case class FilterBetween(col: RenderableCol, argSeq: Seq[Any]) extends SingleFilter {
  def template = "%s = BETWEEN ? AND ?"
  def args = col.args ++ argSeq
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

case class FilterInSubquery(col: RenderableCol, sub: Renderable) extends SubQueryFilter {
  def template = "%s = ANY(%s)"
}

case class FilterNotInSubquery(col: RenderableCol, sub: Renderable) extends SubQueryFilter {
  def template = "%s != ANY(%s)"
}

case class FilterAggMatches(col: RenderableCol, sub: Renderable) extends SubQueryFilter {
  def template = "%s = (%s)"
}

case class FilterAggNot(col: RenderableCol, sub: Renderable) extends SubQueryFilter {
  def template = "%s != (%s)"
}

case class FilterAggGt(col: RenderableCol, sub: Renderable) extends SubQueryFilter {
  def template = "%s > (%s)"
}

case class FilterAggGte(col: RenderableCol, sub: Renderable) extends SubQueryFilter {
  def template = "%s >= (%s)"
}

case class FilterAggLt(col: RenderableCol, sub: Renderable) extends SubQueryFilter {
  def template = "%s < (%s)"
}

case class FilterAggLte(col: RenderableCol, sub: Renderable) extends SubQueryFilter {
  def template = "%s <= (%s)"
}

// where not exists

case class FilterMatchesNoArg(col: RenderableCol) extends NoArgFilter {
  def template = "%s = ?"
}
























