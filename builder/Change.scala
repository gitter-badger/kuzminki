package kuzminki



case class Change(col: Col, rep: Replacement) extends Renderable {
  def render = rep.format(col.render)
  def wrap = rep.format(col.wrap)
  def args = rep.args
}


object Change {
  
  def box(value: Any): Replacement = {
    value match {
      case Replacement => value
      case _ => ReplaceValue(value)
  }
}

trait Replacement {
  def format(name: String): String
  def args: Seq[Any]
}

case class ReplaceValue(value: Any) {
  def format(name: String) = s"$name = ?"
  def args = Seq(value)
}


case class Increment(amount: Int) extends Replacement {
  def format(name: String) = s"$name = $name + ?"
  def args = Seq(amount)
}

case class Decrement(amount: Int) extends Replacement {
  def format(name: String) = s"$name = $name - ?"
  def args = Seq(value)
}