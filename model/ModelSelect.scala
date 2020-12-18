package kuzminki.model

import scala.concurrent.Future


object ModelSelectStages {

  trait Columns[T] {
    def columns(cols: T => Seq[ModelCol]): Where[T]
  }

  trait Where[T] {
    def whereOne(conds: T => ModelFilter): OrderBy[T]
    def where(conds: T => Seq[ModelFilter]): OrderBy[T]
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
    def asNested: ModelCollector
    def print: Unit
    def pretty: Unit
    def run: Future[List[Seq[Any]]]
  }
}

import ModelSelectStages._


case class ModelSelect[T <: Model](model: T, sections: ModelCollector, exec: Executor) extends Columns[T]
                                                                                          with Where[T]
                                                                                          with OrderBy[T]
                                                                                          with OffsetLimit
                                                                                          with Limit
                                                                                          with Printing {

  def next(section: Section): ModelSelect[T] = next(sections.add(section))
  def next(sections: ModelCollector): ModelSelect[T] = ModelSelect(model, sections, exec)

  def columns(cols: T => Seq[ModelCol]): Where[T] = {
    next(
      sections.select(
        SelectSec(cols(model))
      ).add(
        FromSec(ModelTable(model))
      )
    )
  }

  def whereOne(conds: T => ModelFilter): OrderBy[T] = {
    next(
      WhereAllSec(Seq(conds(model)))
    )
  }

  def where(conds: T => Seq[ModelFilter]): OrderBy[T] = {
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

  def run = exec.run(sections)
}

















