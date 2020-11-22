package kuzminki

import io.rdbc.sapi._
import operators._


class Insert(data: QueryData) {

  def into(table: String) = {
    new InsertKeyValue(
      data.addTmpl(s"INSERT INTO $table")
    )
  }
}


class InsertKeyValue(data: QueryData) {

  def columns(args: String*) = {
    new InsertValues(
      data.addTmpl(
        s"(%s)".format(
          args.mkString(", ")
        )
      )
    )
  }

  def values(args: (String, Any)*): InsertOnConflict = values(args.toMap)

  def values(args: Map[String, Any]) = {
    
    val tmpl = "(%s) VALUES (%s)".format(
      args.keys.mkString(", "),
      Vector.fill(args.size)("?").mkString(", ")
    )

    new InsertOnConflict(
      data.addData(tmpl, args.values.toVector)
    )
  }
}


class InsertValues(data: QueryData) {

  def values(query: NestedSelect) = {
    new InsertOnConflict(
      data.addPart(query.asNested)
    )
  }

  def values(args: Any*): InsertOnConflict = values(args.toList)

  def values(args: List[Any]) = {
    new InsertOnConflict(
      data.addData(
        "VALUES (%s)".format(Vector.fill(args.size)("?").mkString(", ")),
        args.toVector
      )
    )
  }
}


class InsertOnConflict(val data: QueryData) extends InsertExec(data) {

  def onConflict: InsertOnConflictDo = add("ON CONFLICT")
  
  def onConflict(col: String): InsertOnConflictDo = add(s"ON CONFLICT ($col)")

  def onConflictOnConstraint(const: String): InsertOnConflictDo =
    add(s"ON CONFLICT ON CONSTRAINT ($const)")

  private def add(tmpl: String) = new InsertOnConflictDo(data.addTmpl(tmpl))
}


class InsertOnConflictDo(val data: QueryData) {

  def doNothing: InsertExec = {
    new InsertExec(
      data.addTmpl("DO NOTHING")
    )
  }

  def doUpdate(args: (String, Any)*): InsertExec = doUpdate(args.toList)

  def doUpdate(args: List[(String, Any)]) = {
    
    val changes = args.map {
      case (key, Inc(amount)) => Arg(s"$key = $key + $amount", None)
      case (key, Dec(amount)) => Arg(s"$key = $key - $amount", None)
      case (key, Raw(str)) => Arg(s"$key = $str", None)
      case (key, value) => Arg(s"$key = ?", Some(value))
    }

    new InsertExec(
      data.addData(
        "DO UPDATE SET " + changes.map(_.tmpl).mkString(", "),
        changes.map(_.arg).flatten
      )
    )
  }
}


class InsertExec(data: QueryData) {

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



