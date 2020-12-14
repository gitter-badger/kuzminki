package kuzminki

import io.rdbc.sapi._


object DeleteStages {

  trait DeleteFrom {
    def from(table: TableRef): Where
  }

  trait Where extends {
    def where(sub: FilteringStart => Filtering): Ready
    def where(args: Filter*): Ready
    def whereList(args: List[Filter]): Ready
  }

  trait Ready {
    def print: Unit
    def wrapped: Unit
    def pretty: Unit
  }
}

import DeleteStages._


case class Delete(sections: Collector) extends DeleteFrom
                                          with Where
                                          with Ready
                                          with Printing{

  def next(section: Section): Delete = Delete(sections.add(section))

  def from(table: TableRef): Where = next(DeleteFromSec(table))

  def where(sub: FilteringStart => Filtering): Ready = next(WhereChainSec(sub(Filtering.init).filters))

  def where(filters: Filter*): Ready = next(WhereAllSec(filters))

  def whereList(filters: List[Filter]): Ready = next(WhereAllSec(filters))
}