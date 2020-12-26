package kuzminki.model


class NestedSelect[R](exec: TupleExecutor[R]) {
  def untyped = UntypedNestedSelect(exec.statement.sql, exec.statement.params.toSeq)
}

case class UntypedNestedSelect(render: String, args: Seq[Any]) extends ModelRender