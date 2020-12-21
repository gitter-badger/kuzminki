package kuzminki.model.tuples

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import kuzminki.model._
import kuzminki.model.select._


class Columns[T <: Model](model: T, conn: Connection) {

  def cols2[A1, A2](pick: T => Tuple2[TypeCol[A1], TypeCol[A2]]) = {
    new Where(
      TupleCollector.create(
        model,
        Tuple2Cols(pick(model)),
        conn
      )
    )
  }
}


class Where[T <: Model, R](coll: TupleCollector[T, R]) {

  def where(pick: T => Seq[ModelFilter]) = {
    new OrderBy(
      coll.where(pick(coll.model))
    )
  }
}


class OrderBy[T <: Model, R](coll: TupleCollector[T, R]) extends Offset(coll) {

  def orderBy(pick: T => Seq[ModelSorting]) = {
    new Offset(
      coll.orderBy(pick(coll.model))
    )
  }
}


class Offset[T <: Model, R](coll: TupleCollector[T, R]) extends Limit(coll) {

  def limit(num: Int) = {
    new Limit(
      coll.limit(num)
    )
  }
}


class Limit[T <: Model, R](coll: TupleCollector[T, R]) extends Run(coll) {

  def offset(num: Int) = {
    new Run(
      coll.offset(num)
    )
  }
}


class Run[T <: Model, R](coll: TupleCollector[T, R]) {

  def run = coll
}



















