package kuzminki.model


case class RealCol(info: ColInfo) extends RenderableCol with NoArgs {
  def render(prefix: Prefix) = prefix.pick(info)
}

object RealCol {
  def create(name: String, table: String) = RealCol(ColInfo(name, table))
}
