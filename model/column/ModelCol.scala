package kuzminki.model


trait ModelCol extends RenderableCol with NoArgs with SortingCol {
           
  val info: ColInfo
  val col: RenderableCol = this
  val modelCol: ModelCol = this

  def render(prefix: Prefix) = prefix.pick(info)
}