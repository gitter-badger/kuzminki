package kuzminki.model


case class NoArgMatches(col: ModelCol) extends Render with NoArgs {
  def render = "%s = ?".format(col.render)
}