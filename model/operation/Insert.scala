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

class TypedValues[M <: Model, R](model: M, conn: Connection, cols: InsertType[R]) extends ValuesNext(model, conn) {

  def values(data: R) = {
    single(
      cols.toSeq,
      cols.argsToSeq(data)
    )
  }

  def valuesList(dataList: List[R]) = {
    multiple(
      cols.toSeq,
      dataList.map(cols.argsToSeq(_))
    )
  }

  def valuesFromSelect(sub: SubQuery[R]) = {
    new Returning(
      OperationCollector(
        model,
        conn,
        Array(
          InsertIntoSec(ModelTable(model)),
          InsertColumnsSec(cols.toSeq),
          InsertSubQuerySec(sub.untyped)
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

  def onConflictDoNothing = {
    new Returning(
      coll.extend(Array(
        InsertOnConflictSec,
        InsertDoNothingSec
      ))
    )
  }

  def onConflictOnColumn(pick: M => ModelCol) = {
    new OnConflictDo(
      pick(coll.model),
      coll
    )
  }

  def whereNotExistsOne(pick: M => Filter) = {
    whereNotExistsImplement(
      Seq(pick(coll.model))
    )
  }

  def whereNotExistsAll(pick: M => Seq[Filter]) = {
    whereNotExistsImplement(pick(coll.model))
  }

  private def whereNotExistsImplement(conds: Seq[Filter]) = {
    val sections = coll.sections.map {
      case InsertValuesSec(values) =>
        InsertWhereNotExistsSec(values, ModelTable(coll.model), WhereAllSec(conds))
      case sec: Section => sec 
    }

    new Returning(
      coll.copy(sections = sections)
    )
  }
}

case class OnConflictDo[M <: Model](conflictCol: ModelCol, coll: OperationCollector[M]) {

  def doNothing = {
    new Returning(
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoNothingSec
      ))
    )
  }

  private def validate(change: SetValue): Unit = {
    if (change.col.name == conflictCol.name) {
      throw KuzminkiModelException("cannot update the conflicting column")
    }
  }

  def doUpdate(pick: M => Seq[SetValue]) = {
    val changes = pick(coll.model)
    changes.foreach(validate)
    new Returning(
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(changes)
      ))
    )
  }

  def doUpdateOne(pick: M => SetValue) = {
    val change = pick(coll.model)
    validate(change)
    new Returning(
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(Seq(change))
      ))
    )
  }
}






