package kuzminki.model


class SubQuery[R](sections: Array[Section], output: TypedOutput[R]) {
  def untyped = UntypedSubQuery(sections)
}

case class UntypedSubQuery(sections: Array[Section]) extends ResultMethods with Render