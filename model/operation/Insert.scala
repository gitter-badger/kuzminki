package kuzminki.model.operation

import kuzminki.model._


case class CollectSingle[M <: Model](model: M,
                                    conn: Connection,
                                    cols: Seq[ModelCol],
                                    values: Seq[Any])


class Insert[M <: Model](model: M, conn: Connection) extends TypedInsert(model, conn) {

  def data(pick: M => Seq[SetValue]) = {
    val changes = pick(model)
    new SingleRowInsert(
      OperationCollector(
        model,
        conn,
        Array(
          InsertIntoSec(ModelTable(model)),
          InsertColumnsSec(changes.map(_.col)),
          InsertValuesSec(changes.map(_.value))
        )
      )
    )
  }

  def uncheckedCols(pick: M => Seq[ModelCol]) = {
    new UncheckedValues(model, conn, pick(model))
  }
}

abstract class ValuesNext[M <: Model](model: M, conn: Connection) {

  protected def single(cols: Seq[ModelCol], values: Seq[Any]) = {
    new SingleRowInsert(
      OperationCollector(
        model,
        conn,
        Array(
          InsertIntoSec(ModelTable(model)),
          InsertColumnsSec(cols),
          InsertValuesSec(values)
        )
      )
    )
  }

  protected def multiple(cols: Seq[ModelCol], valuesList: List[Seq[Any]]) = {
    new Returning(
      OperationCollector(
        model,
        conn,
        Array(
          InsertIntoSec(ModelTable(model)),
          InsertColumnsSec(cols),
          InsertMultipleValuesSec(valuesList)
        )
      )
    )
  }
}

class TypedValues[M <: Model, A](model: M, conn: Connection, cols: InsertType[A]) extends ValuesNext(model, conn) {

  def values(data: A) = {
    single(
      cols.toSeq,
      cols.argsToSeq(data)
    )
  }

  def valuesAs[T](data: T)(implicit transform: T => A) = {
    single(
      cols.toSeq,
      cols.argsToSeq(transform(data))
    )
  }

  def valuesList(dataList: List[A]) = {
    multiple(
      cols.toSeq,
      dataList.map(cols.argsToSeq(_))
    )
  }

  def valuesListAs[T](dataList: List[T])(implicit transform: T => A) = {
    multiple(
      cols.toSeq,
      dataList.map { data =>
        cols.argsToSeq(transform(data))
      }
    )
  }

  def valuesFromSelect(nested: NestedSelect[A]) = {
    new Returning(
      OperationCollector(
        model,
        conn,
        Array(
          InsertIntoSec(ModelTable(model)),
          InsertColumnsSec(cols.toSeq),
          InsertNestedSec(nested.untyped)
        )
      )
    )
  }
}

class UncheckedValues[M <: Model](model: M, conn: Connection, cols: Seq[ModelCol]) extends ValuesNext(model, conn) {

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

  def uncheckedValuesList(valuesList: List[Seq[Any]]) {
    valuesList.foreach(verify)
    multiple(cols, valuesList)
  }

  def uncheckedValuesListAs[T](valuesList: List[T])(implicit transform: T => Seq[Any]) {
    uncheckedValuesList(valuesList.map(transform))
  }
}

class SingleRowInsert[M <: Model](coll: OperationCollector[M]) extends Returning(coll) {

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

  def whereNotExistsOne(pick: M => ModelFilter) = {
    whereNotExistsImplement(
      Seq(pick(coll.model))
    )
  }

  def whereNotExistsAll(pick: M => Seq[ModelFilter]) = {
    whereNotExistsImplement(pick(coll.model))
  }

  private def whereNotExistsImplement(conds: Seq[ModelFilter]) = {
    val sections = coll.sections.map {
      case InsertValuesSec(values) => InsertWhereNotExistsSec(values, ModelTable(coll.model))
      case sec: Section => sec 
    }

    new Returning(
      coll.copy(sections = sections).add(
        WhereAllSec(conds)
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






