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

case class UntypedSubQuery(sections: Array[Section]) extends ResultMethods with Render


