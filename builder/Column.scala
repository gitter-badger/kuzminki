package kuzminki


trait ColRef extends Renderable {
  def args = Seq.empty[Any]
}

trait ColNaming extends ColRef {}

trait ColFunction extends ColRef {
  val col: ColName
  def template: String
  def render = template.format(col.render)
  def wrap = template.format(col.wrap)
  def as(alias: String) = ColAlias(this, alias)
}

case object All extends ColRef {
  def render = "*"
  def wrap = render
}

case class ColName(name: String) extends ColNaming with Wrap {
  def render = name
  def wrap = safe(name)
  def as(alias: String) = ColAlias(this, alias)
}

case class ColAlias(col: ColRef, alias: String) extends ColNaming with Wrap {
  def render = "%s AS %s".format(col.render, alias)
  def wrap = "%s AS %s".format(col.wrap, safe(alias))
}

case class Sum(col: ColName) extends ColFunction {
  def template = s"SUM(%s)"
}

case class Max(col: ColName) extends ColFunction {
  def template = s"MAX(%s)"
}

case class Min(col: ColName) extends ColFunction {
  def template = s"MIN(%s)"
}