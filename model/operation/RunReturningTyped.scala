package kuzminki.model.operation

import kuzminki.model._


class RunReturning[T <: Model, R](coll: TypedCollector[T, R]) extends Printing {

  def run = coll.executor
  def render = coll.render
}