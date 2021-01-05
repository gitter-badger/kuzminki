package kuzminki.model.operation

import kuzminki.model._


abstract class RunOperation[M <: Model](coll: Collector) {
  
  def run() = coll.db.exec(coll.statement)

  def runNum() = coll.db.execNum(coll.statement)

  def render = coll.render

  def renderTo(printer: String => Unit) = {
    printer(render)
    this
  }
}