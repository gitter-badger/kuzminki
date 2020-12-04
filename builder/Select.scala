package kuzminki

import io.rdbc.sapi._
import operators._
import columns._


object SelectStages {

  trait Columns {
    def columns(args: String*): From
    def columns(args: List[Col]): From
  }

  trait From extends Ready {
    def from(table: String): WhereOrJoin
    def from(table: String, alias: String): WhereOrJoin
  }

  trait WhereOrJoin extends WhereOrGroup {
    def join(table: String): JoinOn
    def join(table: String, alias: String): JoinOn
    def innerJoin(table: String): JoinOn
    def innerJoin(table: String, alias: String): JoinOn
    def leftJoin(table: String): JoinOn
    def leftJoin(table: String, alias: String): JoinOn
    def leftOuterJoin(table: String): JoinOn
    def leftOuterJoin(table: String, alias: String): JoinOn
    def rightJoin(table: String): JoinOn
    def rightJoin(table: String, alias: String): JoinOn
    def rightOuterJoin(table: String): JoinOn
    def rightOuterJoin(table: String, alias: String): JoinOn
    def fullOuterJoin(table: String): JoinOn
    def fullOuterJoin(table: String, alias: String): JoinOn
    def crossJoin(table: String): JoinOn
    def crossJoin(table: String, alias: String): JoinOn
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
    def havingAll(args: Part*): OrderBy
    def havingList(args: List[Part]): OrderBy
  }

  trait Where extends OrderBy {
    def where(sub: FilteringStart => Filtering): OrderBy
    def whereAll(args: Part*): OrderBy
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

  def columns(args: String*): From = columns(args.toList.map(Col(_)))

  def columns(args: List[Col]): From = {
    next(
      args.map(_.render).mkString(", ")
    )
  }

  // from

  def from(table: String): WhereOrJoin = next(s"FROM $table")

  def from(table: String, alias: String): WhereOrJoin = next(s"FROM $table $alias")

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

  def whereAll(args: Part*): OrderBy = whereList(args.toList)

  def whereList(args: List[Part]): OrderBy = {
    next(
      parts
        .add("WHERE")
        .extend(
          PartCollector.join(Part.create("AND"), args)
        )
    )
  }

  // cond

  def join(table: String): JoinOn = next(s"INNER JOIN $table")

  def join(table: String, alias: String): JoinOn = next(s"INNER JOIN $table $alias")

  def innerJoin(table: String): JoinOn = next(s"INNER JOIN $table")

  def innerJoin(table: String, alias: String): JoinOn = next(s"INNER JOIN $table $alias")

  def leftJoin(table: String): JoinOn = next(s"LEFT JOIN $table")

  def leftJoin(table: String, alias: String): JoinOn = next(s"LEFT JOIN $table $alias")

  def leftOuterJoin(table: String): JoinOn = next(s"LEFT OUTER JOIN $table")

  def leftOuterJoin(table: String, alias: String): JoinOn = next(s"LEFT OUTER JOIN $table $alias")

  def rightJoin(table: String): JoinOn = next(s"RIGHT JOIN $table")

  def rightJoin(table: String, alias: String): JoinOn = next(s"RIGHT JOIN $table $alias")

  def rightOuterJoin(table: String): JoinOn = next(s"RIGHT OUTER JOIN $table")

  def rightOuterJoin(table: String, alias: String): JoinOn = next(s"RIGHT OUTER JOIN $table $alias")

  def fullOuterJoin(table: String): JoinOn = next(s"FULL OUTER JOIN $table")

  def fullOuterJoin(table: String, alias: String): JoinOn = next(s"FULL OUTER JOIN $table $alias")

  def crossJoin(table: String): JoinOn = next(s"CROSS JOIN $table")

  def crossJoin(table: String, alias: String): JoinOn = next(s"CROSS JOIN $table $alias")

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

  def havingAll(args: Part*): OrderBy = whereList(args.toList)

  def havingList(args: List[Part]): OrderBy = {
    next(
      parts
        .add("HAVING")
        .extend(
          PartCollector.join(Part.create("AND"), args)
        )
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













