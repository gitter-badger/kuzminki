package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done


class RunTyped[R](coll: TypedCollector[R]) {
  
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

  def read[T](implicit reader: TypeReader[T]) = {
    coll.db.select(coll.statement) { row =>
      reader.read(row)
    }
  }

  def readFirst[T](implicit reader: TypeReader[T]) = {
    coll.db.selectHeadOption(coll.statement) { row =>
      reader.read(row)
    }
  }

  def stream(sink: Sink[R, Future[Done]]) = {
    coll.db.stream(coll.statement, sink) { row =>
      coll.transformer.transform(row)
    }
  }

  def streamAs[T](sink: Sink[T, Future[Done]])(implicit custom: R => T) = {
    coll.db.stream(coll.statement, sink) { row =>
      custom(
        coll.transformer.transform(row)
      )
    }
  }

  def streamRead[T](sink: Sink[T, Future[Done]])(implicit reader: TypeReader[T]) = {
    coll.db.stream(coll.statement, sink) { row =>
      reader.read(row)
    }
  }

  def render = coll.render

  def renderTo(printer: String => Unit) = {
    printer(render)
    this
  }
  
  def asSub = new SubQuery(coll)
}





















