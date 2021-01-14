package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class RunInsertWhereNotExists[M, S](
      model: M,
      reuse: Reuse,
      coll: InsertCollector[S]
    ) extends PickInsertWhereNotExistsReturning(model, reuse, coll) {

  def cache = coll.cacheInsertWhereNotExists(reuse)

  def run(data: S) = cache.run(data)

  def runNum(data: S) = cache.runNum(data)

  def stream(source: Source[S, NotUsed]) = cache.stream(source)

  def streamList(data: List[S]) = cache.stream(Source(data))
}