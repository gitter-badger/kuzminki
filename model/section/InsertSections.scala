package kuzminki.model


case class InsertIntoSec(part: ModelTable) extends SingleRender {
  def expression = "INSERT INTO %s"
}


case class InsertColumnsSec(parts: Seq[AnyCol]) extends MultiRender {
  def expression = "(%s)"
  def glue = ", "
}

case class InsertValuesSec(values: Seq[Any]) extends Section with FillValues {
  def expression = "VALUES %s"
  def render(prefix: Prefix) = expression.format(fillBrackets(values.size))
  def args = values
}

case class InsertBlankValuesSec(size: Int) extends Section with FillValues with NoArgs {
  def expression = "VALUES %s"
  def render(prefix: Prefix) = expression.format(fillBrackets(size))
}

case class InsertMultipleValuesSec(valuesList: Seq[Seq[Any]]) extends Section with FillValues {
  def expression = "VALUES %s"
  def render(prefix: Prefix) = {
    expression.format(
      valuesList.map(values => fillBrackets(values.size)).mkString(", ")
    )
  }
  def args = valuesList.flatten
}

case class InsertBlankWhereNotExistsSec(size: Int, table: ModelTable, where: WhereSec) extends Section with FillValues with NoArgs {
  def expression = "SELECT %s WHERE NOT EXISTS (SELECT 1 FROM %s %s)"
  def render(prefix: Prefix) = {
    expression.format(
      fillNoBrackets(size),
      table.render(prefix),
      where.render(prefix)
    )
  }
}

/*
case class InsertWhereNotExistsSec(values: Seq[Any], table: ModelTable, where: WhereSec) extends Section with Values with NoJoin {
  def expression = "SELECT %s WHERE NOT EXISTS (SELECT 1 FROM %s %s)"
  def render = {
    expression.format(
      blank(values.size),
      table.render,
      where.render
    )
  }
  def args = values ++ where.args
}

case class InsertSubQuerySec(part: UntypedSubQuery) extends SinglePart {
  def expression = "(%s)"
}
*/

object InsertOnConflictSec extends TextOnly {
  def expression = "ON CONFLICT"
}

case class InsertOnConflictColumnSec(part: AnyCol) extends SingleRender {
  def expression = "ON CONFLICT (%s)"
}

object InsertDoNothingSec extends TextOnly {
  def expression = "DO NOTHING"
}

case class InsertDoUpdateSec(parts: Seq[AnyCol]) extends MultiRender {
  def expression = "DO UPDATE SET %s"
  def glue = ", "
}






