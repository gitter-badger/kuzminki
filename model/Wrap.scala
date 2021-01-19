package kuzminki.model


trait Wrap {
  def wrap(name: String) = "\"%s\"".format(name)
}