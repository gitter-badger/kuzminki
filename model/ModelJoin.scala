package kuzminki.model

import kuzminki.builder._
import kuzminki.strings.TableName


object ModelSelectStages {

  trait Columns[T] {
    def columns(cols: T => Seq[ModelCol]): Where[T]
  }

  trait Where[T] {
    def where(conds: T => Seq[Filter]): OrderBy[T]
  }

  trait OrderBy[T] extends OffsetLimit {
    def orderBy(cols: T => Seq[ModelSorting]): OffsetLimit
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
    def pretty: Unit
  }
}

import ModelSelectStages._


case class Join[A <: Model, B <: Model](a: A, b: B) {
  def left = a
  def right = b
}


case class ModelJoin[A <: Model, B <: Model](join: Join[A, B], sections: Collector) extends Columns[A, B]
                                                                                       with Where[A, B]
                                                                                       with OrderBy[A, B]
                                                                                       with OffsetLimit
                                                                                       with Limit
                                                                                       with Printing {

  def next(section: Section) = ModelSelect(model, sections.add(section))

  def columns(cols: Join[A, B] => Seq[ModelCol]): Where[A, B] = {
    next(
      SelectSec(cols(model))
    ).from(TableName(join.a.tableName).as("a"))
  }

  def from(table: TableName): Where[A, B] = next(FromSec(table))

  def where(conds: Join[A, B] => Seq[Filter]): OrderBy[T] = {
    next(
      WhereAllSec(conds(model))
    )
  }

  def join: JoinOn = next(InnerJoinSec(TableName(join.a.tableName).as("b")))

  def innerJoin: JoinOn = next(InnerJoinSec(TableName(join.a.tableName).as("b")))

  def leftJoin: JoinOn = next(LeftJoinSec(TableName(join.a.tableName).as("b")))

  def leftOuterJoin: JoinOn = next(LeftOuterJoinSec(TableName(join.a.tableName).as("b")))

  def rightJoin: JoinOn = next(RightJoinSec(TableName(join.a.tableName).as("b")))

  def rightOuterJoin: JoinOn = next(RightOuterJoinSec(TableName(join.a.tableName).as("b")))

  def fullOuterJoin: JoinOn = next(FullOuterJoinSec(TableName(join.a.tableName).as("b")))

  def crossJoin: JoinOn = next(CrossJoinSec(TableName(join.a.tableName).as("b")))

  def on

  def orderBy(cols: Join[A, B] => Seq[ModelSorting]): OffsetLimit = {
    next(
      OrderBySec(cols(model))
    )
  }

  def offset(num: Int): Limit = next(OffsetSec(num))

  def limit(num: Int): Ready = next(LimitSec(num))

  def asNested = sections
}

















