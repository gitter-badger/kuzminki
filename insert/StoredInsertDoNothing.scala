package kuzminki.model

import io.rdbc.sapi.SqlWithParams


class StoredInsertDoNothing[P](
      protected val template: String,
      protected val paramConv: ParamConv[P],
                    db: Conn
    ) extends InsertStatement[P]
         with InsertParams[P]
         with InsertPrinting {

  def run(params: P) = {
    db.exec(statement(params))
  }

  def runNum(params: P) = {
    db.execNum(statement(params))
  }

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}