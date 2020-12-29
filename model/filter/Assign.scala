package kuzminki.model



trait Assign extends Render {
  val col: ModelCol
  val value: Any
  def args = Seq(value)

}

case class SetValue(col: ModelCol, value: Any) extends Assign {
  def render = "%s = ?".format(col.render)
}

case class Increment(col: ModelCol, value: Any) extends Assign {
  def render = "%s = %s + ?".format(col.render, col.render)
}

case class Decrement(col: ModelCol, value: Any) extends Assign {
  def render = "%s = %s - ?".format(col.render, col.render)
}




