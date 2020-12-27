package kuzminki.model


class NestedSelect[R](sections: Array[Section], output: TypedOutput[R]) {
  def untyped = UntypedNestedSelect(sections)
}

case class UntypedNestedSelect(sections: Array[Section]) extends ResultMethods with Render