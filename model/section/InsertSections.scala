package kuzminki.model


trait Values {
  def blank(size: Int) = Vector.fill(size)("?").mkString(", ")
  def fill(size: Int) = "(%s)".format(blank(size))
}

trait NoJoin {
  def render: String
  def prefix(picker: Prefix) = render
}

case class InsertIntoSec(part: ModelTable) extends SinglePart {
  def expression = "INSERT INTO %s"
}


case class InsertColumnsSec(parts: Seq[RenderableCol]) extends MultiPart {
  def expression = "(%s)"
  def glue = ", "
}

case class InsertValuesSec(values: Seq[Any]) extends Section with Values with NoJoin {
  def expression = "VALUES %s"
  def render = expression.format(fill(values.size))
  def args = values
}

case class InsertBlankValuesSec(size: Int) extends Section with Values with NoJoin {
  def expression = "VALUES %s"
  def render = expression.format(fill(size))
  def args = Seq.empty[Any]
}

case class InsertMultipleValuesSec(valuesList: Seq[Seq[Any]]) extends Section with Values with NoJoin {
  def expression = "VALUES %s"
  def render = {
    expression.format(
      valuesList.map(values => fill(values.size)).mkString(", ")
    )
  }
  def args = valuesList.flatten
}

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

case class InsertBlankWhereNotExistsSec(size: Int, table: ModelTable, where: WhereSec) extends Section with Values with NoJoin {
  def expression = "SELECT %s WHERE NOT EXISTS (SELECT 1 FROM %s %s)"
  def render = {
    expression.format(
      blank(size),
      table.render,
      where.render
    )
  }
  def args = where.args
}
/*
case class InsertSubQuerySec(part: UntypedSubQuery) extends SinglePart {
  def expression = "(%s)"
}
*/
object InsertOnConflictSec extends TextOnly {
  def expression = "ON CONFLICT"
}

case class InsertOnConflictColumnSec(part: RenderableCol) extends SinglePart {
  def expression = "ON CONFLICT (%s)"
}

object InsertDoNothingSec extends TextOnly {
  def expression = "DO NOTHING"
}

case class InsertDoUpdateSec(parts: Seq[Renderable]) extends MultiPart {
  def expression = "DO UPDATE SET %s"
  def glue = ", "
}






