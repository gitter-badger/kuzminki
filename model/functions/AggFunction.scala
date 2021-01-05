package kuzminki.model


trait AggFunction extends ModelCol with SortingCol {
  def col: Render
  def name: String
  def template: String
  def render = template.format(col.render)
  def args = col.args
}