package kuzminki.model


case class InsertDataCollector(
      db: Conn,
      sections: Array[Section]
    ) extends CollectOperation {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)
}