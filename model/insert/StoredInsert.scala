package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredInsert[S](protected val template: String,
                      protected val shape: InsertShape[S],
                                    db: Conn) extends ListInsert[S] {

  def run(data: S) = {
    db.exec(statement(data))
  }

  def runNum(data: S) = {
    db.execNum(statement(data))
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







