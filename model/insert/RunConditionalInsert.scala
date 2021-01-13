package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class RunConditionalInsert[M, S](model: M, reuse: Reuse, coll: InsertCollector[S]) {

  def cache = coll.cacheConditional(reuse)

  def run(data: S) = cache.run(data)

  def runNum(data: S) = cache.runNum(data)

  def stream(source: Source[S, NotUsed]) = cache.stream(source)

  def streamList(data: List[S]) = cache.stream(Source(data))
}