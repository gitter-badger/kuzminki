package kuzminki.model

import io.rdbc.sapi.SqlWithParams


class StoredInsertDoNothingReturning[P, R](
      protected val template: String,
      protected val paramConv: ParamConv[P],
                    rowConv: RowConv[R],
                    db: Conn
    ) extends InsertStatement[P]
         with InsertParams[P]
         with InsertPrinting {

  def run(params: P) = {
    db.selectHeadOption(statement(params)) { row =>
      rowConv.fromRow(row)
    }  
  }

  def runAs[T](params: P)(implicit custom: R => T) = {
    db.selectHeadOption(statement(params)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }
}