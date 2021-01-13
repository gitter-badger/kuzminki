package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredUpsertReturning[S, R](template: String,
                                  shape: InsertShape[S],
                                  transformer: TypedTransformer[R],
                                  reuse: Reuse,
                                  db: Conn) {

  private def statement(data: S) = {
    SqlWithParams(
      template,
      reuse.extend(
        shape.transform(data)
      )
    )
  }

  def run(data: S) = {
    db.selectHead(statement(data)) { row =>
      transformer.transform(row)
    }  
  }

  def runAs[T](data: S)(implicit custom: R => T) = {
    db.selectHead(statement(data)) { row =>
      custom(
        transformer.transform(row)
      )
    }  
  }
}