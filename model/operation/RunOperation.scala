package kuzminki.model.operation

import kuzminki.model._


class RunOperation[M](
      model: M,
      coll: Collector
    ) extends PickOperationReturning(model, coll) {
  
  def run() = coll.db.exec(coll.statement)

  def runNum() = coll.db.execNum(coll.statement)

  def render = coll.render
}