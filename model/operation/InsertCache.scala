package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class InsertStreamCache[T](template: String, form: InsertForm[T], db: Conn) {

  def run(data: T) = {
    db.exec(SqlWithParams(template, form.toVector(data)))
  }

  def runNum(data: T) = {
    db.execNum(SqlWithParams(template, form.toVector(data)))
  }

  def stream(source: Source[T, NotUsed]) = {
    db.insertStream(
      template,
      source.map(data => form.toVector(data))
    )
  }

  def streamList(data: List[T]) = stream(Source(data))
}