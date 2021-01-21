package kuzminki.model


class SingleNumberSubquery(coll: SubCollector) extends Renderable {
  def render(prefix: Prefix) = coll.render
  def args = coll.args
}



