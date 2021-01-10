package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class InsertStreamCache[T](template: String, args: Vector[Any], form: InsertForm[T], db: Conn) {

  def stream(source: Source[T, NotUsed]) = {
    db.insertStream(
      template,
      source.map(data => form.toVector(data))
    )
  }

  def streamList(data: List[T]) = stream(Source(data))
}