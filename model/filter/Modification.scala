package kuzminki.model



trait Modification extends ModelRender {
  val arg: Any
  def args = Seq(arg)

}

case class SetValue(col: ModelCol, arg: Any) extends Modification {
  def render = s"${col.name} = ?"
}

case class Increment(col: ModelCol, arg: Any) extends Modification {
  def render = s"${col.name} = ${col.name} + ?"
}

case class Decrement(col: ModelCol, arg: Any) extends Modification {
  def render = s"${col.name} = ${col.name} - ?"
}




