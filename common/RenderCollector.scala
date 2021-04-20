package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait RenderCollector {
  val prefix: Prefix
  val sections: Array[Section]
  def render = sections.map(_.render(prefix)).mkString(" ")
  def args = sections.toSeq.map(_.args).flatten.toVector
  def statement = SqlWithParams(render, args)
}