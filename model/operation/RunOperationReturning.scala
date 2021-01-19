package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done


class RunOperationReturning[R](coll: SelectCollector[R]) {
  
  def run() = {
    coll.db.select(coll.statement) { row =>
      coll.outShape.fromRow(row)
    }  
  }

  def first() = {
    coll.db.selectHeadOption(coll.statement) { row =>
      coll.outShape.fromRow(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    coll.db.select(coll.statement) { row =>
      custom(
        coll.outShape.fromRow(row)
      )
    }  
  }

  def firstAs[T](implicit custom: R => T) = {
    coll.db.selectHeadOption(coll.statement) { row =>
      custom(
        coll.outShape.fromRow(row)
      )
    }  
  }
}