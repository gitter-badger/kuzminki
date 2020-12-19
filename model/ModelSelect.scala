package kuzminki.model.select

import scala.concurrent.Future


class Columns[T <: Model](model: T, exec: Executor) extends TupleCols(model, exec) {

  def columns(pick: T => Seq[ModelCol]): Where[T, R] = {
    new Where(
      Collector(
        StandardArgs(pick(model)),
        exec
      ).from(model)
    )
  }
}


class Where[T <: Model, R](model: T, coll: Collector[R]) {

  def where(pick: T => Seq[ModelFilter]): OrderBy[T, R] = {
    new Rest(
      coll.where(pick(model))
    )
  }
}


class OrderBy[T <: Model, R](model: T, coll: Collector[R]) extends Offset(model, coll) {

  def orderBy(pick: T => Seq[ModelSorting]): OffsetLimi[T, R] = {
    new Offset(
      coll.orderBy(pick(model))
    )
  }
}


class Offset[T <: Model, R](model: T, coll: Collector[R]) extends Limit(model, coll) {

  def limit(num: Int): Ready = next(LimitSec(num)) {
    new Run(
      coll.limit(num)
    )
  }
}


class Limit[T <: Model, R](model: T, coll: Collector[R]) extends Limit(model, coll) {

  def offset(num: Int): Limit = {
    new Limit(
      coll.offset(num)
    )
  }
}


class Run[T <: Model, R](model: T, coll: Collector[R]) extends Limit(model, coll) {

  def template: Tuple[String, Seq[Any]] = coll.template

  def render: Tuple[String, Seq[Any]] = coll.render

  def run(): Future[List[R]] = coll.run()
}



















