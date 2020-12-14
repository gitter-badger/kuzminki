package kuzminki

import io.rdbc.sapi._


object InsertStages {

  trait InsertInto {
    def into(table: TableName): ColsOrKeyValue
  }

  trait ColsOrKeyValue {
    def columns(cols: ColName*): Values
    def data(args: (ColName, Any)*): OnConflict
    def data(args: Map[String, Any]): OnConflict
  }

  trait Values {
    def values(nested: Collector): OnConflict
    def values(args: Any*): OnConflict
    def valuesList(args: List[Any]): OnConflict
  }

  trait OnConflict extends Ready {
    def onConflict: OnConflictDo
    def onConflict(col: ColName): OnConflictDo
    def onConflictOnConstraint(const: ColName): OnConflictDo
  }

  trait OnConflictDo {
    def doNothing: Ready
    def doUpdate(changes: Change*): Ready
    def doUpdateList(changes: List[Change]): Ready
  }

  trait Ready {
    def print: Unit
    def wrapped: Unit
    def pretty: Unit
  }
}


import InsertStages._


case class Insert(sections: Collector) extends InsertInto
                                          with ColsOrKeyValue
                                          with Values
                                          with OnConflict
                                          with OnConflictDo
                                          with Ready
                                          with Printing {

  def next(section: Section): Insert = Insert(sections.add(section))

  def into(table: TableName): ColsOrKeyValue = next(InsertIntoSec(table))

  def columns(cols: ColName*): Values = next(InsertColumnsSec(cols))

  // values

  def data(args: (ColName, Any)*): OnConflict = columns(args.map(_._1): _*).values(args.map(_._2): _*)

  def data(args: Map[String, Any]) = columns(args.keys.map(ColName(_)).toSeq: _*).values(args.values.toSeq: _*)
    
  def values(nested: Collector): OnConflict = next(InsertNestedSec(nested))

  def values(args: Any*): OnConflict = next(InsertValuesSec(args))

  def valuesList(args: List[Any]): OnConflict = next(InsertValuesSec(args))

  // on conflict

  def onConflict: OnConflictDo = next(InsertOnConflictSec)
  
  def onConflict(col: ColName): OnConflictDo = next(InsertOnConflictColumnSec(col))

  def onConflictOnConstraint(const: ColName): OnConflictDo = next(InsertOnConflictOnConstraintSec(const))

  // on conflict do

  def doNothing: Ready = next(InsertDoNothingSec)

  def doUpdate(changes: Change*): Ready = next(InsertDoUpdate(changes))

  def doUpdateList(changes: List[Change]): Ready = next(InsertDoUpdate(changes))
}



