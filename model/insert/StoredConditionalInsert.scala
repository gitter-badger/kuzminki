package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredConditionalInsert[S](template: String, shape: InsertShape[S], indexes: Vector[Int], db: Conn) {

  private def transform(data: S) = {
    val values = shape.transform(data)
    val duplicates = indexes.map(i => values(i))
    values ++ duplicates
  }

  def run(data: S) = {
    db.exec(SqlWithParams(template, transform(data)))
  }

  def runNum(data: S) = {
    db.execNum(SqlWithParams(template, transform(data)))
  }

  def stream(source: Source[S, NotUsed]) = {
    db.insertStream(
      template,
      source.map(transform)
    )
  }

  def streamList(data: List[S]) = stream(Source(data))
}