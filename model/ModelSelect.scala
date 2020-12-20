package kuzminki.model.select

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import kuzminki.model._


class Columns[T <: Model](model: T, exec: Executor) {

  def cols(pick: T => Seq[TypeCol[_]]) = {
    new Where(
      Collector.create(
        model,
        pick(model),
        exec
      )
    )
  }
}


class Where[T <: Model](coll: Collector[T]) {

  def where(pick: T => Seq[ModelFilter]) = {
    new OrderBy(
      coll.where(pick(coll.model))
    )
  }
}


class OrderBy[T <: Model](coll: Collector[T]) extends Offset(coll) {

  def orderBy(pick: T => Seq[ModelSorting]) = {
    new Offset(
      coll.orderBy(pick(coll.model))
    )
  }
}


class Offset[T <: Model](coll: Collector[T]) extends Limit(coll) {

  def limit(num: Int) = {
    new Limit(
      coll.limit(num)
    )
  }
}


class Limit[T <: Model](coll: Collector[T]) extends Run(coll) {

  def offset(num: Int) = {
    new Run(
      coll.offset(num)
    )
  }
}


class Run[T <: Model](coll: Collector[T]) {

  def render = coll.render

  def args = coll.args

  def asSeq() = coll.results.asSeq()

  def asMap() = coll.results.asMap()

  def asTuple() = coll.results.asTuple()
}



















