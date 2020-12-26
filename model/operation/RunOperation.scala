package kuzminki.model.operation

import kuzminki.model._


abstract class RunOperation[M <: Model](coll: OperationCollector[M]) extends Printing {
  def run = coll.executor
  def render = coll.render
}