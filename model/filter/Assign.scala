package kuzminki.model



trait Assign extends Renderable {
  val col: RealCol
  val value: Any
  def template: String
  def format(name: String): String
  def render = format(col.render)
  def prefix(picker: Prefix) = format(col.prefix(picker))
  def args = Seq(value)
}

case class SetValue(col: RealCol, value: Any) extends Assign {
  def format(name: String) = a"$name = ?"
}

case class Increment(col: RealCol, value: Any) extends Assign {
  def format(name: String) = "$name = $name + ?"
}

case class Decrement(col: RealCol, value: Any) extends Assign {
  def format(name: String) = "$name = $name - ?"
}




