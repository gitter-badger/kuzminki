package kuzminki.model


sealed trait ModelSorting extends ModelRender {
  def col: ModelCol
  def template: String
  def render = template.format(col.render)
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