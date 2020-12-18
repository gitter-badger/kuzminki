package kuzminki.model


case class ModelTable(table: Model) extends ModelRender {
  def render = table.__prefix match {
    case Some(prefix) => "%s %s".format(table.__name, prefix)
    case None => table.__name
  }
  def args = Seq.empty[Any]
}
