package kuzminki

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import io.rdbc.sapi._
import kuzminki.implicits._


object Builder {
  
  def select(cols: ColRef*) = Select(Collector.init).columns(cols: _*)

  def select(cols: List[ColRef]) = Select(Collector.init).columnsList(cols)

  def delete: DeleteStages.DeleteFrom = Delete(Collector.init)

  def insert: InsertStages.InsertInto = Insert(Collector.init)

  def update(table: TableName) = Update(Collector.init).table(table)
}













