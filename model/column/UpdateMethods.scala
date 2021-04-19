package kuzminki.model


trait UpdateMethod[T] {
  val col: ModelCol
  def ==>(value: T) = SetValue(col, value)
}

trait NumericUpdateMethods[T] {
  val col: ModelCol
  def ==>(value: T) = SetValue(col, value)
  def +=(value: T) = Increment(col, value)
  def -=(value: T) = Decrement(col, value)
}