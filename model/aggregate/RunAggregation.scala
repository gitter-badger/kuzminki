package kuzminki.model.aggregate

import kuzminki.model._


class RunAggregation[R](coll: SelectCollector[R]) {

  coll.shape.cols.foreach {
    case f: AggNumeric =>
    case _ => throw KuzminkiModelException("all columns must be aggregate functions")
  }

  def run() = {
    coll.db.selectHead(coll.statement) { row =>
      coll.shape.fromRow(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    coll.db.selectHead(coll.statement) { row =>
      custom(
        coll.shape.fromRow(row)
      )
    }  
  }

  def render = coll.render

  def renderTo(printer: String => Unit) = {
    printer(render)
    this
  }

  def asSub = new AggSubQuery(coll)
}