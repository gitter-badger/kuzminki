package kuzminki.model.insert

import kuzminki.model._


class RunUpsertReturning[S, R](
      reuse: Reuse,
      coll: InsertCollector[S],
      transformer: TypedTransformer[R]) extends UpsertReturning[S, R] {

  def cache = coll.cacheUpsertReturning(transformer, reuse)

  def run(data: S) = cache.run(data)

  def runAs[T](data: S)(implicit custom: R => T) = cache.runAs(data)(custom)
}


