package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done


class RunSelect[R](coll: SelectCollector[R]) extends SelectSubquery[R] {
  
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

  def stream(sink: Sink[R, Future[Done]]) = {
    coll.db.stream(coll.statement, sink) { row =>
      coll.outShape.fromRow(row)
    }
  }

  def streamAs[T](sink: Sink[T, Future[Done]])(implicit custom: R => T) = {
    coll.db.stream(coll.statement, sink) { row =>
      custom(
        coll.outShape.fromRow(row)
      )
    }
  }

  def render = coll.render
  def prefix(picker: Prefix) = coll.render
  def args = coll.args

  def renderTo(printer: String => Unit) = {
    printer(render)
    this
  }
  
  def cache = new StoredSelect(coll.db, coll.statement, coll.outShape)
}





















