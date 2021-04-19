package kuzminki.model


trait SortingDirection extends SelfRef {
  def asc = Asc(self)
  def desc = Desc(self)
}