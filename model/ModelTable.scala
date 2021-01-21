package kuzminki.model


case class ModelTable(table: Model) extends Renderable with NoArgs {
  def render(prefix: Prefix) = prefix.table(table.__name)
}


