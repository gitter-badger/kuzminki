package kuzminki


trait Renderable {
  def render: String
  def wrap: String
  def args: Seq[Any]
}

object Renderable {
  def wrap(input: String) = "\"%s\"".format(input)
}

trait Wrap {
  def safe(input: String) = Renderable.wrap(input)
}

trait RenderablePretty extends Renderable {
  def pretty: String

}

trait Pretty {
  def pretty: String

}