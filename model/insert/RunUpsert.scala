package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class RunUpsert[M, S](model: M, reuse: Reuse, coll: InsertCollector[S]) {

  def cache = coll.cacheUpsert(reuse)

  def run(data: S) = cache.run(data)

  def runNum(data: S) = cache.runNum(data)
}