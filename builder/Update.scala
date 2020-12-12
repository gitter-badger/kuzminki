package kuzminki

import io.rdbc.sapi._


object UpdateStages {

  trait Table {
    def table(table: TableName): SetValues
  }

  trait SetValues {
    def set(args: Change*): Where
    def setList(args: List[Change]): Where
  }

  trait Where {
    def where(sub: FilteringStart => Filtering): Ready
    def where(args: Filter*): Ready
    def whereList(args: List[Filter]): Ready
  }

  trait Ready {
    def print: Unit
    def wrapped: Unit
    def pretty: Unit
  }
}


import UpdateStages._


case class Update(sections: Collector) extends Table
                                  with SetValues
                                  with Where
                                  with Ready {

  def next(section: Section): Update = Update(sections.add(section))

  def table(table: TableName): SetValues = next(UpdateSec(table))

  def set(changes: Change*): Where = next(UpdateSetSec(changes))

  def setList(changes: List[Change]): Where = next(UpdateSetSec(changes))

  def where(sub: FilteringStart => Filtering): Ready = next(WhereChainSec(sub(Filtering.init).filters))

  def where(conds: Filter*): Ready = next(WhereAllSec(conds))

  def whereList(conds: List[Filter]): Ready = next(WhereAllSec(conds))

  def print: Unit = {
    sections.renderQuery match {
      case QueryResult(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }

  def wrapped: Unit = {
    sections.wrappedQuery match {
      case QueryResult(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }

  def pretty: Unit = {
    sections.prettyQuery match {
      case QueryResult(tmpl, args) =>
        println(tmpl + "\n" + args) 
    }
  }
}










