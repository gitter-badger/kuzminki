package kuzminki.model


trait Collectable {
  def render: String
  def args: Seq[Any]
}