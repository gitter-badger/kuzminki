package kuzminki.model


class SubQuery[R](coll: SelectCollector[R]) {
  def untyped = UntypedSubQuery(coll.sections)
}

class AggSubQuery[R](coll: SelectCollector[R]) {
  def untyped = UntypedSubQuery(coll.sections)
}

class SingleNumberSubquery(coll: SubCollector) {
  def untyped = UntypedSubQuery(coll.sections)
}

case class UntypedSubQuery(coll: SubCollector) extends Renderable {
  def render = coll.render
  def prefix(picker: Prefix) = coll.render
  def args = coll.args
}


