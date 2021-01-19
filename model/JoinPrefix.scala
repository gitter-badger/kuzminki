package kuzminki.model


trait Prefix {
  def wrap[M <: Model](model: M): String
}

object Prefix {
  def fromJoin[A, B](join: Join[A, B]): Prefix = new JoinPrefix(join.a, join.b)
}


class JoinPrefix[A <: Model, B <: Model](a: A, b: B) extends Prefix {

  def wrap[M <: Model](model: M) = {
    model match {
      case model if model == a => "\"a\""
      case model if model == b => "\"b\""
      case _ => 
        throw KuzminkiException(
          "column %s is not a member of table %s or $s".format(col.name, a.__name, b.__name)
        )
    }
  }
}