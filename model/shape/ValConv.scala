package kuzminki.model


trait ValConv[T] {
  def get(row: Row, index: Int): T
}




