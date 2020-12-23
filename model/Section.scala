package kuzminki.model


trait Section extends ModelRender {
  def expression: String
  val isUsed: Boolean
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
  val part: ModelRender
  def render = expression.format(part.render)
  def args = part.args
}

trait MultiPart extends Section {
  val parts: Seq[ModelRender]
  def expression: String
  def glue: String
  def render = expression.format(parts.map(_.render).mkString(glue))
  def args = parts.map(_.args).flatten
}

trait Used {
  val isUsed = true
}

// Select

case class SelectSec(parts: Seq[ModelCol]) extends MultiPart with Used {
  def expression = "SELECT %s"
  def glue = ", "
}


case class FromSec(part: ModelTable) extends SinglePart with Used {
  def expression = "FROM %s"
}


case class InnerJoinSec(part: ModelTable) extends SinglePart with Used {
  def expression = "INNER JOIN %s"
}


case class LeftJoinSec(part: ModelTable) extends SinglePart with Used {
  def expression = "LEFT JOIN %s"
}


case class LeftOuterJoinSec(part: ModelTable) extends SinglePart with Used {
  def expression = "LEFT OUTER JOIN %s"
}


case class RightJoinSec(part: ModelTable) extends SinglePart with Used {
  def expression = "RIGHT JOIN %s"
}


case class RightOuterJoinSec(part: ModelTable) extends SinglePart with Used {
  def expression = "RIGHT OUTER JOIN %s"
}


case class FullOuterJoinSec(part: ModelTable) extends SinglePart with Used {
  def expression = "FULL OUTER JOIN %s"
}


case class CrossJoinSec(part: ModelTable) extends SinglePart with Used {
  def expression = "CROSS JOIN %s"
}


case class OnSec(leftCol: ModelRender, rightCol: ModelRender) extends Section with Used {
  def expression = "ON %s = %s"
  def render = expression.format(leftCol.render, rightCol.render)
  def args = Seq.empty[Any]
}


case class WhereChainSec(part: ModelRender) extends SinglePart with Used {
  def expression = "WHERE %s"
}


case class WhereAllSec(optional: Seq[OptionalFilter]) extends MultiPart {
  def expression = "WHERE %s"
  def glue = " AND "
  val parts = optional.filter(_.isUsed).map(_.asInstanceOf[ModelFilter])
  val isUsed = parts.nonEmpty
}


case class GroupBySec(parts: Seq[ModelRender]) extends MultiPart {
  def expression = "GROUP BY %s"
  def glue = ", "
  val isUsed = parts.nonEmpty
}


case class HavingChainSec(part: ModelRender) extends SinglePart with Used {
  def expression = "HAVING %s"
}


case class HavingAllSec(parts: Seq[ModelRender]) extends MultiPart with Used {
  def expression = "HAVING %s"
  def glue = " AND "
}


case class OrderBySec(parts: Seq[ModelRender]) extends MultiPart with Used {
  def expression = "ORDER BY %s"
  def glue = ", "
}


case class OffsetSec(arg: Int) extends SingleArg with Used {
  def expression = "OFFSET ?"
}


case class LimitSec(arg: Int) extends SingleArg with Used {
  def expression = "LIMIT ?"
}

// delete

case class DeleteFromSec(part: ModelRender) extends SinglePart with Used {
  def expression = "DELETE FROM %s"
}

// Update

case class UpdateSec(part: ModelRender) extends SinglePart with Used {
  def expression = "UPDATE %s"
}


case class UpdateSetSec(parts: Seq[ModelRender]) extends MultiPart with Used {
  def expression = "SET %s"
  def glue = ", "
}

// Insert

case class InsertIntoSec(part: ModelRender) extends SinglePart with Used {
  def expression = "INSERT INTO %s"
}


case class InsertColumnsSec(parts: Seq[ModelRender]) extends MultiPart with Used {
  def expression = "(%s)"
  def glue = ", "
}


case class InsertNestedSec(part: ModelRender) extends SinglePart with Used {
  def expression = "(%s)"
}


case class InsertValuesSec(values: Seq[Any]) extends Section with Used {
  def expression = "VALUES (%s)"
  def render = expression.format(Vector.fill(args.size)("?").mkString(", "))
  def args = values
}


object InsertOnConflictSec extends TextOnly with Used {
  def expression = "ON CONFLICT"
}


case class InsertOnConflictColumnSec(part: ModelRender) extends SinglePart with Used {
  def expression = "ON CONFLICT (%s)"
}


case class InsertOnConflictOnConstraintSec(part: ModelRender) extends SinglePart with Used {
  def expression = "ON CONFLICT ON CONSTRAINT (%s)"
}


object InsertDoNothingSec extends TextOnly with Used {
  def expression = "DO NOTHING"
}


case class InsertDoUpdate(parts: Seq[ModelRender]) extends MultiPart with Used {
  def expression = "DO UPDATE SET %s"
  def glue = ", "
}





