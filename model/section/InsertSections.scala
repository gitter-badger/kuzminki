package kuzminki.model


trait Values extends Section {
  def blank(size: Int) = Vector.fill(size)("?").mkString(", ")
  def fill(size: Int) = "(%s)".format(blank(size))
}

case class InsertIntoSec(part: ModelTable) extends SinglePart {
  def expression = "INSERT INTO %s"
}


case class InsertColumnsSec(parts: Seq[ModelCol]) extends MultiPart {
  def expression = "(%s)"
  def glue = ", "
}

case class InsertValuesSec(values: Seq[Any]) extends Values {
  def expression = "VALUES %s"
  def render = expression.format(fill(values.size))
  def args = values
}

case class InsertBlankValuesSec(size: Int) extends Values {
  def expression = "VALUES %s"
  def render = expression.format(fill(size))
  def args = Seq.empty[Any]
}

case class InsertMultipleValuesSec(valuesList: Seq[Seq[Any]]) extends Values {
  def expression = "VALUES %s"
  def render = {
    expression.format(
      valuesList.map(values => fill(values.size)).mkString(", ")
    )
  }
  def args = valuesList.flatten
}

case class InsertWhereNotExistsSec(values: Seq[Any], table: ModelTable, where: WhereAllSec) extends Values {
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

case class InsertBlankWhereNotExistsSec(size: Int, table: ModelTable, where: WhereAllSec) extends Values {
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

case class InsertSubQuerySec(part: UntypedSubQuery) extends SinglePart {
  def expression = "(%s)"
}

object InsertOnConflictSec extends TextOnly {
  def expression = "ON CONFLICT"
}

case class InsertOnConflictColumnSec(part: ModelCol) extends SinglePart {
  def expression = "ON CONFLICT (%s)"
}

case class InsertOnConflictOnConstraintSec(part: Render) extends SinglePart {
  def expression = "ON CONFLICT ON CONSTRAINT (%s)"
}

object InsertDoNothingSec extends TextOnly {
  def expression = "DO NOTHING"
}

case class InsertDoUpdateSec(parts: Seq[Render]) extends MultiPart {
  def expression = "DO UPDATE SET %s"
  def glue = ", "
}






