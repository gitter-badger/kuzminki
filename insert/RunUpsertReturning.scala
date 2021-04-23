package kuzminki.model


class RunUpsertReturning[P, R](
      reuse: Reuse,
      coll: InsertCollector[P],
      rowShape: RowShape[R]) {

  def cache = coll.cacheUpsertReturning(rowShape, reuse)

  def run(params: P) = cache.run(params)

  def runAs[T](params: P)(implicit custom: R => T) = cache.runAs(params)(custom)

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}


