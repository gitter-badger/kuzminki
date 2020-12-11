package kuzminki


case class RenderedPart(template: String, args: Seq[Any])


object RenderedPart {
  def create(tmpl: String) = RenderedPart(tmpl, Seq.empty[Any])
  def create(tmpl: String, args: Seq[Any]) = RenderedPart(tmpl, args)
}


trait Renderable {
  def render: String
  def wrap: String
  def pretty: String
  def args: Seq[Any]
}

// section

trait Section {
  def render: String
  def wrapp: String
  def pretty: String
  def args: Seq[Any]
}


trait SingleArg extends Section {
  def arg: Any
  def expression: String
  def render = expression + " ?"
  def wrap = render
  def pretty = render + "\n" 
  def args = Seq(arg)
}


trait TextOnly extends Section {
  def expression: String
  def render = expression
  def wrap = expression
  def pretty = expression + "\n" 
  def args = Seq.empty[Any]
}


trait SinglePart extends Render {
  def part: Renderable
  def expression: String
  def render = expression.format(part.render)
  def wrap = expression.format(part.wrap)
  def pretty = expression.format(part.wrap)
  def args = part.args
}


trait MultiPart extends Render {
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
  def pretty = assemble(_.render, multiLineGlue) + "\n"
  def args = parts.map(_.args).flatten
}


trait NoArgs {
  def args: Seq[Any] = Seq.empty[Any]
}

// Select

case class SelectSec(parts: Seq[ColumnRef]) extends MultiPart {
  def expression = "SELECT %s"
  def oneLineGlue: " AND "
  def multiLineGlue: "\n  AND"
}


case class FromSec(part: TableRef) extends SinglePart {
  def part = table
  def expression = "FROM $s"
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


case class OnSec(leftCol: Col, rightCol: Col) extends Section {
  def render = leftCol.render + " = " + rightCol.render
  def wrapped = leftCol.wrap + " = " + rightCol.wrap
  def indented = render + "\n"
  def args = Seq.empty[Any]
}


case class WhereChainSec(part: NestedFilters) extends SinglePart {
  def expression = "WHERE %s"
}


case class WhereAllSec(parts: Seq[Cond]) extends MultiPart {
  def expression = "WHERE %s"
  def oneLineGlue = " AND "
  def multiLineGlue = "\n  AND "
}


case class HavingChainSec(part: NestedFilters) extends SinglePart {
  def expression = "HAVING %s"
}


case class HavingAllSec(parts: Seq[Cond]) extends MultiPart {
  def expression = "HAVING %s"
  def oneLineGlue = " AND "
  def multiLineGlue = "\n  AND "
}


case class OrderBySec(parts: Seq[SelectOrder]) extends MultiPart {
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


case class InsertColumnsSec(parts: Seq[Col]) extends MultiPart {
  def expression = "(%s)"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n "
}


case class InsertDataSec(pairs: Map[(Col, Any)]) extends Section {
  def parts = pairs
  def expression = "(%s)"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n "
}


case class InsertNestedSec(nested: SelectStages.Ready) extends Section {
  def render = nested.render
  def wrapped = nested.wrapped
  def indented = nested.indented
  def args = nested.args
}


case class InsertValuesSec(values: Seq[Any]) extends Section {
  def render = "VALUES (%s)".format(Vector.fill(args.size)("?").mkString(", "))
  def wrapped = render
  def indented = render + "\n"
  def args = values
}


object InsertOnConflictSec extends Section {
  def render = "ON CONFLICT"
  def wrapped = render
  def indented = render + "\n"
  def args = Seq.empty[Any]
}


case class InsertOnConflictColumnSec(col: Col) extends SinglePart {
  def part = col
  def expression = "ON CONFLICT (%s)"
}


case class InsertOnConflictOnConstraintSec(const: Col) extends SinglePart {
  def part = const
  def expression = "ON CONFLICT ON CONSTRAINT (%s)"
}


object InsertDoNothingSec extends Section {
  def render = "DO NOTHING"
  def wrapped = render
  def indented = render + "\n"
  def args = Seq.empty[Any]
}


case class InsertDoUpdate(changes: Seq[Change]) extends Section {
  def parts = changes
  def expression = "DO UPDATE SET %s"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n              "
}






// -----

object Part {
  def create(tmpl: String) = NoArgs(tmpl)
  def create(tmpl: String, args: Seq[Any]) = WithArgs(tmpl, args)
}

trait Part {
  def tmpl: String
  def args: Seq[Any]
}

case class NoArgs(tmpl: String) extends Part {
  def args = Seq.empty[Any]
}


case class Clause(clause: String, glue: String, parts: Seq[Section]) extends Part {
  def tmpl = clause + parts.map(_.tmpl).mkString(glue)
  def args = parts.map(_.args).flatten
}


object Collector {
  
  def init = PartCollector(Array.empty[Part])
  
  def create(part: Part) = PartCollector(Array(part))

  def start(tmpl: String) = create(Part.create(tmpl))
}


case class Collector(parts: Array[Part]) {
  
  def add(part: Part): Collector = Collector(parts :+ part)

  def add(tmpl: String): Collector = add(Part.create(tmpl))

  def toPair = Part(parts.map(_.tmpl).mkString(" "), parts.map(_.args).flatten)

  def asNested = toPair.asNested

  def sql = {
    toPair match {
      case Pair(tmpl, args) => 
        SqlWithParams(tmpl, args)
    }
  } 
}





