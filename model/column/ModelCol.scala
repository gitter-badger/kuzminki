package kuzminki.model


trait ModelCol[T] extends Renderable with ColRef with NoArgs with SortingCol {          
  val col: RealCol
  def render(prefix: Prefix) = prefix.pick(col.info)
}