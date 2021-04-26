package kuzminki.model

import akka.stream.scaladsl._
import akka.{NotUsed, Done}


class RunInsertWhereNotExists[M, P](
      model: M,
      reuse: Reuse,
      coll: InsertCollector[P]
    ) extends PickInsertWhereNotExistsReturning(model, reuse, coll) {

  def cache = coll.cacheInsertWhereNotExists(reuse)

  def run(params: P) = cache.run(params)

  def runNum(params: P) = cache.runNum(params)

  def fromSource(source: Source[P, NotUsed]) = cache.fromSource(source)

  def streamList(paramsList: List[P]) = cache.streamList(paramsList)

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}