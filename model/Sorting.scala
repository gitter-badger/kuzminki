package kuzminki.model


sealed trait Sorting extends Render {
  def col: ModelCol
  def template: String
  def render = template.format(col.render)
  def args = Seq.empty[Any]
}

case class Sort(col: ModelCol) extends Sorting {
  def template = "%s ASC"
  def asc = Asc(col)
  def desc = Desc(col)
}

case class Asc(col: ModelCol) extends Sorting {
  def template = "%s ASC"
}

case class Desc(col: ModelCol) extends Sorting {
  def template = "%s DESC"
}