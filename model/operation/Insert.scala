package kuzminki.model.operation

import kuzminki.model._


class Insert[M <: Model](model: M, conn: Connection) extends TypedInsert(model, conn) {

  def data(pick: M => Seq[SetValue]) = {
    new OnConflict(
      Collector.forInsertData(
        model,
        pick(model),
        conn
      )
    )
  }

  def uncheckedCols(pick: M => Seq[ModelCol]) = {
    new UncheckedValues(model, conn, pick(model))
  }
}

abstract class InsertCollector[M <: Model](model: M, conn: Connection) {

  protected def single(cols: Seq[ModelCol], values: Seq[Any]) = {
    new OnConflict(
      Collector.forInsert(
        model,
        cols,
        values,
        conn
      )
    )
  }

  protected def multiple(cols: Seq[ModelCol], valuesList: Seq[Seq[Any]]) = {
    new OnConflict(
      Collector.forMultipleInsert(
        model,
        cols,
        valuesList,
        conn
      )
    )
  }
}

class UncheckedValues[M <: Model](model: M, conn: Connection, cols: Seq[ModelCol]) extends InsertCollector(model, conn) {

  private def verify(values: Seq[Any]): Unit = {

    if (values.isEmpty) {
      throw KuzminkiModelException("no columns selected")
    }

    if (cols.size != values.size) {
      throw KuzminkiModelException("values size does not match columns size")
    }
  }

  def uncheckedValues(values: Seq[Any]) {
    verify(values)
    single(cols, values)
  }

  def uncheckedValuesAs[T](values: T)(implicit transform: T => Seq[Any]) {
    uncheckedValues(transform(values))
  }

  def uncheckedValuesList(valuesList: Seq[Seq[Any]]) {
    valuesList.foreach(verify)
    multiple(cols, valuesList)
  }

  def uncheckedValuesListAs[T](valuesList: Seq[T])(implicit transform: T => Seq[Any]) {
    uncheckedValuesList(valuesList.map(transform))
  }
}

class TypedValues[M <: Model, A](model: M, conn: Connection, cols: InsertType[A]) extends InsertCollector(model, conn) {

  def values(data: A) = {
    single(
      cols.toSeq,
      cols.argsToSeq(data)
    )
  }

  def valuesList(dataList: Seq[A]) = {
    multiple(
      cols.toSeq,
      dataList.map(cols.argsToSeq(_))
    )
  }

  def valuesAs[T](data: T)(implicit transform: T => A) = {
    single(
      cols.toSeq,
      cols.argsToSeq(transform(data))
    )
  }

  def valuesListAs[T](dataList: Seq[T])(implicit transform: T => A) = {
    multiple(
      cols.toSeq,
      dataList.map { data =>
        cols.argsToSeq(transform(data))
      }
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

case class OnConflictDo[M <: Model](coll: OperationCollector[M]) {

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




