package kuzminki.model


trait ColFunction extends AnyCol {
  def template: String
  def render(prefix: Prefix) = template.format(col.render(prefix))
}