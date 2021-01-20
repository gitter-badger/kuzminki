package kuzminki.model


trait ColFunction extends RenderableCol {
  val col: RenderableCol
  def template: String
  def render = template.format(col.render)
  def prefix(picker: Prefix) = template.format(col.prefix(picker))
}