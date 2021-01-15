package kuzminki.model.operation

import kuzminki.model._


class StoredOperation[S](template: String, args: Seq[Any], shape: InsertShape[S]) {

  protected def render = template

  private def statement(data: S) = {
    SqlWithParams(
      template,
      reuse.extend(
        shape.transform(data)
      )
    )
  }

  def run(data: S) = {
    db.exec(statement(data))
  }

  def runNum(data: S) = {
    db.execNum(statement(data))
  }

  def stream(source: Source[S, NotUsed]) = {
    db.insertStream(
      template,
      source.map(transform)
    )
  }

  def streamList(data: List[S]) = stream(Source(data))
}