package kuzminki


sealed trait TableRef extends Renderable with Wrap {
  def args = Seq.empty[Any]
}

case class TableName(name: String) extends TableRef {
  def render = name
  def wrap = safe(name)
  def alias(alias: String) = TableNameAlias(name, alias)
}

case class TableNameAlias(name: String, alias: String) extends TableRef {
  def render = s"$name $alias"
  def wrap = "%s %s".format(safe(name), safe(alias))
}