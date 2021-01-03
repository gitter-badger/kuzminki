package kuzminki.model.aggregate

import kuzminki.model._


class RunAggregation[R](coll: TypedCollector[R]) extends Printing {

  coll.transformer.toSeq.foreach {
    case f: AggFunction =>
    case _ => throw KuzminkiModelException("all columns must be aggregate functions")
  }

  def run() = {
    coll.db.selectHead(coll.statement) { row =>
      coll.transformer.transform(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    coll.db.selectHead(coll.statement) { row =>
      custom(
        coll.transformer.transform(row)
      )
    }  
  }

  def render = coll.render
  //def asSub = coll.sub
}