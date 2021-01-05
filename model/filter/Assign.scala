package kuzminki.model



trait Assign extends Render {
  val col: Render
  val value: Any
  def args = Seq(value)

}

case class SetValue(col: RealCol, value: Any) extends Assign {
  def render = "%s = ?".format(col.render)
}

case class Increment(col: RealCol, value: Any) extends Assign {
  def render = "%s = %s + ?".format(col.render, col.render)
}

case class Decrement(col: RealCol, value: Any) extends Assign {
  def render = "%s = %s - ?".format(col.render, col.render)
}




