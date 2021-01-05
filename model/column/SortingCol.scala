package kuzminki.model


trait SortingCol {
  def ref: Render
  def asc = Asc(ref)
  def desc = Desc(ref)
}