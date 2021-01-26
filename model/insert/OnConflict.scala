package kuzminki.model


trait OnConflict[M, P] {

  protected val model: M
  protected val coll: InsertCollector[P]

  def onConflictDoNothing = {
    new RunInsertDoNothing(
      model,
      coll.extend(Array(
        InsertBlankValuesSec(coll.paramShape.size),
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