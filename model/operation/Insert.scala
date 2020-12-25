package kuzminki.model.operation

import kuzminki.model._


trait TypedInsert[M <: Model] {

  val model: M
  val conn: Connection

  def col(pick: M => TypeCol[_]) = {
    TypedValues(model, conn, Insert1Type(pick(model)))
  }

  def cols1[T1, T2](pick: M => Tuple2[TypeCol[T1], TypeCol[T2]]) = {
    TypedValues(model, conn, Insert2Types(pick(model)))
  }
}

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




