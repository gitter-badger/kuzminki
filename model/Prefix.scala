package kuzminki.model


trait Prefix {
  def pick(info: ColInfo): String
  def table(table: String): String
}

object Prefix {

  val prefixA = "a"
  val prefixB = "b"
  val prefixWrap = "\"%s\".\"%s\""
  val tableWrap = "\"%s\" \"%s\""

  val noPrefix = new NoPrefix

  def forJoin[A <: Model, B <: Model](join: Join[A, B]): Prefix = {
    new JoinPrefix(join.a.__name, join.b.__name)
  }

  def forModel: Prefix = noPrefix
}

class NoPrefix extends Prefix with Wrap {
  def pick(info: ColInfo) = wrap(info.name)
  def table(table: String) = wrap(table)
}

class JoinPrefix(tableA: String, tableB: String) extends Prefix {

  import Prefix._

  def pick(info: ColInfo) = {
    info match {
      case ColInfo(name, table) if info.table == tableA =>
        prefixWrap.format(prefixA, name)
      
      case ColInfo(name, table) if info.table == tableB =>
        prefixWrap.format(prefixB, name)
      
      case ColInfo(name, table) =>
        throw KuzminkiException(
          "column %s of table %s is not found in join(%s, $s)".format(name, table, tableA, tableB)
        )
    }
  }

  def table(table: String) = {
    table match {
      case table if table == tableA =>
        tableWrap.format(table, prefixA)
      
      case table if table == tableB =>
        tableWrap.format(table, prefixB)
      
      case table =>
        throw KuzminkiException(
          "table %s is not a member of join(%s, $s)".format(table, tableA, tableB)
        )
    }
  }
}














