package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait CollectorRender {
  val sections: Array[Section]
  def render = sections.map(_.render).mkString(" ")
  def args = sections.toSeq.map(_.args).flatten.toVector
  def statement = SqlWithParams(render, args)
}
