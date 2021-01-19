package kuzminki.model.insert

import kuzminki.model._


trait OnConflict[M, S] {

  protected val model: M
  protected val coll: InsertCollector[S]

  def onConflictDoNothing = {
    new RunInsertDoNothing(
      model,
      coll.extend(Array(
        InsertBlankValuesSec(coll.inShape.size),
        InsertOnConflictSec,
        InsertDoNothingSec
      ))
    )
  }

  def onConflictOnColumn(pick: M => ModelCol) = {
    new DoUpdate(
      model,
      coll,
      pick(model)
    )
  }
}