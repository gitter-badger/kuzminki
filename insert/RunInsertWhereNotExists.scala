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

  def stream(source: Source[P, NotUsed]) = cache.stream(source)

  def streamList(paramsList: List[P]) = cache.stream(Source(paramsList))

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}