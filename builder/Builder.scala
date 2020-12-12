package kuzminki

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import io.rdbc.sapi._
import kuzminki.implicits._


object Builder {
  
  def select(cols: ColRef*) = new Select(Collector.init).columns(cols: _*)

  def select(cols: List[ColRef]) = new Select(Collector.init).columnsList(cols)

  def insert = new Insert(Collector.init)

  def update(table: TableName) = new Update(Collector.init).table(table)
}













