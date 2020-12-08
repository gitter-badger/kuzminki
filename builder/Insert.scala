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
    def valuesList(args: List[Any]): OnConflict
  }

  trait OnConflict extends Ready {
    def onConflict: OnConflictDo
    def onConflict(col: String): OnConflictDo
    def onConflictOnConstraint(const: String): OnConflictDo
  }

  trait OnConflictDo {
    def doNothing: Ready
    def doUpdate(args: (Col, Any)*): Ready
    def doUpdateList(args: List[(String, Any)]): Ready
  }

  trait Ready {
    def sql: SqlWithParams
    def print: Unit
  }
}


import InsertStages._


class Insert(parts: Collector) extends Into
                                      with ColsOrKeyValue
                                      with Values
                                      with OnConflict
                                      with OnConflictDo
                                      with Ready {

  def next(tmpl: String): Insert = next(parts.add(tmpl))

  def next(part: Part): Insert = next(parts.add(part))

  def next(addedParts: Collector): Insert = new Insert(addedParts)

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

  def values(args: Any*): OnConflict = {
    next(
      Part.create(
        "VALUES (%s)".format(Vector.fill(args.size)("?").mkString(", ")),
        args
      )
    )
  }

  def valuesList(args: List[Any]): OnConflict = values(args: _*)

  // on conflict

  def onConflict: OnConflictDo = next("ON CONFLICT")
  
  def onConflict(col: String): OnConflictDo = next(s"ON CONFLICT ($col)")

  def onConflictOnConstraint(const: String): OnConflictDo =
    next(s"ON CONFLICT ON CONSTRAINT ($const)")

  // on conflict do

  def doNothing: Ready = next("DO NOTHING")

  def doUpdate(changes: (Col, Any)*): Where = { 
    next(
      Clause("SET", ", ", changes.map(Modification.render))
    )
  }

  def doUpdateList(changes: List[(Col, Any)]): Where = doUpdate(changes: _*)

  def sql: SqlWithParams = parts.sql

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}



