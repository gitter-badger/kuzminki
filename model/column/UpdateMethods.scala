package kuzminki.model


trait UpdateMethod[T] {
  val modelCol: ModelCol
  def ==>(value: T) = SetValue(modelCol, value)
}

trait NumericUpdateMethods[T] {
  val modelCol: ModelCol
  def ==>(value: T) = SetValue(modelCol, value)
  def +=(value: T) = Increment(modelCol, value)
  def -=(value: T) = Decrement(modelCol, value)
}