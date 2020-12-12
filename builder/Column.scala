package kuzminki


trait Column extends Renderable with Wrap {
  def args = Seq.empty[Any]
}

trait ColumnFunction extends Column {
  val name: String
  def template: String
  def render = template.format(name)
  def wrap = template.format(safe(name))
  def as(alias: String) = ColAlias(this, alias)
}

case object All extends Column {
  def render = "*"
  def wrap = render
}

case class Col(name: String) extends Column {
  def render = name
  def wrap = safe(name)
  def as(alias: String) = ColAlias(this, alias)
}

case class ColAlias(col: Column, alias: String) extends Column {
  def render = "%s AS %s".format(col.render, alias)
  def wrap = "%s AS %s".format(col.wrap, safe(alias))
}

case class Sum(name: String) extends ColumnFunction {
  def template = s"SUM(%s)"
}

case class Max(name: String) extends ColumnFunction {
  def template = s"MAX(%s)"
}

case class Min(name: String) extends ColumnFunction {
  def template = s"MIN(%s)"
}