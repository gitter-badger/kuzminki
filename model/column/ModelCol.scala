package kuzminki.model


trait ModelCol extends RenderableCol with NoArgs with Wrap with SortingCol {
           
  val table: String
  val name: String
  
  val col: RenderableCol = this
  val modelCol: ModelCol = this

  def render = wrap(name)
  def prefix(picker: Prefix) = "%s.%s".format(picker.wrap(table), wrap(name))
}