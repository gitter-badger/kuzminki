package kuzminki.model


class SubQuery[R](coll: TypedCollector[R]) {
  def untyped = UntypedSubQuery(coll.sections)
}

case class UntypedSubQuery(sections: Array[Section]) extends ResultMethods with Render