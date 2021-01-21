package kuzminki.model


object Wrap {
  val template = "\"%s\""
}

trait Wrap {
  def wrap(name: String) = Wrap.template.format(name)
}