package kuzminki.model



trait Assign extends ModelRender {
  val col: ModelCol
  val value: Any
  def args = Seq(value)

}

case class SetValue(col: ModelCol, value: Any) extends Assign {
  def render = s"${col.name} = ?"
}

case class Increment(col: ModelCol, value: Any) extends Assign {
  def render = s"${col.name} = ${col.name} + ?"
}

case class Decrement(col: ModelCol, value: Any) extends Assign {
  def render = s"${col.name} = ${col.name} - ?"
}




