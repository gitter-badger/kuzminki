package kuzminki.model


case class OperationCollector(db: Conn, sections: Array[Section]) extends CollectOperation {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cache[P](paramShape: ParamShape[P]) = {
    new StoredOperation(render, args, paramShape.conv, db)
  }
}