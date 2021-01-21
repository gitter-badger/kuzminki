package kuzminki.model


trait Renderable {
  def render(prefix: Prefix): String
  def args: Seq[Any]
}

