package kuzminki.model


trait AggNumeric extends Renderable with SortingCol {
  def col: RealCol
  def name: String
  def template: String
  def render = template.format(col.render)
  def prefix(picker: Prefix) = template.format(col.prefix(picker))
  def args = col.args
}