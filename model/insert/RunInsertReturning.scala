package kuzminki.model.insert

import kuzminki.model._


class RunInsertReturning[S, R](coll: InsertCollector[S], transformer: Transformer[R]) {

  def cache = coll.cacheReturning(transformer)

  def run(data: S) = cache.run(data)

  def runAs[T](data: S)(implicit custom: R => T) = cache.runAs(data)

  def list(list: List[S]) = cache.list(list)

  def listAs[T](data: S)(implicit custom: R => T) = cache.listAs(list)
}


