package kuzminki.model

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams


class StoredInsertWhereNotExists[P](
      protected val template: String,
      protected val paramConv: ParamConv[P],
      protected val reuse: Reuse,
                    db: Conn
    ) extends InsertStatement[P]
         with InsertParamsReuse[P]
         with InsertPrinting {

  def run(params: P) = {
    db.exec(statement(params))
  }

  def runNum(params: P) = {
    db.execNum(statement(params))
  }

  def fromSource(source: Source[P, NotUsed]) = {
    db.fromSource(
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