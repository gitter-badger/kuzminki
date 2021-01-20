package kuzminki.model


trait SortingCol extends ColRef {
  def asc = Asc(col)
  def desc = Desc(col)
}