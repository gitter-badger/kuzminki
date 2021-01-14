package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredInsertDoNothingReturning[S, R](
      template: String,
      shape: InsertShape[S],
      transformer: TypedTransformer[R],
      db: Conn
    ) extends Printing {

  protected def render = template

  private def statement(data: S) = {
    SqlWithParams(
      template,
      shape.transform(data)
    )
  }

  def run(data: S) = {
    db.selectHeadOption(statement(data)) { row =>
      transformer.transform(row)
    }  
  }

  def runAs[T](data: S)(implicit custom: R => T) = {
    db.selectHeadOption(statement(data)) { row =>
      custom(
        transformer.transform(row)
      )
    }  
  }
}