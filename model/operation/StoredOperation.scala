package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._
import kuzminki.model.insert.InsertShape


class StoredOperation[S](
      template: String,
      args: Vector[Any],
      shape: InsertShape[S],
      db: Conn) {

  protected def render = template

  private def transform(data: S) = {
    args ++ shape.transform(data)
  }

  private def statement(data: S) = {
    SqlWithParams(
      template,
      transform(data)
    )
  }

  def run(data: S) = {
    db.exec(statement(data))
  }

  def runNum(data: S) = {
    db.execNum(statement(data))
  }

  def stream(source: Source[S, NotUsed]) = {
    db.insertStream(
      template,
      source.map(transform)
    )
  }

  def streamList(data: List[S]) = stream(Source(data))
}