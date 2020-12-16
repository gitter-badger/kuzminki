package kuzminki.strings

import kuzminki.builder._


sealed trait Sorting extends Renderable {
  def col: ColRef
  def template: String
  def render = template.format(col.render)
  def wrap = template.format(col.wrap)
  def args = Seq.empty[Any]
}

case class Sort(col: ColRef) extends Sorting {
  def template = "%s ASC"
  def asc = Asc(col)
  def desc = Desc(col)
}

case class Asc(col: ColRef) extends Sorting {
  def template = "%s ASC"
}

case class Desc(col: ColRef) extends Sorting {
  def template = "%s DESC"
}
