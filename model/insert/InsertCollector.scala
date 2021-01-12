package kuzminki.model.insert

import kuzminki.model._


case class InsertCollector[S](db: Conn,
                              shape: InsertShape[S],
                              sections: Array[Section]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cache = new InsertCache(render, shape, db)

  def cacheUpsert = new StoredUpsert(render, shape, db)

  def cacheConditional(indexes: Vector[Int]) = new StoredConditionalInsert(render, shape, indexes, db)

  def cacheReturning[R](transformer: Transformer[T]) = new ReturningCache(render, shape, transformer, db)
}