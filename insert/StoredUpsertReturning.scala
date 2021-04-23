package kuzminki.model

import io.rdbc.sapi.SqlWithParams


class StoredUpsertReturning[P, R](
      protected val template: String,
      protected val paramConv: ParamConv[P],
      protected val reuse: Reuse,
                    rowConv: RowConv[R],
                    db: Conn
    ) extends InsertParamsReuse[P]
         with InsertStatement[P]
         with InsertPrinting {

  def run(params: P) = {
    db.selectHead(statement(params)) { row =>
      rowConv.fromRow(row)
    }  
  }

  def runAs[T](params: P)(implicit custom: R => T) = {
    db.selectHead(statement(params)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}