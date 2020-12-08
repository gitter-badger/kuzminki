package kuzminki


case class RenderedPart(tmpl: String, args: Seq[Any])


object RenderedPart {
  def create(tmpl: String) = RenderedPart(tmpl, Seq.empty[Any])
  def create(tmpl: String, args: Seq[Any]) = RenderedPart(tmpl, args)
}


trait Section {
  def render: RenderedPart
  def wrapped: RenderedPart
  def indented: RenderedPart
  def args: Seq[Any]
}


trait NoRender extends Section {
  def expression: String
}


trait SingleArg extends Section {
  def arg: Any
  def expression: String
  def render = expression + " ?"
  def wrapped = render
  def indented = render + "\n" 
  def args = Seq(arg)
}


trait SinglePart extends Render {
  def part: Renderable
  def expression: String
  def assemble(pick: Renderable => String): String = {
    expression + " " + pick()
  }
  def render = assemble(_.render)
  def wrapped = assemble(_.wrap)
  def indented = render + "\n"
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
  def wrapped = assemble(_.wrap, multiLineGlue)
  def indented = assemble(_.render, multiLineGlue) + "\n"
  def args = parts.map(_.args).flatten
}


trait NoArgs {
  def args: Seq[Any] = Seq.empty[Any]
}

// Select

case class SelectSec(cols: Seq[ColumnRef]) extends MultiPart {
  def parts = cols
  def expression = "SELECT %s"
  def oneLineGlue: " AND "
  def multiLineGlue: "\n  AND"
}


case class FromSec(table: TableRef) extends SinglePart {
  def part = table
  def expression = "FROM $s"
}


case class JoinSec(joinHow: String, table: TableRef) extends SinglePart {
  def part = table
  def expression = joinHow + " %s"
}


case class OnSec(table: TableRef) extends SinglePart {
  def part = table
  def expression = "ON %s"
}


case class WhereAllSec(conds: Seq[Cond]) extends MultiPart {
  def parts = cols
  def expression = "WHERE %s"
  def oneLineGlue = " AND "
  def multiLineGlue = "\n  AND "
}


case class HavingAllSec(conds: Seq[Cond]) extends MultiPart {
  def parts = cols
  def expression = "HAVING %s"
  def oneLineGlue = " AND "
  def multiLineGlue = "\n  AND "
}


case class OrderBySec(conds: Seq[SelectOrder]) extends MultiPart {
  def parts = conds
  def expression = "ORDER BY %s"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n         "
}


case class OffsetSec(num: Int) extends SingleArg {
  def arg = num
  def expression = "OFFSET ?"
}


case class LimitSec(num: Int) extends SingleArg {
  def arg = num
  def expression = "LIMIT ?"
}

// Update

case class UpdateSec(table: TableRef) extends SinglePart {
  def part = table
  def expression = "UPDATE %s"
}


case class SetSec(changes: Seq[Change]) extends MultiPart {
  def parts = changes
  def expression = "SET %s"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n    "
}

// Insert

case class InsertIntoSec(table: TableRef) extends SinglePart {
  def part = table
  def expression = "INSERT INTO %s"
}


case class InsertColumnsSec(columns: Seq[Col]) extends MultiPart {
  def parts = conds
  def expression = "(%s)"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n "
}


case class InsertDataSec(columns: Seq[(Col, Any)]) extends MultiPart {
  def parts = conds
  def expression = "(%s)"
  def oneLineGlue = ", "
  def multiLineGlue = ",\n "
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





