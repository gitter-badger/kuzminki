package kuzminki.model


case class SetUpsert(col: ModelCol) extends Renderable with NoArgs {
  def render(prefix: Prefix) = s"${col.name} = ?"
}



