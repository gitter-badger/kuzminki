package kuzminki.model


class RunInsertReturning[P, R](
      coll: InsertCollector[P],
      rowShape: RowShape[R]) {

  def cache = coll.cacheInsertReturning(rowShape)

  def run(params: P) = cache.run(params)

  def runAs[T](params: P)(implicit custom: R => T) = cache.runAs(params)(custom)

  def runList(paramsList: List[P]) = cache.runList(paramsList)

  def runListAs[T](paramsList: List[P])(implicit custom: R => T) = cache.runListAs(paramsList)(custom)

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}


