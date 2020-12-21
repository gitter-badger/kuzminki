package kuzminki.model.select

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import kuzminki.model._
import kuzminki.model.tuples.{Where => TupleWhere}


class OldColumns[T <: Model](model: T, conn: Connection) {

  def cols(pick: T => Seq[TypeCol[_]]) = {
    new Where(
      SeqCollector.create(
        model,
        pick(model),
        conn
      )
    )
  }
}


class Where[T <: Model](coll: SeqCollector[T]) {

  def where(pick: T => Seq[ModelFilter]) = {
    new OrderBy(
      coll.where(pick(coll.model))
    )
  }
}


class OrderBy[T <: Model](coll: SeqCollector[T]) extends Offset(coll) {

  def orderBy(pick: T => Seq[ModelSorting]) = {
    new Offset(
      coll.orderBy(pick(coll.model))
    )
  }
}


class Offset[T <: Model](coll: SeqCollector[T]) extends Limit(coll) {

  def limit(num: Int) = {
    new Limit(
      coll.limit(num)
    )
  }
}


class Limit[T <: Model](coll: SeqCollector[T]) extends Run(coll) {

  def offset(num: Int) = {
    new Run(
      coll.offset(num)
    )
  }
}


class Run[T <: Model](coll: SeqCollector[T]) {

  def run = coll
}




















