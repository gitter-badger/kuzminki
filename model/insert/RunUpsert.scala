package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class RunUpsert[M, S](model: M, coll: InsertCollector[S]) {

  def cache = coll.cacheUpsert(indexes)

  def run(data: S) = cache.run(data)

  def runNum(data: S) = cache.runNum(data)
}