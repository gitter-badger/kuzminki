package kuzminki.model

import io.rdbc.sapi.SqlWithParams


class StoredInsertSubquery(statement: SqlWithParams, db: Conn) {

  def run() = {
    db.exec(statement)
  }

  def runNum() = {
    db.execNum(statement)
  }

  def sql(handler: String => Unit) = {
    handler(statement.sql)
    this
  }
}