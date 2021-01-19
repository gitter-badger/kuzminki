package kuzminki.model


case class ModelTable(table: Model) extends Renderable with NoArgs {
  def render = wrap(table.__name)
  def prefix(picker: Prefix) = "%s %s".format(wrap(table.__name), wrap(model))
}


