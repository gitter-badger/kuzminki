package kuzminki.model


trait SortingCol extends ModelColRef {
  def asc = Asc(col)
  def desc = Desc(col)
}