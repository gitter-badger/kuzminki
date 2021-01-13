package kuzminki.model.insert

import kuzminki.model._


case class InsertCollector[S](db: Conn,
                              shape: InsertShape[S],
                              sections: Array[Section]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cache = new StoredInsert(render, shape, db)

  def cacheUpsert(reuse: Reuse) = new StoredUpsert(render, shape, reuse, db)

  def cacheConditional(reuse: Reuse) = new StoredConditionalInsert(render, shape, reuse, db)

  def cacheReturning[R](transformer: TypedTransformer[R]) = new StoredInsertReturning(render, shape, transformer, db)
}