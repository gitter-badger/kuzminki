package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredUpsertReturning[S, R](
      template: String,
      inShape: DataShape[S],
      outShape: RowShape[R],
      reuse: Reuse,
      db: Conn
    ) extends Printing {

  protected def render = template

  private def statement(data: S) = {
    SqlWithParams(
      template,
      reuse.extend(
        inShape.transform(data)
      )
    )
  }

  def run(data: S) = {
    db.selectHead(statement(data)) { row =>
      outShape.fromRow(row)
    }  
  }

  def runAs[T](data: S)(implicit custom: R => T) = {
    db.selectHead(statement(data)) { row =>
      custom(
        outShape.fromRow(row)
      )
    }  
  }
}