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

  def runList(paramsList: List[P]) = {
    db.exec(listStatement(paramsList))
  }

  def runListNum(paramsList: List[P]) = {
    db.execNum(listStatement(paramsList))
  }

  def fromSource[T](source: Source[P, T]) = {
    db.insertFromSource(
      template,
      source.map(tansformParams)
    )
  }

  def streamList(paramsList: List[P]) = fromSource(Source(paramsList))

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}







