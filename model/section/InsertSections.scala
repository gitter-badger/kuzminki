package kuzminki.model


case class InsertIntoSec(part: ModelTable) extends SingleRender {
  def expression = "INSERT INTO %s"
}

case class InsertDataSec(parts: Seq[SetValue]) extends Section with FillValues {
  def expression = "(%s) VALUES (%s)"
  def render(prefix: Prefix) = expression.format(
    parts.map(_.col.render(prefix)).mkString(", "),
    fillNoBrackets(parts.size)
  )
  def args = parts.map(_.value)
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

object InsertOnConflictSec extends TextOnly {
  def expression = "ON CONFLICT"
}

case class InsertOnConflictColumnSec(part: AnyCol) extends SingleRender {
  def expression = "ON CONFLICT (%s)"
}

object InsertDoNothingSec extends TextOnly {
  def expression = "DO NOTHING"
}

case class InsertDoUpdateSec(parts: Seq[SetValue]) extends MultiRender {
  def expression = "DO UPDATE SET %s"
  def glue = ", "
}

case class InsertDoUpdateNoArgsSec(parts: Seq[ModelCol]) extends Section with NoArgs {
  def expression = "DO UPDATE SET %s"
  def render(prefix: Prefix) = expression.format(
    parts.map(_.name).mkString(", ")
  )
}

case class InsertSubquerySec(part: Renderable) extends SingleRender {
  def expression = "%s"
}






