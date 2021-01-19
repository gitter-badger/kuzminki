package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait SelectCollector {
  def add(section: Section): SelectCollector
  def extend(added: Array[Section]): SelectCollector
  def render: String
  def args: Seq[Any]
  def statement: SqlWithParams
}
