package kuzminki.model

import akka.stream.scaladsl._
import akka.{NotUsed, Done}


class RunInsert[M <: Model, P](
      protected val model: M,
      protected val coll: InsertCollector[P]
    ) extends PickInsertReturning[M, P]
         with WhereNotExists[M, P]
         with OnConflict[M, P]
         with InsertSubquery[M, P] {

  def cache = coll.add(InsertBlankValuesSec(coll.paramShape.size)).cacheInsert

  def run(params: P) = cache.run(params)

  def runNum(params: P) = cache.runNum(params)

  def list(paramsList: List[P]) = cache.list(paramsList)

  def listNum(paramsList: List[P]) = cache.listNum(paramsList)

  def fromSource[T](source: Source[P, T]) = cache.fromSource(source)

  def streamList(paramsList: List[P]) = cache.streamList(paramsList)

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}


















