package kuzminki.model


trait SubCollector {
  val sections: Array[Section]
  def render: String
  def add(section: Section): SubCollector
  def extend(added: Array[Section]): SubCollector
  def args = sections.toSeq.map(_.args).flatten.toVector
}

case class StandardSubCollector(sections: Array[Section]) extends SubCollector {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def render = sections.map(_.render).mkString(" ")
}

case class JoinSubCollector(picker: Prefix, sections: Array[Section]) extends SubCollector {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def render = sections.map(_.prefix(picker)).mkString(" ")
}

















