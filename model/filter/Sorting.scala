package kuzminki.model


sealed trait Sorting extends Renderable {
  def col: RenderableCol
  def template: String
  def render = template.format(col.render)
  def prefix(picker: Prefix) = template.format(col.prefix(picker))
  def args = Seq.empty[Any]
}

case class Sort(col: RenderableCol) extends Sorting {
  def template = "%s ASC"
  def asc = Asc(col)
  def desc = Desc(col)
}

case class Asc(col: RenderableCol) extends Sorting {
  def template = "%s ASC"
}

case class Desc(col: RenderableCol) extends Sorting {
  def template = "%s DESC"
}