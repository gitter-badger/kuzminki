package kuzminki.model


class RunInsertWhereNotExistsReturning[P, R](
      reuse: Reuse,
      coll: InsertCollector[P],
      outShape: RowShape[R]) {

  def cache = coll.cacheInsertWhereNotExistsReturning(outShape, reuse)

  def run(params: P) = cache.run(params)

  def runAs[T](params: P)(implicit custom: R => T) = cache.runAs(params)(custom)

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}
