package kuzminki.model


case class NoArgMatches(col: AnyCol) extends AnyCol with NoArgs {
  def template = "%s = ?"
  def render(prefix: Prefix) = template.format(col.render(prefix))
}