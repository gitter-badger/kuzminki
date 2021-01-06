package kuzminki.model


trait AggNumeric extends ModelCol with SortingCol {
  def col: Render
  def name: String
  def template: String
  def render = template.format(col.render)
  def args = col.args
}