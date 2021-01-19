package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredInsertDoNothingReturning[S, R](
      template: String,
      inShape: DataShape[S],
      outShape: RowShape[R],
      db: Conn
    ) extends Printing {

  protected def render = template

  private def statement(data: S) = {
    SqlWithParams(
      template,
      inShape.transform(data)
    )
  }

  def run(data: S) = {
    db.selectHeadOption(statement(data)) { row =>
      outShape.fromRow(row)
    }  
  }

  def runAs[T](data: S)(implicit custom: R => T) = {
    db.selectHeadOption(statement(data)) { row =>
      custom(
        outShape.fromRow(row)
      )
    }  
  }
}