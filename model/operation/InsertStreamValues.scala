package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class InsertStreamValues[M, T](model: M, coll: InsertCollector[T]) {

  def stream(source: Source[T, NotUsed]) = {
    coll.add(InsertBlankValuesSec(coll.form.size)).cache.stream(source)
  }

  def streamList(data: List[T]) = stream(Source(data))
}









