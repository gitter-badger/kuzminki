package kuzminki.model


sealed trait Sorting extends Render {
  def col: Render
  def template: String
  def render = template.format(col.render)
  def args = Seq.empty[Any]
}

case class Sort(col: Render) extends Sorting {
  def template = "%s ASC"
  def asc = Asc(col)
  def desc = Desc(col)
}

case class Asc(col: Render) extends Sorting {
  def template = "%s ASC"
}

case class Desc(col: Render) extends Sorting {
  def template = "%s DESC"
}