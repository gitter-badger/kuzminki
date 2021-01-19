package kuzminki.model.insert

import kuzminki.model._


class RunInsertReturning[S, R](
      coll: InsertCollector[S],
      outShape: RowShape[R]) {

  def cache = coll.cacheInsertReturning(outShape)

  def run(data: S) = cache.run(data)

  def runAs[T](data: S)(implicit custom: R => T) = cache.runAs(data)(custom)

  def list(list: List[S]) = cache.list(list)

  def listAs[T](list: List[S])(implicit custom: R => T) = cache.listAs(list)(custom)
}


