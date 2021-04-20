package kuzminki.model


trait ModelCol extends AnyCol with SelfRef with NoArgs with SortingDirection {          
  val info: ColInfo
  val col: ModelCol = this
  val self = this
  def name = info.name
  def render(prefix: Prefix) = prefix.pick(info)
}



