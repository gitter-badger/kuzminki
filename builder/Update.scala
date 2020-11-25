package kuzminki

import io.rdbc.sapi._
import operators._


object UpdateStages {

  trait Table {
    def table(table: String): Change
  }

  trait Change {
    def set(args: (String, Any)*): Condition
    def set(args: List[(String, Any)]): Condition
  }

  trait Condition {
    def where(args: (String, Cond)*): Ready
    def where(args: List[(String, Cond)]): Ready
  }

  trait Ready {
    def sql: SqlWithParams
    def print: Unit
  }
}


import UpdateStages._


class Update(data: QueryData) extends Table
                                 with Change
                                 with Condition
                                 with Ready {

  def next(tmpl: String) = new Update(data.add(tmpl))

  def next(tmpl: String, args: Seq[Any]) = new Update(data.add(tmpl, args))

  def next(part: Part) = new Update(data.add(part))

  // table

  def table(table: String): Change = next(s"UPDATE $table")

  // change

  def set(args: (String, Any)*): Condition = set(args.toList)

  def set(args: List[(String, Any)]): Condition = {

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

  def where(args: (String, Cond)*): Ready = where(args.toList)

  def where(args: List[(String, Cond)]): Ready = {

    val conds = args.map {
      case (key, Eq(value)) => Arg(s"$key = ?", Some(value))
      case (key, Not(value)) => Arg(s"$key != ?", Some(value))
      case (key, Gt(value)) => Arg(s"$key > ?", Some(value))
      case (key, Gte(value)) => Arg(s"$key >= ?", Some(value))
      case (key, Lt(value)) => Arg(s"$key < ?", Some(value))
      case (key, Lte(value)) => Arg(s"$key <= ?", Some(value))
      case (key, Like(value)) => Arg(s"$key LIKE ?", Some(value))
      case (key, op) => throw new KuzminkiException(s"invalid operator ($key -> $op)")
    }

    next(
      "WHERE " + conds.map(_.tmpl).mkString(" AND "),
      conds.map(_.arg).flatten
    )
  }

  // ready

  def sql: SqlWithParams = data.sql

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}

