package kuzminki.model


class RunInsertData(coll: InsertDataCollector) {

  def run() = {
    coll.db.exec(coll.statement)
  }

  def runNum() = {
    coll.db.execNum(coll.statement)
  }
}