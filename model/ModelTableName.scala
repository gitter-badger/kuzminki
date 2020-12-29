package kuzminki.model


case class ModelTable(table: Model) extends Render {
  def render = table.__prefix match {
    case Some(prefix) => "%s %s".format(wrap(table.__name), wrap(prefix))
    case None => wrap(table.__name)
  }
  def args = Seq.empty[Any]
}
