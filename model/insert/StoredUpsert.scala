package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredUpsert[S](template: String, shape: InsertShape[S], db: Conn) {

  private def statement(data: S) = SqlWithParams(template, shape.transform(data))

  def run(data: S) = {
    db.exec(statement(data))
  }

  def runNum(data: S) = {
    db.execNum(statement(data))
  }
}