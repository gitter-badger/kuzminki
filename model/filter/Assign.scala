package kuzminki.model


trait Assign extends Renderable {
  val col: ModelCol
  val value: Any
  def format(name: String): String
  def render(prefix: Prefix) = format(col.name)
  def args = Seq(value)
}

case class SetValue(col: ModelCol, value: Any) extends Assign {
  def format(name: String) = s"$name = ?"
}

case class Increment(col: ModelCol, value: Any) extends Assign {
  def format(name: String) = s"$name = $name + ?"
}

case class Decrement(col: ModelCol, value: Any) extends Assign {
  def format(name: String) = s"$name = $name - ?"
}




