package kuzminki.model


trait ShortAggregations extends SelfRef {
  def avgShort = AvgCastShort(self)
  def avg = AvgNumber(self)
  def sum = SumShort(self)
  def max = MaxShort(self)
  def min = MinShort(self)
}

trait IntAggregations extends SelfRef {
  def avgInt = AvgCastInt(self)
  def avg = AvgNumber(self)
  def sum = SumInt(self)
  def max = MaxInt(self)
  def min = MinInt(self)
}

trait LongAggregations extends SelfRef {
  def avgLong = AvgCastLong(self)
  def avg = AvgNumber(self)
  def sum = SumLong(self)
  def max = MaxLong(self)
  def min = MinLong(self)
}

trait FloatAggregations extends SelfRef {
  def avgFloat = AvgCastFloat(self)
  def avg = AvgFloating(self)
  def sum = SumFloat(self)
  def max = MaxFloat(self)
  def min = MinFloat(self)
}

trait DoubleAggregations extends SelfRef {
  def avg = AvgFloating(self)
  def sum = SumDouble(self)
  def max = MaxDouble(self)
  def min = MinDouble(self)
}