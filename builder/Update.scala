package kuzminki

import io.rdbc.sapi._
import operators._


class Update(data: QueryData) {

  def table(table: String) = {
    new UpdateChanges(
      data.addTmpl(s"UPDATE $table")
    )
  }
}


class UpdateChanges(data: QueryData) {

  def set(args: (String, Any)*): UpdateWhere = set(args.toList)

  def set(args: List[(String, Any)]) = {

    val changes = args.map {
      case (key, Inc(amount)) => Arg(s"$key = $key + $amount", None)
      case (key, Dec(amount)) => Arg(s"$key = $key - $amount", None)
      case (key, Raw(str)) => Arg(s"$key = $str", None)
      case (key, value) => Arg(s"$key = ?", Some(value))
    }

    new UpdateWhere(
      data.addData(
        "SET " + changes.map(_.tmpl).mkString(", "),
        changes.map(_.arg).flatten
      )
    )
  }
}


class UpdateWhere(data: QueryData) {

  def where(args: (String, Cond)*): UpdateExec = where(args.toList)

  def where(args: List[(String, Cond)]) = {

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

    new UpdateExec(
      data.addData(
        "WHERE " + conds.map(_.tmpl).mkString(" AND "),
        conds.map(_.arg).flatten
      )
    )
  }
}


class UpdateExec(data: QueryData) {

  def sql: SqlWithParams = data.sql

  def toPart: Part = data.toPart

  def asNested: Part = data.asNested

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}

