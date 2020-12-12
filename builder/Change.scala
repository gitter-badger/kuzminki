package kuzminki



case class Change(column: ColName, mod: Modification) extends Renderable {
  def render = mod.format(column.render)
  def wrap = mod.format(column.wrap)
  def args = mod.args
}

object Change {
  
  def box(value: Any): Modification = {
    value match {
      case mod: Modification => mod
      case _ => SetValue(value)
    }
  }
}

trait Modification {
  def format(name: String): String
  def args: Seq[Any]
}

case class SetValue(value: Any) extends Modification {
  def format(name: String) = s"$name = ?"
  def args = Seq(value)
}

case class Inc(amount: Int) extends Modification {
  def format(name: String) = s"$name = $name + ?"
  def args = Seq(amount)
}

case class Dec(amount: Int) extends Modification {
  def format(name: String) = s"$name = $name - ?"
  def args = Seq(amount)
}