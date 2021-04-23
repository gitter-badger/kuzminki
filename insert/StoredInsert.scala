package kuzminki.model

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams


class StoredInsert[P](
      protected val template: String,
      protected val paramConv: ParamConv[P],
                    db: Conn
    ) extends InsertStatement[P]
         with InsertParams[P]
         with InsertList[P]
         with InsertPrinting {

  def run(params: P) = {
    db.exec(statement(params))
  }

  def runNum(params: P) = {
    db.execNum(statement(params))
  }

  def list(paramsList: List[P]) = {
    db.exec(listStatement(paramsList))
  }

  def listNum(paramsList: List[P]) = {
    db.execNum(listStatement(paramsList))
  }

  def stream(source: Source[P, NotUsed]) = {
    db.insertStream(
      template,
      source.map(tansformParams)
    )
  }

  def streamList(paramsList: List[P]) = stream(Source(paramsList))

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}







