package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done


class RunOperationReturning[R](coll: OperationCollector, rowConv: RowConv[R]) {
  
  def run() = {
    coll.db.select(coll.statement) { row =>
      rowConv.fromRow(row)
    }  
  }

  def first() = {
    coll.db.selectHeadOption(coll.statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    coll.db.select(coll.statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def firstAs[T](implicit custom: R => T) = {
    coll.db.selectHeadOption(coll.statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}