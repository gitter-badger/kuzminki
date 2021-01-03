package kuzminki.model


object Or {

  def opts(opts: Option[Filter]*): Option[Filter] = {
    opts.flatten match {
      case Nil => None
      case head :: Nil => Some(head)
      case filters => Some(Or(filters: _*))
    }
  }
}

case class Or(filters: Filter*) extends Filter with Render {

  filters.foreach {
    case f: Any => throw KuzminkiModelException("ANY cannot be within ANY")
    case _ =>
  }

  def render = "(%s)".format(filters.map(_.render).mkString(" OR "))
  def args = filters.map(_.args).flatten
}

object And {

  def opts(opts: Option[Filter]*): Option[Filter] = {
    opts.flatten match {
      case Nil => None
      case head :: Nil => Some(head)
      case filters => Some(And(filters: _*))
    }
  }
}

case class And(filters: Filter*) extends Filter with Render {
  
  filters.foreach {
    case f: Any => throw KuzminkiModelException("ALL cannot be within ALL")
    case _ =>
  }

  def render = "(%s)".format(filters.map(_.render).mkString(" AND "))
  def args = filters.map(_.args).flatten
}