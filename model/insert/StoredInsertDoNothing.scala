package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredInsertDoNothing[S](
      template: String,
      inShape: ParamShape[S],
      db: Conn
    ) extends Printing {

  protected def render = template

  private def statement(params: S) = {
    SqlWithParams(
      template,
      inShape.fromShape(params)
    )
  }

  def run(params: S) = {
    db.exec(statement(params))
  }

  def runNum(data: S) = {
    db.execNum(statement(params))
  }
}