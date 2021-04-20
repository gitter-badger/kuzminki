package kuzminki.model


class RunInsertDoNothingReturning[P, R](
      coll: InsertCollector[P],
      rowShape: RowShape[R]) {

  def cache = coll.cacheInsertDoNothingReturning(rowShape)

  def run(params: P) = cache.run(params)

  def runAs[T](params: P)(implicit custom: R => T) = cache.runAs(params)(custom)
}


