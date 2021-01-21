package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait RenderCollector {
  val prefix: Prefix
  val sections: Array[Section]
  def render = sections.map(_.render(prefix)).mkString(" ")
  def args = sections.toSeq.map(_.args).flatten.toVector
  def statement = SqlWithParams(render, args)
}


case class SelectCollector[R](
      db: Conn,
      prefix: Prefix,
      outShape: RowShape[R],
      sections: Array[Section]
    ) extends RenderCollector {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)
}

/*
trait SelectCollector[R] {
  val db: Conn
  val outShape: RowShape[R]
  val sections: Array[Section]
  def render: String
  def add(section: Section): SelectCollector[R]
  def extend(added: Array[Section]): SelectCollector[R]
  def args = sections.toSeq.map(_.args).flatten.toVector
  def statement = SqlWithParams(render, args)
}

case class StandardCollector[R](
      db: Conn,
      outShape: RowShape[R],
      sections: Array[Section]
    ) extends SelectCollector[R] {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def render = sections.map(_.render).mkString(" ")
}
*/





















