package kuzminki.model


trait UpdateMethod[T] extends ModelColRef {
  def ==>(value: T) = SetValue(col, value)
}

trait NumericMethods[T] extends ModelColRef {
  def ==>(value: T) = SetValue(col, value)
  def +=(value: T) = Increment(col, value)
  def -=(value: T) = Decrement(col, value)
}