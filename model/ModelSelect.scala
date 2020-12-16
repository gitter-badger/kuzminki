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


case class ModelSelect[T <: Model](model: T, sections: Collector) extends Columns[T]
                                                                     with Where[T]
                                                                     with OrderBy[T]
                                                                     with OffsetLimit
                                                                     with Limit
                                                                     with Printing {

  def next(section: Section) = ModelSelect(model, sections.add(section))

  def columns(cols: T => Seq[ModelCol]): Where[T] = {
    next(
      SelectSec(cols(model))
    ).from(TableName(model.tableName))
  }

  def from(table: TableName): Where[T] = next(FromSec(table))

  def where(conds: T => Seq[Filter]): OrderBy[T] = {
    next(
      WhereAllSec(conds(model))
    )
  }

  def orderBy(cols: T => Seq[ModelSorting]): OffsetLimit = {
    next(
      OrderBySec(cols(model))
    )
  }

  def offset(num: Int): Limit = next(OffsetSec(num))

  def limit(num: Int): Ready = next(LimitSec(num))

  def asNested = sections
}

















