package kuzminki.model


case class NoArgMatches(col: RenderableCol) extends Renderable with NoArgs {
  def template = "%s = ?"
  def render(prefix: Prefix) = template.format(col.render(prefix))
}