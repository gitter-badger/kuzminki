package kuzminki.model


class RunAggregation[R](coll: SelectCollector[R]) {

  coll.rowShape.cols.foreach {
    case f: AggNumeric =>
    case _ => throw KuzminkiException("all columns must be aggregate functions")
  }

  def run() = {
    coll.db.selectHead(coll.statement) { row =>
      coll.rowShape.conv.fromRow(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    coll.db.selectHead(coll.statement) { row =>
      custom(
        coll.rowShape.conv.fromRow(row)
      )
    }  
  }

  def render = coll.render

  def renderTo(printer: String => Unit) = {
    printer(render)
    this
  }

  //def asSub = new AggSubQuery(coll)
}