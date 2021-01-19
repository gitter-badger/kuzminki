package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredUpsert[S](
      template: String,
      inShape: DataShape[S],
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
    db.exec(statement(data))
  }

  def runNum(data: S) = {
    db.execNum(statement(data))
  }
}