package kuzminki.model


case class SubCollector(prefix: Prefix, sections: Array[Section]) {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def render = sections.map(_.render(prefix)).mkString(" ")

  def args = sections.toSeq.map(_.args).flatten.toVector
}

















