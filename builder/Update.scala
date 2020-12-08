package kuzminki

import io.rdbc.sapi._
import containers._


object UpdateStages {

  trait Table {
    def table(table: TableName): Change
  }

  trait Change {
    def set(args: (String, Any)*): Where
    def setList(args: List[(String, Any)]): Where
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


class Update(parts: Collector) extends Table
                                      with Change
                                      with Where
                                      with Ready {

  def next(tmpl: String): Update = next(Part.create(tmpl))

  def next(part: Part): Update = next(parts.add(part))

  def next(addedParts: Collector): Update = new Update(addedParts)

  // table

  def table(table: TableName): Change = next(s"UPDATE ${table.render}")

  // change

  def set(changes: (Col, Any)*): Where = { 
    next(
      Clause("SET ", ", ", changes.map(Modification.render))
    )
  }

  def setList(changes: List[(Col, Any)]): Where = set(changes: _*)

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

  def where(conds: Part*): Ready = {
    next(
      Clause("WHERE", ", " + conds)
    )
  }

  def whereList(conds: List[Part]): Ready = where(conds: _*)

  // ready

  def sql: SqlWithParams = parts.sql

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}










