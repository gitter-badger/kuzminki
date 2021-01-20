package kuzminki.model


class SingleNumberSubquery(coll: SubCollector) extends Renderable {
  def render = coll.render
  def prefix(picker: Prefix) = coll.render
  def args = coll.args
}



