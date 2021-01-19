package kuzminki.model


trait MultiFilter extends Filter {
  val filters: Seq[Filter]
  def glue: String
  def render = "(%s)".format(filters.map(_.render).mkString(glue))
  def prefix(picker: Prefix) = "(%s)".format(filters.map(_.prefix(picker)).mkString(glue))
  def args = filters.map(_.args).flatten
}

object Or {

  def opts(opts: Option[Filter]*): Option[Filter] = {
    opts.flatten match {
      case Nil => None
      case head :: Nil => Some(head)
      case filters => Some(Or(filters: _*))
    }
  }
}

case class Or(filters: Filter*) extends MultiFilter {

  def glue = " OR "

  filters.foreach {
    case f: Or => throw KuzminkiException("Or cannot be within Or")
    case _ =>
  }
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

case class And(filters: Filter*) extends MultiFilter {
  
  def glue = " AND "

  filters.foreach {
    case f: And => throw KuzminkiException("And cannot be within And")
    case _ =>
  }
}


