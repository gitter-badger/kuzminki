package kuzminki.model


trait ColFunction extends AnyCol {
  val self = this
  def template: String
  def render(prefix: Prefix) = template.format(col.render(prefix))
}