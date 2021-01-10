package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class InsertStreamValues[M, T](model: M, coll: InsertCollector[T]) {

  private def cache = coll.add(InsertBlankValuesSec(coll.form.size)).cache

  def run(data: T) = cache.run(data)

  def runNum(data: T) = cache.runNum(data)

  def stream(source: Source[T, NotUsed]) = cache.stream(source)

  def streamList(data: List[T]) = stream(Source(data))
}









