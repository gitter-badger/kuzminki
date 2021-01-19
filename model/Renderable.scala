package kuzminki.model


trait Renderable {
  def render: String
  def prefix(picker: Prefix): String
  def args: Seq[Any]
}

