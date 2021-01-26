package kuzminki.model


class RunOperation[M](
      model: M,
      coll: OperationCollector
    ) extends PickOperationReturning(model, coll) {
  
  def run() = coll.db.exec(coll.statement)

  def runNum() = coll.db.execNum(coll.statement)

  def render = coll.render
}