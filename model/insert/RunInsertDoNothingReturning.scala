package kuzminki.model.insert

import kuzminki.model._


class RunInsertDoNothingReturning[S, R](
      coll: InsertCollector[S],
      outShape: RowShape[R]) {

  def cache = coll.cacheInsertDoNothingReturning(outShape)

  def run(data: S) = cache.run(data)

  def runAs[T](data: S)(implicit custom: R => T) = cache.runAs(data)(custom)
}


