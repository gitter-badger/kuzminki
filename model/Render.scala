package kuzminki.model


trait Render {
  def wrap(name: String) = "\"%s\"".format(name)
  def render: String
  def args: Seq[Any]
}

trait NoArgs {
  def args = Seq.empty[Any]
}
