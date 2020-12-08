package kuzminki

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import io.rdbc.sapi._
import kuzminki.containers._
import kuzminki.implicits._


object Builder {
  
  def select(cols: Column*) = new Select(Collector.start("SELECT")).columns(cols: _*)

  def select(cols: List[Column]) = new Select(Collector.start("SELECT")).columnsList(cols)

  def insert = new Insert(Collector.init)

  def update(table: TableName) = new Update(Collector.init).table(table)
}













