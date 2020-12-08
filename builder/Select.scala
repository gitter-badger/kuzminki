package kuzminki

import io.rdbc.sapi._
import containers._


object SelectStages {

  trait Columns {
    def columns(args: Column*): From
    def columnsList(args: List[Column]): From
  }

  trait From extends Ready {
    def from(table: TableRef): WhereOrJoin
  }

  trait WhereOrJoin extends WhereOrGroup {
    def join(table: TableRef): JoinOn
    def innerJoin(table: TableRef): JoinOn
    def leftJoin(table: TableRef): JoinOn
    def leftOuterJoin(table: TableRef): JoinOn
    def rightJoin(table: TableRef): JoinOn
    def rightOuterJoin(table: TableRef): JoinOn
    def fullOuterJoin(table: TableRef): JoinOn
    def crossJoin(table: TableRef): JoinOn
  }

  trait JoinOn extends WhereOrGroup {
    def on(leftCol: String, rightCol: String): WhereOrGroup
  }

  trait WhereOrGroup extends Where {
    def groupBy(args: Col*): Having
    def groupByList(args: List[Col]): Having
  }

  trait Having extends OrderBy {
    def having(sub: FilteringStart => Filtering): OrderBy
    def having(args: Part*): OrderBy
    def havingList(args: List[Part]): OrderBy
  }

  trait Where extends OrderBy {
    def where(sub: FilteringStart => Filtering): OrderBy
    def where(args: Part*): OrderBy
    def whereList(args: List[Part]): OrderBy
  }

  trait OrderBy extends OffsetLimit {
    def orderBy(args: SelectOrder*): OffsetLimit
    def orderByList(args: List[SelectOrder]): OffsetLimit
  }

  trait OffsetLimit extends Limit {
    def offset(num: Int): Limit
    def limit(num: Int): Ready
  }

  trait Limit extends Ready {
    def limit(num: Int): Ready
  }

  trait Ready {
    def sql: SqlWithParams
    def asNested: Part
    def print: Unit
  }
}

import SelectStages._


class Select(parts: Collector) extends Columns
                                  with From
                                  with WhereOrJoin
                                  with JoinOn
                                  with WhereOrGroup
                                  with Having
                                  with Where
                                  with OrderBy
                                  with OffsetLimit
                                  with Limit
                                  with Ready {

  def next(section: Section): Select = new Select(parts.add(section))

  def next(tmpl: String): Select = next(Part.create(tmpl))

  def next(part: Part): Select = next(parts.add(part))

  def next(addedParts: PartCollector): Select = new Select(parts)

  // columns

  def columns(cols: Column*): From = {
    next(
      cols.map(_.render).mkString(", ")
    )
  }

  def columnsList(cols: List[Column]): From = columns(cols: _*)

  // from

  def from(table: TableRef): WhereOrJoin = next(SelectSec(table))

  // where

  def where(sub: FilteringStart => Filtering): OrderBy = {
    next(
      sub(
        Filtering.continue(
          parts.add("WHERE")
        )
      ).parts
    )
  }

  def where(conds: Part*): OrderBy = next(WhereSec(conds))

  def whereList(conds: List[Part]): OrderBy = next(WhereSec(conds))

  // cond

  def join(table: TableRef): JoinOn = next(s"INNER JOIN ${table.render}")

  def innerJoin(table: TableRef): JoinOn = next(s"INNER JOIN ${table.render}")

  def leftJoin(table: TableRef): JoinOn = next(s"LEFT JOIN ${table.render}")

  def leftOuterJoin(table: TableRef): JoinOn = next(s"LEFT OUTER JOIN ${table.render}")

  def rightJoin(table: TableRef): JoinOn = next(s"RIGHT JOIN ${table.render}")

  def rightOuterJoin(table: TableRef): JoinOn = next(s"RIGHT OUTER JOIN ${table.render}")

  def fullOuterJoin(table: TableRef): JoinOn = next(s"FULL OUTER JOIN ${table.render}")

  def crossJoin(table: TableRef): JoinOn = next(s"CROSS JOIN ${table.render}")

  // join on

  def on(leftCol: String, rightCol: String): WhereOrGroup = next(s"ON $leftCol = $rightCol")

  // group by

  def groupBy(cols: Col*): Having = {
    next(
      "GROUP BY " + cols.map(_.render).mkString(", ")
    )
  }

  def groupByList(cols: List[Col]): Having = groupBy(cols: _*)

  // having

  def having(sub: FilteringStart => Filtering): OrderBy = {
    next(
      sub(
        Filtering.continue(
          parts.add("HAVING")
        )
      ).parts
    )
  }

  def having(conds: Part*): OrderBy = {
    next(
      Clause("HAVING ", " AND ", conds)
    )
  }

  def havingList(conds: List[Part]): OrderBy = having(conds: _*)

  // order by

  def orderBy(cols: SelectOrder*): OffsetLimit = {
    next(
      "ORDER BY " + cols.map(_.render).mkString(", ")
    )
  }

  def orderByList(cols: List[SelectOrder]): OffsetLimit = orderBy(cols: _*)

  // offset

  def offset(num: Int): Limit = next(s"OFFSET $num")

  // limit

  def limit(num: Int): Ready = next(s"LIMIT $num")

  // exec

  def sql: SqlWithParams = parts.sql

  def toPart: Part = parts.toPart

  def asNested: Part = parts.asNested

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}













