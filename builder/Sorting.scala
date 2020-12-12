package kuzminki


sealed trait Sorting extends Renderable with Wrap {
  def name: String
  def template: String
  def render = template.format(name)
  def wrap = template.format(safe(name))
  def args = Seq.empty[Any]
}

case class DefaultOrder(name: String) extends Sorting {
  def template = "%s ASC"
  def asc = Asc(name)
  def desc = Desc(name)
}

case class Asc(name: String) extends Sorting {
  def template = "%s ASC"
}

case class Desc(name: String) extends Sorting {
  def template = "%s DESC"
}
