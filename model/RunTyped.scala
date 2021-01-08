package kuzminki.model

import scala.reflect.{classTag, ClassTag}


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

  def render = coll.render

  def renderTo(printer: String => Unit) = {
    printer(render)
    this
  }
  
  def asSub = new SubQuery(coll)
}