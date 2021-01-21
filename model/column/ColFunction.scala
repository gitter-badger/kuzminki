package kuzminki.model


trait ColFunction extends RenderableCol {
  def template: String
  def render(prefix: Prefix) = template.format(col.render(prefix))
}