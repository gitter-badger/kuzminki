package kuzminki.model.insert

import kuzminki.model._


case class InsertCollector[S](
      db: Conn,
      inShape: DataShape[S],
      sections: Array[Section]
    ) extends CollectOperation {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cacheInsert = {
    new StoredInsert(render, inShape, db)
  }

  def cacheInsertReturning[R](transformer: RowShape[R]) = {
    new StoredInsertReturning(render, inShape, transformer, db)
  }

  def cacheInsertDoNothing = {
    new StoredInsertDoNothing(render, inShape, db)
  }

  def cacheInsertDoNothingReturning[R](transformer: RowShape[R]) = {
    new StoredInsertDoNothingReturning(render, inShape, transformer, db)
  }

  def cacheUpsert(reuse: Reuse) = {
    new StoredUpsert(render, inShape, reuse, db)
  }

  def cacheUpsertReturning[R](transformer: RowShape[R], reuse: Reuse) = {
    new StoredUpsertReturning(render, inShape, transformer, reuse, db)
  }

  def cacheInsertWhereNotExists(reuse: Reuse) = {
    new StoredInsertWhereNotExists(render, inShape, reuse, db)
  }

  def cacheInsertWhereNotExistsReturning[R](transformer: RowShape[R], reuse: Reuse) = {
    new StoredInsertWhereNotExistsReturning(render, inShape, transformer, reuse, db)
  }
}