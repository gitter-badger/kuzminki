package kuzminki

import io.rdbc.sapi._


object SelectStages {

  trait Columns {
    def columns(args: ColRef*): From
    def columnsList(args: List[ColRef]): From
  }

  trait From extends Ready {
    def from(table: TableRef): WhereOrJoin
  }

  trait WhereOrJoin extends WhereOrGroup {
    def join(table: TableAlias): JoinOn
    def innerJoin(table: TableAlias): JoinOn
    def leftJoin(table: TableAlias): JoinOn
    def leftOuterJoin(table: TableAlias): JoinOn
    def rightJoin(table: TableAlias): JoinOn
    def rightOuterJoin(table: TableAlias): JoinOn
    def fullOuterJoin(table: TableAlias): JoinOn
    def crossJoin(table: TableAlias): JoinOn
  }

  trait JoinOn extends WhereOrGroup {
    def on(leftCol: ColName, rightCol: ColName): WhereOrGroup
  }

  trait WhereOrGroup extends Where {
    def groupBy(args: ColRef*): Having
    def groupByList(args: List[ColRef]): Having
  }

  trait Having extends OrderBy {
    def having(sub: FilteringStart => Filtering): OrderBy
    def having(args: Filter*): OrderBy
    def havingList(args: List[Filter]): OrderBy
  }

  trait Where extends OrderBy {
    def where(sub: FilteringStart => Filtering): OrderBy
    def where(args: Filter*): OrderBy
    def whereList(args: List[Filter]): OrderBy
  }

  trait OrderBy extends OffsetLimit {
    def orderBy(args: Sorting*): OffsetLimit
    def orderByList(args: List[Sorting]): OffsetLimit
  }

  trait OffsetLimit extends Limit {
    def offset(num: Int): Limit
    def limit(num: Int): Ready
  }

  trait Limit extends Ready {
    def limit(num: Int): Ready
  }

  trait Ready {
    def asNested: Collector
    def print: Unit
  }
}

import SelectStages._


case class Select(sections: Collector) extends Columns
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

  def next(section: Section): Select = Select(sections.add(section))

  // columns

  def columns(cols: ColRef*): From = next(SelectSec(cols))

  def columnsList(cols: List[ColRef]): From = columns(cols: _*)

  // from

  def from(table: TableRef): WhereOrJoin = next(FromSec(table))

  // where

  def where(sub: FilteringStart => Filtering): OrderBy = next(WhereChainSec(sub(Filtering.init).filters))

  def where(filters: Filter*): OrderBy = next(WhereAllSec(filters))

  def whereList(filters: List[Filter]): OrderBy = next(WhereAllSec(filters))

  // cond

  def join(table: TableAlias): JoinOn = next(InnerJoinSec(table))

  def innerJoin(table: TableAlias): JoinOn = next(InnerJoinSec(table))

  def leftJoin(table: TableAlias): JoinOn = next(LeftJoinSec(table))

  def leftOuterJoin(table: TableAlias): JoinOn = next(LeftOuterJoinSec(table))

  def rightJoin(table: TableAlias): JoinOn = next(RightJoinSec(table))

  def rightOuterJoin(table: TableAlias): JoinOn = next(RightOuterJoinSec(table))

  def fullOuterJoin(table: TableAlias): JoinOn = next(FullOuterJoinSec(table))

  def crossJoin(table: TableAlias): JoinOn = next(CrossJoinSec(table))

  // join on

  def on(leftCol: ColName, rightCol: ColName): WhereOrGroup = next(OnSec(leftCol, rightCol))

  // group by

  def groupBy(cols: ColRef*): Having = next(GroupBySec(cols))

  def groupByList(cols: List[ColRef]): Having = next(GroupBySec(cols))

  // having

  def having(sub: FilteringStart => Filtering): OrderBy = next(HavingChainSec(sub(Filtering.init).filters))

  def having(conds: Filter*): OrderBy = next(HavingAllSec(conds))

  def havingList(conds: List[Filter]): OrderBy = next(HavingAllSec(conds))

  // order by

  def orderBy(cols: Sorting*): OffsetLimit = next(OrderBySec(cols))

  def orderByList(cols: List[Sorting]): OffsetLimit = next(OrderBySec(cols))

  // offset

  def offset(num: Int): Limit = next(OffsetSec(num))

  // limit

  def limit(num: Int): Ready = next(LimitSec(num))

  // exec

  def asNested: Collector = sections

  def print: Unit = {
    sections.renderQuery match {
      case QueryResult(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}













