package kuzminki.model.operation

import kuzminki.model._


case class OperationCollector(db: Conn, sections: Array[Section]) extends CollectOperation {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def returning[R](outShape: RowShape[R]) = {
    SelectCollector(db, prefix, outShape, sections :+ ReturningSec(outShape.cols))
  }

  def cache[S](inShape: DataShape[S]) = {
    new StoredOperation(render, args, inShape, db)
  }
}