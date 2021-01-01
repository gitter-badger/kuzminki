package kuzminki.model.operation

import kuzminki.model._


abstract class RunOperation[M <: Model](coll: Collector) extends Printing {
  
  def run() = coll.db.exec(coll.statement)

  def runNum() = coll.db.execNum(coll.statement)

  def render = coll.render
}