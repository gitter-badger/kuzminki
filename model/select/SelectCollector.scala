package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait SelectCollector {
  val sections: Array[Section]
  def render: String
  def add(section: Section): SelectCollector
  def extend(added: Array[Section]): SelectCollector
  def args = sections.toSeq.map(_.args).flatten.toVector
  def statement = SqlWithParams(render, args)
}

case class StandardCollector[R](db: Conn,
                                shape: RowShape[R],
                                sections: Array[Section]) extends SelectCollector {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def render = sections.map(_.render).mkString(" ")
}

case class JoinCollector[R](db: Conn,
                            picker: Prefix,
                            shape: RowShape[R],
                            sections: Array[Section]) extends SelectCollector {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def render = sections.map(_.prefix(picker)).mkString(" ")
}























