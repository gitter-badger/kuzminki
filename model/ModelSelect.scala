package kuzminki.model.select

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import kuzminki.model._


class Columns[T <: Model](model: T, exec: Executor) extends TupleCols(model, exec) {

  def cols(pick: T => Seq[ModelCol]) = {
    new Where(
      Collector.create(
        model,
        SeqCols(pick(model)),
        exec
      )
    )
  }
}


class Where[T <: Model, R](coll: Collector[T, R]) {

  def where(pick: T => Seq[ModelFilter]) = {
    new OrderBy(
      coll.where(pick(coll.model))
    )
  }
}


class OrderBy[T <: Model, R](coll: Collector[T, R]) extends Offset(coll) {

  def orderBy(pick: T => Seq[ModelSorting]) = {
    new Offset(
      coll.orderBy(pick(coll.model))
    )
  }
}


class Offset[T <: Model, R](coll: Collector[T, R]) extends Limit(coll) {

  def limit(num: Int) = {
    new Limit(
      coll.limit(num)
    )
  }
}


class Limit[T <: Model, R](coll: Collector[T, R]) extends Run(coll) {

  def offset(num: Int) = {
    new Run(
      coll.offset(num)
    )
  }
}


class Run[T <: Model, R](coll: Collector[T, R]) {

  def render = coll.render

  def args = coll.args

  def run()(implicit ec: ExecutionContext): Future[List[R]] = {
    coll.exec.run(coll.render, coll.args).map { rows => 
      rows.map(row => coll.transformer.transform(row))
    }
  }
}



















