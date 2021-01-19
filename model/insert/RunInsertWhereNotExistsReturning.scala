package kuzminki.model.insert

import kuzminki.model._


class RunInsertWhereNotExistsReturning[S, R](
      reuse: Reuse,
      coll: InsertCollector[S],
      outShape: RowShape[R]) {

  def cache = coll.cacheInsertWhereNotExistsReturning(outShape, reuse)

  def run(data: S) = cache.run(data)

  def runAs[T](data: S)(implicit custom: R => T) = cache.runAs(data)(custom)
}
