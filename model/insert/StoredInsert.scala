package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredInsert[S](
      protected val template: String,
      protected val inShape: ParamShape[S],
                    db: Conn
    ) extends ListInsert[S]
         with Printing {

  protected def render = template
  protected def transform(params: S) = inShape.fromShape(params)
  protected def statement(params: S) = SqlWithParams(template, transform(params))

  def run(params: S) = {
    db.exec(statement(params))
  }

  def runNum(params: S) = {
    db.execNum(statement(params))
  }

  def list(list: List[S]) = {
    db.exec(listStatement(list))
  }

  def listNum(list: List[S]) = {
    db.execNum(listStatement(list))
  }

  def stream(source: Source[S, NotUsed]) = {
    db.insertStream(
      template,
      source.map(transform)
    )
  }

  def streamList(data: List[S]) = stream(Source(data))
}







