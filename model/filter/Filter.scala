package kuzminki.model


trait Filter extends Render {
  val col: ModelCol
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

case class FilterMatches(col: ModelCol, arg: Any) extends SingleArgFilter {
  def template = "%s = ?"
}

case class FilterNot(col: ModelCol, arg: Any) extends SingleArgFilter {
  def template = "%s != ?"
}

case class FilterGt(col: ModelCol, arg: Any) extends SingleArgFilter {
  def template = "%s > ?"
}

case class FilterGte(col: ModelCol, arg: Any) extends SingleArgFilter {
  def template = "%s >= ?"
}

case class FilterLt(col: ModelCol, arg: Any) extends SingleArgFilter {
  def template = "%s < ?"
}

case class FilterLte(col: ModelCol, arg: Any) extends SingleArgFilter {
  def template = "%s <= ?"
}

case class FilterIn(col: ModelCol, args: Seq[Any]) extends Filter {
  def template = "%s = ANY(ARRAY[%s])"
  def render = template.format(col.render, Vector.fill(args.size)("?").mkString(", "))
}

case class FilterNotIn(col: ModelCol, args: Seq[Any]) extends Filter {
  def template = "%s != ANY(ARRAY[%s])"
  def render = template.format(col.render, Vector.fill(args.size)("?").mkString(", "))
}

case class FilterInSubquery(col: ModelCol, sub: UntypedSubQuery) extends Filter {
  def template = "%s = ANY(%s)"
  def render = template.format(col.render, sub.render)
  def args = sub.args
}

case class FilterNotInSubquery(col: ModelCol, sub: UntypedSubQuery) extends Filter {
  def template = "%s != ANY(%s)"
  def render = template.format(col.render, sub.render)
  def args = sub.args
}

case class FilterBetween(col: ModelCol, args: Seq[Any]) extends Filter {
  def template = "%s = BETWEEN ? AND ?"
  def render = template.format(col.render)
}

case class FilterIsNull(col: ModelCol) extends NoArgFilter {
  def template = "%s IS NULL"
}

case class FilterIsNotNull(col: ModelCol) extends NoArgFilter {
  def template = "%s IS NOT NULL"
}

case class FilterLike(col: ModelCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?%"
}

case class FilterStartsWith(col: ModelCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE ?%"
}

case class FilterEndsWith(col: ModelCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE %?"
}

case class FilterSimilarTo(col: ModelCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReMatch(col: ModelCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReIMatch(col: ModelCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotMatch(col: ModelCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotImatch(col: ModelCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}



























