package kuzminki

import io.rdbc.sapi._
import containers._


object InsertStages {

  trait Into {
    def into(table: TableName): ColsOrKeyValue
  }

  trait ColsOrKeyValue {
    def columns(args: Col*): Values
    def data(args: (String, Any)*): OnConflict
    def data(args: Map[String, Any]): OnConflict
  }

  trait Values {
    def values(query: SelectStages.Ready): OnConflict
    def values(args: Any*): OnConflict
    def values(args: List[Any]): OnConflict
  }

  trait OnConflict extends Ready {
    def onConflict: OnConflictDo
    def onConflict(col: String): OnConflictDo
    def onConflictOnConstraint(const: String): OnConflictDo
  }

  trait OnConflictDo {
    def doNothing: Ready
    def doUpdate(args: (String, Any)*): Ready
    def doUpdate(args: List[(String, Any)]): Ready
  }

  trait Ready {
    def sql: SqlWithParams
    def print: Unit
  }
}


import InsertStages._


class Insert(parts: PartCollector) extends Into
                                      with ColsOrKeyValue
                                      with Values
                                      with OnConflict
                                      with OnConflictDo
                                      with Ready {

  def next(tmpl: String): Insert = new Insert(parts.add(tmpl))

  def next(tmpl: String, args: Seq[Any]): Insert = new Insert(parts.add(tmpl, args))

  def next(part: Part): Insert = new Insert(parts.add(part))

  // into

  def into(table: TableName): ColsOrKeyValue = next(s"INSERT INTO ${table.render}")

  // columns

  def columns(cols: Col*): Values = {
    next(
      s"(%s)".format(
        cols.map(_.render).mkString(", ")
      )
    )
  }

  // values

  def data(args: (String, Any)*): OnConflict = values(args.toMap)

  def data(args: Map[String, Any]) = {
    
    def tmpl = "(%s) VALUES (%s)".format(
      args.keys.mkString(", "),
      Vector.fill(args.size)("?").mkString(", ")
    )

    next(tmpl, args.values.toVector)
  }

  def values(query: SelectStages.Ready): OnConflict = next(query.asNested)

  def values(args: Any*): OnConflict = values(args.toList)

  def values(args: List[Any]): OnConflict = {
    next(
      "VALUES (%s)".format(Vector.fill(args.size)("?").mkString(", ")),
      args.toVector
    )
  }

  // on conflict

  def onConflict: OnConflictDo = next("ON CONFLICT")
  
  def onConflict(col: String): OnConflictDo = next(s"ON CONFLICT ($col)")

  def onConflictOnConstraint(const: String): OnConflictDo =
    next(s"ON CONFLICT ON CONSTRAINT ($const)")

  // on conflict do

  def doNothing: Ready = next("DO NOTHING")

  def doUpdate(args: (String, Any)*): Ready = doUpdate(args.toList)

  def doUpdate(args: List[(String, Any)]): Ready = {
    
    def changes = args.map {
      case (key, Inc(amount)) => Arg(s"$key = $key + $amount", None)
      case (key, Dec(amount)) => Arg(s"$key = $key - $amount", None)
      case (key, Raw(str)) => Arg(s"$key = $str", None)
      case (key, value) => Arg(s"$key = ?", Some(value))
    }

    next(
      "DO UPDATE SET " + changes.map(_.tmpl).mkString(", "),
      changes.map(_.arg).flatten
    )
  }

  def sql: SqlWithParams = parts.sql

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}



