package kuzminki.model

import com.github.vertical_blank.sqlformatter.scala.SqlFormatter


trait Section extends ModelRender {
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
  def part: ModelRender
  def render = expression.format(part.render)
  def args = part.args
}

trait MultiPart extends Section {
  def parts: Seq[ModelRender]
  def expression: String
  def glue: String
  def render = expression.format(parts.map(_.render).mkString(glue))
  def args = parts.map(_.args).flatten
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


case class OnSec(leftCol: ModelRender, rightCol: ModelRender) extends Section {
  def expression = "ON %s = %s"
  def render = expression.format(leftCol.render, rightCol.render)
  def args = Seq.empty[Any]
}


case class WhereChainSec(part: ModelRender) extends SinglePart {
  def expression = "WHERE %s"
}


case class WhereAllSec(parts: Seq[ModelRender]) extends MultiPart {
  def expression = "WHERE %s"
  def glue = " AND "
}


case class GroupBySec(parts: Seq[ModelRender]) extends MultiPart {
  def expression = "GROUP BY %s"
  def glue = ", "
}


case class HavingChainSec(part: ModelRender) extends SinglePart {
  def expression = "HAVING %s"
}


case class HavingAllSec(parts: Seq[ModelRender]) extends MultiPart {
  def expression = "HAVING %s"
  def glue = " AND "
}


case class OrderBySec(parts: Seq[ModelRender]) extends MultiPart {
  def expression = "ORDER BY %s"
  def glue = ", "
}


case class OffsetSec(arg: Int) extends SingleArg {
  def expression = "OFFSET ?"
}


case class LimitSec(arg: Int) extends SingleArg {
  def expression = "LIMIT ?"
}

// delete

case class DeleteFromSec(part: ModelRender) extends SinglePart {
  def expression = "DELETE FROM %s"
}

// Update

case class UpdateSec(part: ModelRender) extends SinglePart {
  def expression = "UPDATE %s"
}


case class UpdateSetSec(parts: Seq[ModelRender]) extends MultiPart {
  def expression = "SET %s"
  def glue = ", "
}

// Insert

case class InsertIntoSec(part: ModelRender) extends SinglePart {
  def expression = "INSERT INTO %s"
}


case class InsertColumnsSec(parts: Seq[ModelRender]) extends MultiPart {
  def expression = "(%s)"
  def glue = ", "
}


case class InsertNestedSec(part: ModelRender) extends SinglePart {
  def expression = "(%s)"
}


case class InsertValuesSec(values: Seq[Any]) extends Section {
  def expression = "VALUES (%s)"
  def render = expression.format(Vector.fill(args.size)("?").mkString(", "))
  def args = values
}


object InsertOnConflictSec extends TextOnly {
  def expression = "ON CONFLICT"
}


case class InsertOnConflictColumnSec(part: ModelRender) extends SinglePart {
  def expression = "ON CONFLICT (%s)"
}


case class InsertOnConflictOnConstraintSec(part: ModelRender) extends SinglePart {
  def expression = "ON CONFLICT ON CONSTRAINT (%s)"
}


object InsertDoNothingSec extends TextOnly {
  def expression = "DO NOTHING"
}


case class InsertDoUpdate(parts: Seq[ModelRender]) extends MultiPart {
  def expression = "DO UPDATE SET %s"
  def glue = ", "
}

// collector

case class QueryResult(template: String, args: Seq[Any])


object Collector {
  def create[T <: Model, R](model: T, transformer: Transformer[R]) = {
    Collector(model, transformer, Array.empty[Section])
  }
}


case class Collector[T <: Model, R](model: T, transformer: Transformer[R], sections: Array[Section]) extends ModelRender {

  def add(sections: Array[Section]) = this.copy(sections = sections)

  def from(model: T) = add(FromSec(ModelTable(model)))

  def where(conds: Seq[ModelCol]) = add(WhereAllSec(conds))

  def orderBy(sorting: Seq[ModelSorting]) = add(OrderBySec(sorting))

  def offset(num: Int) = add(OffsetSec(num))

  def limit(num: Int) = add(LimitSec(num))

  def select(section: SelectSec) = ModelCollector(sections :+ section, section.parts)
  
  def add(section: Section) = ModelCollector(sections :+ section, cols)

  def template = sections.map(_.render).mkString(" ")

  def args = sections.toSeq.map(_.args).flatten

  def render = (template, args)

  def pretty = SqlFormatter.format(template)
}




