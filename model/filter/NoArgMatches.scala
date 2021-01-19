package kuzminki.model


case class NoArgMatches(col: RenderableCol) extends Renderable with NoArgs {
  def template = "%s = ?"
  def render = template.format(col.render)
  def prefix(picker: Prefix) = template.format(col.prefix(picker))
}