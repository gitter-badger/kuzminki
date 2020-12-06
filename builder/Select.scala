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


class Select(parts: PartCollector) extends Columns
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

  def next(tmpl: String): Select = new Select(parts.add(tmpl))

  def next(tmpl: String, args: Seq[Any]): Select = new Select(parts.add(tmpl, args))

  def next(parts: PartCollector): Select = new Select(parts)

  // columns

  def columns(cols: Column*): From = columnsList(cols.toList)

  def columnsList(cols: List[Column]): From = {
    next(
      cols.map(_.render).mkString(", ")
    )
  }

  // from

  def from(table: TableRef): WhereOrJoin = next(s"FROM ${table.render}")

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

  def where(args: Part*): OrderBy = whereList(args.toList)

  def whereList(args: List[Part]): OrderBy = {
    next(
      "WHERE " + args.map(_.tmpl).mkString(" AND "),
      args.map(_.args).flatten
    )
  }

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

  def groupBy(args: Col*): Having = groupByList(args.toList)

  def groupByList(args: List[Col]): Having = {
    next(
      "GROUP BY " + args.map(_.render).mkString(", ")
    )
  }

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

  def having(args: Part*): OrderBy = whereList(args.toList)

  def havingList(args: List[Part]): OrderBy = {
    next(
      "HAVING " + args.map(_.tmpl).mkString(" AND "),
      args.map(_.args).flatten
    )
  }

  // order by

  def orderBy(args: SelectOrder*): OffsetLimit = orderByList(args.toList)

  def orderByList(args: List[SelectOrder]): OffsetLimit = {
    next(
      "ORDER BY " + args.map(_.render).mkString(", ")
    )
  }

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













