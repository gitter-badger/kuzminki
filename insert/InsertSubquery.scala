package kuzminki.model


trait InsertSubquery[M, P] {
  
  protected val model: M
  protected val coll: InsertCollector[P]

  def fromSubquery(sub: SelectSubquery[P]) = {
    new RunInsertSubquery(
      coll.add(
        InsertSubquerySec(sub)
      )
    )
  }
}