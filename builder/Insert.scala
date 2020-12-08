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

  def next(section: section): Insert = new Insert(parts.add(section))

  def into(table: TableName): ColsOrKeyValue = next(InsertIntoSec(table))

  def columns(cols: Col*): Values = next(InsertColumnsSec(cols))

  // values

  def data(args: (Col, Any)*): OnConflict = values(args.toMap)

  def data(args: Map[Col, Any]) = columns(args.keys).values(args.values)
    

  def values(query: SelectStages.Ready): OnConflict = next(InsertNestedSec(query))

  def values(args: Any*): OnConflict = next(InsertValuesSec(args))

  def valuesList(args: List[Any]): OnConflict = next(InsertValuesSec(args))

  // on conflict

  def onConflict: OnConflictDo = next(InsertOnConflictSec)
  
  def onConflict(col: Col): OnConflictDo = next(InsertOnConflictColumnSec(col))

  def onConflictOnConstraint(const: Col): OnConflictDo = next(InsertOnConflictOnConstraintSec(const))

  // on conflict do

  def doNothing: Ready = next(InsertOnConflictSec) = next(InsertDoNothingSec)

  def doUpdate(changes: Change*): Where = next(InsertDoUpdate(changes))

  def doUpdateList(changes: List[Change]): Where = next(InsertDoUpdate(changes))

  def sql: SqlWithParams = parts.sql

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}



