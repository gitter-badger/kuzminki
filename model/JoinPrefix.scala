package kuzminki.model


trait Prefix {
  def wrap(table: String): String
}

object Prefix {
  def fromJoin[A <: Model, B <: Model](join: Join[A, B]): Prefix = {
    new JoinPrefix(join.a.__name, join.b.__name)
  }
}

class JoinPrefix(aName: String, bName: String) extends Prefix {

  def wrap(table: String) = {
    if (table == aName) {
      "\"a\""
    } else if (table == bName) {
      "\"b\""
    } else {
      throw KuzminkiException(
        "column %s is not a member of table %s or $s".format(table, aName, bName)
      )
    }
  }
}