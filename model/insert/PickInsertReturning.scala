package kuzminki.model.insert

import kuzminki.model._


trait PickInsertReturning[M, S] extends PickReturning[M, RunInsertReturning[S, _]] {

  protected val model: M
  protected val coll: InsertCollector[S]

  def next[R](transformer: TypedTransformer[R]) = {
    new RunInsertReturning(coll, transformer)
  }
}