package kuzminki.model


trait ModelCol extends AnyCol with NoArgs with SortingDirection {          
  val info: ColInfo
  val col: AnyCol = this
  val modelCol = this
  def render(prefix: Prefix) = prefix.pick(info)
}



