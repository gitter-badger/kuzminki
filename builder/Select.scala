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

  def where(sub: FilteringStart => Filtering): OrderBy = next(WhereChainSec(sub(Filtering.init).filters))

  def where(filters: Filter*): OrderBy = next(WhereAllSec(filters))

  def whereList(filters: List[Filter]): OrderBy = next(WhereAllSec(filters))

  // cond

  def join(table: TableRef): JoinOn = next(InnerJoinSec(table))

  def innerJoin(table: TableRef): JoinOn = next(InnerJoinSec(table))

  def leftJoin(table: TableRef): JoinOn = next(LeftJoinSec(table))

  def leftOuterJoin(table: TableRef): JoinOn = next(LeftOuterJoinSec(table))

  def rightJoin(table: TableRef): JoinOn = next(RightJoinSec(table))

  def rightOuterJoin(table: TableRef): JoinOn = next(RightOuterJoinSec(table))

  def fullOuterJoin(table: TableRef): JoinOn = next(JoinSec(table))

  def crossJoin(table: TableRef): JoinOn = next(JoinSec(table))

  // join on

  def on(leftCol: Col, rightCol: Col): WhereOrGroup = next(JoinOnSec(leftCol, rightCol))

  // group by

  def groupBy(cols: Col*): Having = next(GroupBySec(cols))

  def groupByList(cols: List[Col]): Having = next(GroupBySec(cols))

  // having

  def having(sub: FilteringStart => Filtering): OrderBy = next(HavingChainSec(sub(Filtering.init).filters))

  def having(conds: Part*): OrderBy = next(HavingSec(conds))

  def havingList(conds: List[Part]): OrderBy = next(HavingSec(conds))

  // order by

  def orderBy(cols: Sorting*): OffsetLimit = next(OrderBySec(cols))

  def orderByList(cols: List[Sorting]): OffsetLimit = next(OrderBySec(cols))

  // offset

  def offset(num: Int): Limit = next(OffsetSec(num))

  // limit

  def limit(num: Int): Ready = next(LimitSec(num))

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













