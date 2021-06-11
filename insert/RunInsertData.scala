package kuzminki.model


class RunInsertData(coll: InsertDataCollector) {

  def run() = {
    coll.db.exec(coll.statement)
  }

  def runNum() = {
    coll.db.execNum(coll.statement)
  }

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}