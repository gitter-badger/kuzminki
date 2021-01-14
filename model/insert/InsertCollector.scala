package kuzminki.model.insert

import kuzminki.model._


case class InsertCollector[S](db: Conn,
                              shape: InsertShape[S],
                              sections: Array[Section]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cacheInsert = {
    new StoredInsert(render, shape, db)
  }

  def cacheInsertReturning[R](transformer: TypedTransformer[R]) = {
    new StoredInsertReturning(render, shape, transformer, db)
  }

  def cacheUpsert(reuse: Reuse) = {
    new StoredUpsert(render, shape, reuse, db)
  }

  def cacheUpsertReturning[R](transformer: TypedTransformer[R], reuse: Reuse) = {
    new StoredUpsertReturning(render, shape, transformer, reuse, db)
  }

  def cacheInsertWhereNotExists(reuse: Reuse) = {
    new StoredInsertWhereNotExists(render, shape, reuse, db)
  }

  def cacheInsertWhereNotExistsReturning[R](transformer: TypedTransformer[R], reuse: Reuse) = {
    new StoredInsertWhereNotExistsReturning(render, shape, transformer, reuse, db)
  }
}