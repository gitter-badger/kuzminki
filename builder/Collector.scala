package kuzminki


trait Section {
  def render: String
  def wrap: String
  def args: Seq[Any]
}


trait SingleArg extends Section {
  def arg: Any
  def expression: String
  def render = expression
  def wrap = render
  def args = Seq(arg)
}


trait TextOnly extends Section {
  def expression: String
  def render = expression
  def wrap = expression
  def args = Seq.empty[Any]
}


trait SinglePart extends Section {
  def part: Renderable
  def expression: String
  def render = expression.format(part.render)
  def wrap = expression.format(part.wrap)
  def args = part.args
}


trait NestedPart extends Section with Pretty {
  def part: RenderablePretty
  def expression: String
  def render = expression.format(part.render)
  def wrap = expression.format(part.wrap)
  def pretty = expression.format(part.pretty)
  def args = part.args
}


trait MultiPart extends Section with Pretty {
  def parts: Seq[Renderable]
  def expression: String
  def oneLineGlue: String
  def multiLineGlue: String
  def assemble(pick: Renderable => String, glue: String): String = {
    expression.format(
      parts.map(pick).mkString(glue)
    )
  }
  def render = assemble(_.render, oneLineGlue)
  def wrap = assemble(_.wrap, oneLineGlue)
  def pretty = assemble(_.render, multiLineGlue)
  def args = parts.map(_.args).flatten
}


trait NoArgs {
  def args: Seq[Any] = Seq.empty[Any]
}

// Select

case class SelectSec(parts: Seq[ColRef]) extends MultiPart {
  def expression = "SELECT %s"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n       "
}


case class FromSec(part: TableRef) extends SinglePart {
  def expression = "FROM %s"
}


case class InnerJoinSec(part: TableRef) extends SinglePart {
  def expression = "INNER JOIN %s"
}


case class LeftJoinSec(part: TableRef) extends SinglePart {
  def expression = "LEFT JOIN %s"
}


case class LeftOuterJoinSec(part: TableRef) extends SinglePart {
  def expression = "LEFT OUTER JOIN %s"
}


case class RightJoinSec(part: TableRef) extends SinglePart {
  def expression = "RIGHT JOIN %s"
}


case class RightOuterJoinSec(part: TableRef) extends SinglePart {
  def expression = "RIGHT OUTER JOIN %s"
}


case class FullOuterJoinSec(part: TableRef) extends SinglePart {
  def expression = "FULL OUTER JOIN %s"
}


case class CrossJoinSec(part: TableRef) extends SinglePart {
  def expression = "CROSS JOIN %s"
}


case class OnSec(leftCol: ColName, rightCol: ColName) extends Section {
  def render = "ON %s = %s".format(leftCol.render, rightCol.render)
  def wrap = "ON %s = %s".format(leftCol.wrap, rightCol.wrap)
  def args = Seq.empty[Any]
}


case class WhereChainSec(part: NestedFilters) extends NestedPart {
  def expression = "WHERE %s"
}


case class WhereAllSec(parts: Seq[Filter]) extends MultiPart {
  def expression = "WHERE %s"
  def oneLineGlue = " AND "
  def multiLineGlue = "\nAND "
}


case class GroupBySec(parts: Seq[ColRef]) extends MultiPart {
  def expression = "GROUP BY %s"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n         "
}


case class HavingChainSec(part: NestedFilters) extends NestedPart {
  def expression = "HAVING %s"
}


case class HavingAllSec(parts: Seq[Filter]) extends MultiPart {
  def expression = "HAVING %s"
  def oneLineGlue = " AND "
  def multiLineGlue = "\nAND "
}


case class OrderBySec(parts: Seq[Sorting]) extends MultiPart {
  def expression = "ORDER BY %s"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n         "
}


case class OffsetSec(arg: Int) extends SingleArg {
  def expression = "OFFSET ?"
}


case class LimitSec(arg: Int) extends SingleArg {
  def expression = "LIMIT ?"
}

// Update

case class UpdateSec(part: TableRef) extends SinglePart {
  def expression = "UPDATE %s"
}


case class UpdateSetSec(parts: Seq[Change]) extends MultiPart {
  def expression = "SET %s"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n    "
}

// Insert

case class InsertIntoSec(part: TableRef) extends SinglePart {
  def expression = "INSERT INTO %s"
}


case class InsertColumnsSec(parts: Seq[ColName]) extends MultiPart {
  def expression = "(%s)"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n "
}


case class InsertNestedSec(part: Collector) extends NestedPart {
  def expression = "(%s)"
}


case class InsertValuesSec(values: Seq[Any]) extends Section {
  def render = "VALUES (%s)".format(Vector.fill(args.size)("?").mkString(", "))
  def wrap = render
  def args = values
}


object InsertOnConflictSec extends TextOnly {
  def expression = "ON CONFLICT"
}


case class InsertOnConflictColumnSec(part: ColName) extends SinglePart {
  def expression = "ON CONFLICT (%s)"
}


case class InsertOnConflictOnConstraintSec(part: ColName) extends SinglePart {
  def expression = "ON CONFLICT ON CONSTRAINT (%s)"
}


object InsertDoNothingSec extends TextOnly {
  def expression = "DO NOTHING"
}


case class InsertDoUpdate(parts: Seq[Change]) extends MultiPart {
  def expression = "DO UPDATE SET %s"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n              "
}


// collector


case class QueryResult(template: String, args: Seq[Any])


object Collector {
  def init = Collector(Array.empty[Section])
}


case class Collector(sections: Array[Section]) extends RenderablePretty {
  
  def add(section: Section): Collector = Collector(sections :+ section)

  def render = sections.map(_.render).mkString(" ")

  def wrap = sections.map(_.wrap).mkString(" ")

  def pretty = {
    sections.map {
      case sec: Pretty => sec.pretty
      case sec: Section => sec.render
    }.mkString("\n")
  }

  def args = sections.toSeq.map(_.args).flatten

  def renderQuery = QueryResult(render, args)

  def wrappedQuery = QueryResult(wrap, args)

  def prettyQuery = QueryResult(pretty, args)
}





