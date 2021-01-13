package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class InsertOptions[M <: Model, S](
      protected val model: M,
      protected val coll: InsertCollector[S]) extends PickInsertReturning[M, S]
                                                 with WhereNotExists[M, S]
                                                 with OnConflict[M, S] {

  def cache = coll.add(InsertBlankValuesSec(coll.shape.size)).cache

  def run(data: S) = cache.run(data)

  def runNum(data: S) = cache.runNum(data)

  def list(list: List[S]) = cache.list(list)

  def listNum(list: List[S]) = cache.listNum(list)

  def stream(source: Source[S, NotUsed]) = cache.stream(source)

  def streamList(data: List[S]) = stream(Source(data))
}























