package kuzminki.model

import akka.stream.scaladsl._
import akka.{NotUsed, Done}


class RunUpsert[M, P](
      model: M,
      reuse: Reuse,
      coll: InsertCollector[P]
    ) extends PickUpsertReturning(model, reuse, coll) {

  def cache = coll.cacheUpsert(reuse)

  def run(params: P) = cache.run(params)

  def runNum(params: P) = cache.runNum(params)
}