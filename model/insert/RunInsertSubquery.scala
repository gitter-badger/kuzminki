package kuzminki.model


class RunInsertSubquery[P](coll: InsertCollector[P]) {

  def cache = coll.cacheInsertSubquery

  def run() = cache.run()

  def runNum() = cache.runNum()
}