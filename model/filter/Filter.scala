package kuzminki.model


trait OptionalFilter {
  val isUsed: Boolean
}

object VoidFilter extends OptionalFilter {
  val isUsed = false
}

trait ModelFilter extends OptionalFilter with ModelRender {
  val col: ModelCol
  def template: String
  def render = template.format(col.render)
  val isUsed = true
}

trait SingleArgFilter extends ModelFilter {
  val arg: Any
  def args = Seq(arg)
}

trait NoArgFilter extends ModelFilter {
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

case class FilterIn(col: ModelCol, arg: Seq[Any]) extends SingleArgFilter {
  def template = "%s = ANY(?)"
}

case class FilterBetween(col: ModelCol, args: Seq[Any]) extends ModelFilter {
  def template = "%s = BETWEEN ? AND ?"
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



























