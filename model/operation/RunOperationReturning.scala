package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done


class RunOperationReturning[R](coll: TypedCollector[R]) {
  
  def run() = {
    coll.db.select(coll.statement) { row =>
      coll.transformer.transform(row)
    }  
  }

  def first() = {
    coll.db.selectHeadOption(coll.statement) { row =>
      coll.transformer.transform(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    coll.db.select(coll.statement) { row =>
      custom(
        coll.transformer.transform(row)
      )
    }  
  }

  def firstAs[T](implicit custom: R => T) = {
    coll.db.selectHeadOption(coll.statement) { row =>
      custom(
        coll.transformer.transform(row)
      )
    }  
  }
}