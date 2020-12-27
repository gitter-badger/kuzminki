package kuzminki.model


case class Join[A <: Model, B <: Model](a: A, b: B) {
  a.__prefix = Some("a")
  b.__prefix = Some("b")
  def left = a
  def right = b
}