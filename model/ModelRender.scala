package kuzminki.model


trait ModelRender {
  def render: String
  def args: Seq[Any]
}