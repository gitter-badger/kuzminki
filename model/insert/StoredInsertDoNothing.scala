package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredInsertDoNothing[S](
      template: String,
      shape: InsertShape[S],
      db: Conn) extends Printing {

  protected def render = template

  private def statement(data: S) = {
    SqlWithParams(
      template,
      shape.transform(data)
    )
  }

  def run(data: S) = {
    db.exec(statement(data))
  }

  def runNum(data: S) = {
    db.execNum(statement(data))
  }
}