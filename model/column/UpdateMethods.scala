package kuzminki.model


trait UpdateMethod[T] {
  def real: RealCol
  def ==>(value: T) = SetValue(real, value)
}

trait NumericMethods[T] {
  def real: RealCol
  def ==>(value: T) = SetValue(real, value)
  def +=(value: T) = Increment(real, value)
  def -=(value: T) = Decrement(real, value)
}