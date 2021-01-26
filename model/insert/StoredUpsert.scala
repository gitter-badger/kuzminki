package kuzminki.model

import io.rdbc.sapi.SqlWithParams


class StoredUpsert[P](
      protected val template: String,
      protected val paramConv: ParamConv[P],
      protected val reuse: Reuse,
                    db: Conn
    ) extends InsertParamsReuse[P]
         with InsertStatement[P]
         with InsertPrinting {

  def run(params: P) = {
    db.exec(statement(params))
  }

  def runNum(params: P) = {
    db.execNum(statement(params))
  }
}