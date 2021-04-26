package kuzminki.model

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams


class StoredOperation[S](
      template: String,
      args: Vector[Any],
      conv: ParamConv[S],
      db: Conn) {

  protected def render = template

  private def transform(data: S) = {
    args ++ conv.fromShape(data)
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

  def fromSource(source: Source[S, NotUsed]) = {
    db.insertFromSource(
      template,
      source.map(transform)
    )
  }

  def streamList(data: List[S]) = fromSource(Source(data))

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}