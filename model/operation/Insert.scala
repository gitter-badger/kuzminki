package kuzminki.model.operation

import kuzminki.model._


case class Insert[M <: Model](model: M, conn: Connection) extends TypedInsert[M] {

  def data(pick: M => Seq[SetValue]) = {
    new OnConflict(
      Collector.forInsertData(
        model,
        pick(model),
        conn
      )
    )
  }
}

case class TypedValues[M <: Model, T](model: M, conn: Connection, cols: InsertType[T]) {

  def values(data: T) = {
    new OnConflict(
      Collector.forTypedInsert(
        model,
        cols.toSeq,
        cols.argsToSeq(data),
        conn
      )
    )
  }
}

class OnConflict[M <: Model](coll: OperationCollector[M]) extends Returning(coll) {

  def onConflict = {
    new OnConflictDo(
      coll.add(InsertOnConflictSec)
    )
  }

  def onConflictOnColumn(pick: M => ModelCol) = {
    new OnConflictDo(
      coll.add(
        InsertOnConflictColumnSec(pick(coll.model))
      )
    )
  }
}

class OnConflictDo[M <: Model](coll: OperationCollector[M]) {

  def doNothing = {
    new Returning(
      coll.add(InsertDoNothingSec)
    )
  }

  def doUpdate(pick: M => Seq[Assign]) = {
    new Returning(
      coll.add(
        InsertDoUpdateSec(pick(coll.model))
      )
    )
  }

  def doUpdateOne(pick: M => Assign) = {
    new Returning(
      coll.add(
        InsertDoUpdateSec(
          Seq(pick(coll.model))
        )
      )
    )
  }
}




