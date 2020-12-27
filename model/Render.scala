package kuzminki.model


trait Render {
  def render: String
  def args: Seq[Any]
}