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

  def next(section: section): Update = new Update(parts.add(section))

  def next(addedParts: Collector): Update = new Update(addedParts)

  // table

  def table(table: TableName): Change = next(UpdateSec(table))

  // change

  def set(changes: Change*): Where = next(UpdateSetSec(changes))

  def setList(changes: List[(Col, Any)]): Where = next(UpdateSetSec(changes))

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

  def where(conds: Part*): Ready = next(WhereAllSec(conds))

  def whereList(conds: List[Part]): Ready = next(WhereAllSec(conds))

  // ready

  def sql: SqlWithParams = parts.sql

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}










