package kuzminki.model.insert

import kuzminki.model._


class RunInsertWhereNotExistsReturning[S, R](
      reuse: Reuse,
      coll: InsertCollector[S],
      transformer: TypedTransformer[R]) {

  def cache = coll.cacheInsertWhereNotExistsReturning(transformer, reuse)

  def run(data: S) = cache.run(data)

  def runAs[T](data: S)(implicit custom: R => T) = cache.runAs(data)(custom)
}
