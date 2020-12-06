package kuzminki

import io.rdbc.sapi._
import containers._


object UpdateStages {

  trait Table {
    def table(table: TableName): Change
  }

  trait Change {
    def set(args: (String, Any)*): Where
    def set(args: List[(String, Any)]): Where
  }

  trait Where {
    def where(sub: FilteringStart => Filtering): Ready
    def where(args: Part*): Ready
    def whereList(args: List[Part]): Ready
  }

  trait Ready {
    def sql: SqlWithParams
    def print: Unit
  }
}


import UpdateStages._


class Update(parts: PartCollector) extends Table
                                      with Change
                                      with Where
                                      with Ready {

  def next(tmpl: String) = new Update(parts.add(tmpl))

  def next(tmpl: String, args: Seq[Any]) = new Update(parts.add(tmpl, args))

  def next(part: Part) = new Update(parts.add(part))

  def next(parts: PartCollector) = new Update(parts)

  // table

  def table(table: TableName): Change = next(s"UPDATE ${table.render}")

  // change

  def set(args: (String, Any)*): Where = set(args.toList)

  def set(args: List[(String, Any)]): Where = {

    val changes = args.map {
      case (key, Inc(amount)) => Arg(s"$key = $key + $amount", None)
      case (key, Dec(amount)) => Arg(s"$key = $key - $amount", None)
      case (key, Raw(str)) => Arg(s"$key = $str", None)
      case (key, value) => Arg(s"$key = ?", Some(value))
    }

    next(
      "SET " + changes.map(_.tmpl).mkString(", "),
      changes.map(_.arg).flatten
    )
  }

  // condition

  def where(sub: FilteringStart => Filtering): Ready = {
    next(
      sub(
        Filtering.continue(
          parts.add("WHERE")
        )
      ).parts
    )
  }

  def where(conds: Part*): Ready = whereList(conds.toList)

  def whereList(conds: List[Part]): Ready = {
    next(
      "WHERE " + conds.map(_.tmpl).mkString(" AND "),
      conds.map(_.args).flatten
    )
  }

  // ready

  def sql: SqlWithParams = parts.sql

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}










