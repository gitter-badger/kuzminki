package kuzminki.model


trait RealCol extends ModelCol with SortingCol {
  val name: String
  val model: Model

  def real = this

  def render = {
    model.__prefix match {
      case Some(prefix) => "%s.%s".format(wrap(prefix), wrap(name))
      case None => wrap(name) 
    }
  }

  def args = Seq.empty[Any]
}