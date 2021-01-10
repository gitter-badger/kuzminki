package kuzminki.model.operation

import kuzminki.model._


class Insert[M <: Model](model: M, db: Conn) extends TypedInsert(model, db) {

  def data(pick: M => Seq[SetValue]) = {
    val changes = pick(model)
    new SingleRowInsert(
      model,
      Collector(
        db,
        Array(
          InsertIntoSec(ModelTable(model)),
          InsertColumnsSec(changes.map(_.col)),
          InsertValuesSec(changes.map(_.value))
        )
      )
    )
  }

  def uncheckedCols(pick: M => Seq[ModelCol]) = {
    new UncheckedValues(model, db, pick(model))
  }
}


abstract class ValuesNext[M <: Model](model: M, db: Conn) {

  protected def single(cols: Seq[ModelCol], values: Seq[Any]) = {
    new SingleRowInsert(
      model,
      Collector(
        db,
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
      model,
      Collector(
        db,
        Array(
          InsertIntoSec(ModelTable(model)),
          InsertColumnsSec(cols),
          InsertMultipleValuesSec(valuesList)
        )
      )
    )
  }
}


class TypedValues[M <: Model, R](model: M, db: Conn, form: InsertForm[R]) extends ValuesNext(model, db) {

  def values(data: R) = {
    single(
      form.colSeq,
      form.toSeq(data)
    )
  }

  def valuesList(dataList: List[R]) = {
    multiple(
      form.colSeq,
      dataList.map(form.toSeq(_))
    )
  }

  def valuesFromSelect(sub: SubQuery[R]) = {
    new Returning(
      model,
      Collector(
        db,
        Array(
          InsertIntoSec(ModelTable(model)),
          InsertColumnsSec(form.colSeq),
          InsertSubQuerySec(sub.untyped)
        )
      )
    )
  }
}


class UncheckedValues[M <: Model](model: M, db: Conn, cols: Seq[ModelCol]) extends ValuesNext(model, db) {

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


class SingleRowInsert[M <: Model](model: M, coll: Collector) extends Returning(model, coll) {

  def onConflictDoNothing = {
    new Returning(
      model,
      coll.extend(Array(
        InsertOnConflictSec,
        InsertDoNothingSec
      ))
    )
  }

  def onConflictOnColumn(pick: M => ModelCol) = {
    new OnConflictDo(
      model,
      coll,
      pick(model)
    )
  }

  def whereNotExistsOne(pick: M => Filter) = {
    whereNotExistsImplement(
      Seq(pick(model))
    )
  }

  def whereNotExistsAll(pick: M => Seq[Filter]) = {
    whereNotExistsImplement(pick(model))
  }

  private def whereNotExistsImplement(conds: Seq[Filter]) = {
    val sections = coll.sections.map {
      case InsertValuesSec(values) =>
        InsertWhereNotExistsSec(values, ModelTable(model), WhereAllSec(conds))
      case sec: Section => sec 
    }

    new Returning(
      model,
      coll.copy(sections = sections)
    )
  }
}


case class OnConflictDo[M <: Model](model: M, coll: Collector, conflictCol: ModelCol) {

  def doNothing = {
    new Returning(
      model,
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoNothingSec
      ))
    )
  }

  private def validate(change: SetValue): Unit = {
    if (change.col == conflictCol) {
      throw KuzminkiModelException("cannot update the conflicting column")
    }
  }

  def doUpdate(pick: M => Seq[SetValue]) = {
    val changes = pick(model)
    changes.foreach(validate)
    new Returning(
      model,
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(changes)
      ))
    )
  }

  def doUpdateOne(pick: M => SetValue) = {
    val change = pick(model)
    validate(change)
    new Returning(
      model,
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(Seq(change))
      ))
    )
  }
}






