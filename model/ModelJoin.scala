package kuzminki.model

import scala.reflect.ClassTag


object ModelJoinStages {

  trait Columns[A <: Model, B <: Model] {
    def columns(cols: Join[A, B] => Seq[ModelCol]): JoinOn[A, B]
  }

  trait JoinOn[A <: Model, B <: Model] {
    def joinOn(leftOn: A => IntCol, rightOn: B => IntCol): Where[A, B]
  }

  trait Where[A <: Model, B <: Model] {
    def where(conds: Join[A, B] => Seq[ModelFilter]): OrderBy[A, B]
  }

  trait OrderBy[A <: Model, B <: Model] extends OffsetLimit {
    def orderBy(cols: Join[A, B] => Seq[ModelSorting]): OffsetLimit
  }

  trait OffsetLimit extends Limit {
    def offset(num: Int): Limit
    def limit(num: Int): Ready
  }

  trait Limit extends Ready {
    def limit(num: Int): Ready
  }

  trait Ready {
    def asNested: ModelCollector
    def print: Unit
    def pretty: Unit
  }
}

import ModelJoinStages._


case class Join[A <: Model, B <: Model](a: A, b: B) {
  a.__prefix = Some("a")
  b.__prefix = Some("b")
  def left = a
  def right = b
}


case class ModelJoin[A <: Model, B <: Model](join: Join[A, B], sections: ModelCollector) extends Columns[A, B]
                                                                                       with JoinOn[A, B]
                                                                                       with Where[A, B]
                                                                                       with OrderBy[A, B]
                                                                                       with OffsetLimit
                                                                                       with Limit
                                                                                       with Printing {

  def next(section: Section): ModelJoin[A, B] = next(sections.add(section))
  def next(sections: ModelCollector): ModelJoin[A, B] = ModelJoin(join, sections)

  def leftTable = ModelTable(join.a)
  def rightTable = ModelTable(join.b)

  def columns(cols: Join[A, B] => Seq[ModelCol]): JoinOn[A, B] = {
    next(
      sections.add(
        SelectSec(cols(join))
      ).add(
        FromSec(leftTable)
      )
    )
  }

  def joinOn(leftOn: A => IntCol, rightOn: B => IntCol): Where[A, B] = {
    next(
      sections.add(
        InnerJoinSec(rightTable)
      ).add(
        OnSec(leftOn(join.a), rightOn(join.b))
      )
    )
  }

  def where(conds: Join[A, B] => Seq[ModelFilter]): OrderBy[A, B] = {
    next(
      WhereAllSec(conds(join))
    )
  }

  def orderBy(cols: Join[A, B] => Seq[ModelSorting]): OffsetLimit = {
    next(
      OrderBySec(cols(join))
    )
  }

  def offset(num: Int): Limit = next(OffsetSec(num))

  def limit(num: Int): Ready = next(LimitSec(num))

  def asNested = sections
}

















