package kuzminki.model.operation

import kuzminki.model._


case class OpCollector(db: Conn, sections: Array[Section]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def returning[R](transformer: TypedTransformer[R]) = {
    TypedCollector(db, transformer, sections :+ ReturningSec(transformer.toSeq))
  }

  def cache[S](shape: DataShape[S]) = {
    new StoredOperation(render, args, shape, db)
  }
}