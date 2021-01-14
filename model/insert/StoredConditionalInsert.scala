package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredConditionalInsert[S](val template: String,
                                     shape: InsertShape[S],
                                     reuse: Reuse,
                                     db: Conn) extends Printing {

  protected def render = template

  private def transform(data: S) = {
    reuse.extend(
      shape.transform(data)
    )
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