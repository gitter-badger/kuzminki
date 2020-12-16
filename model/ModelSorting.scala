package kuzminki.model

import kuzminki.builder._


sealed trait ModelSorting extends Renderable {
  def col: ModelCol
  def template: String
  def render = template.format(col.render)
  def wrap = template.format(col.wrap)
  def args = Seq.empty[Any]
}

case class ModelSort(col: ModelCol) extends ModelSorting {
  def template = "%s ASC"
  def asc = ModelAsc(col)
  def desc = ModelDesc(col)
}

case class ModelAsc(col: ModelCol) extends ModelSorting {
  def template = "%s ASC"
}

case class ModelDesc(col: ModelCol) extends ModelSorting {
  def template = "%s DESC"
}