package kuzminki.model


trait SortingDirection extends ColRef {
  def asc = Asc(col)
  def desc = Desc(col)
}