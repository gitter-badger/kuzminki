package kuzminki.model


trait Section extends Render {
  def expression: String
}

trait SingleArg extends Section {
  def arg: Any
  def expression: String
  def render = expression
  def args = Seq(arg)
}

trait TextOnly extends Section {
  def render = expression
  def args = Seq.empty[Any]
}

trait SinglePart extends Section {
  val part: Render
  def render = expression.format(part.render)
  def args = part.args
}

trait MultiPart extends Section {
  val parts: Seq[Render]
  def expression: String
  def glue: String
  def render = expression.format(parts.map(_.render).mkString(glue))
  def args = parts.map(_.args).flatten
}

trait Values extends Section {
  def fill(size: Int) = {
    "(%s)".format(
      Vector.fill(size)("?").mkString(", ")
    )
  }
}

// Select

case class SelectSec(parts: Seq[ModelCol]) extends MultiPart {
  def expression = "SELECT %s"
  def glue = ", "
}


case class FromSec(part: ModelTable) extends SinglePart {
  def expression = "FROM %s"
}


case class InnerJoinSec(part: ModelTable) extends SinglePart {
  def expression = "INNER JOIN %s"
}


case class LeftJoinSec(part: ModelTable) extends SinglePart {
  def expression = "LEFT JOIN %s"
}


case class LeftOuterJoinSec(part: ModelTable) extends SinglePart {
  def expression = "LEFT OUTER JOIN %s"
}


case class RightJoinSec(part: ModelTable) extends SinglePart {
  def expression = "RIGHT JOIN %s"
}


case class RightOuterJoinSec(part: ModelTable) extends SinglePart {
  def expression = "RIGHT OUTER JOIN %s"
}


case class FullOuterJoinSec(part: ModelTable) extends SinglePart {
  def expression = "FULL OUTER JOIN %s"
}


case class CrossJoinSec(part: ModelTable) extends SinglePart {
  def expression = "CROSS JOIN %s"
}


case class OnSec(leftCol: ModelCol, rightCol: ModelCol) extends Section {
  def expression = "ON %s = %s"
  def render = expression.format(leftCol.render, rightCol.render)
  def args = Seq.empty[Any]
}


case class WhereAllSec(parts: Seq[Filter]) extends MultiPart {
  def expression = "WHERE %s"
  def glue = " AND "
}


case class WhereAnySec(parts: Seq[Filter]) extends MultiPart {
  def expression = "WHERE %s"
  def glue = " OR "
}


case class GroupBySec(parts: Seq[ModelCol]) extends MultiPart {
  def expression = "GROUP BY %s"
  def glue = ", "
}


case class HavingSec(parts: Seq[Render]) extends MultiPart {
  def expression = "HAVING %s"
  def glue = " AND "
}


case class OrderBySec(parts: Seq[Render]) extends MultiPart {
  def expression = "ORDER BY %s"
  def glue = ", "
}


case class OffsetSec(arg: Int) extends SingleArg {
  def expression = "OFFSET ?"
}


case class LimitSec(arg: Int) extends SingleArg {
  def expression = "LIMIT ?"
}

// count

case class CountFromSec(part: ModelTable) extends SinglePart {
  def expression = "SELECT COUNT(*) FROM %s"
}

// delete

case class DeleteFromSec(part: Render) extends SinglePart {
  def expression = "DELETE FROM %s"
}

// returning

case class ReturningSec(parts: Seq[ModelCol]) extends MultiPart {
  def expression = "RETURNING %s"
  def glue = ", "
}

// Update

case class UpdateSec(part: ModelTable) extends SinglePart {
  def expression = "UPDATE %s"
}


case class UpdateSetSec(parts: Seq[Assign]) extends MultiPart {
  def expression = "SET %s"
  def glue = ", "
}

// Insert

case class InsertIntoSec(part: Render) extends SinglePart {
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
      fill(values.size),
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
      fill(size),
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


case class InsertDoUpdateSec(parts: Seq[Assign]) extends MultiPart {
  def expression = "DO UPDATE SET %s"
  def glue = ", "
}





