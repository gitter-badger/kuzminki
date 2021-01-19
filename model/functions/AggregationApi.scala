package kuzminki.model


trait ShortAggregations extends ModelColRef {
  def avgShort = AvgCastShort(col)
  def avg = AvgNumber(col)
  def sum = SumShort(col)
  def max = MaxShort(col)
  def min = MinShort(col)
}

trait IntAggregations extends ModelColRef {
  def avgInt = AvgCastInt(col)
  def avg = AvgNumber(col)
  def sum = SumInt(col)
  def max = MaxInt(col)
  def min = MinInt(col)
}

trait LongAggregations extends ModelColRef {
  def avgLong = AvgCastLong(col)
  def avg = AvgNumber(col)
  def sum = SumLong(col)
  def max = MaxLong(col)
  def min = MinLong(col)
}

trait FloatAggregations extends ModelColRef {
  def avgFloat = AvgCastFloat(col)
  def avg = AvgFloating(col)
  def sum = SumFloat(col)
  def max = MaxFloat(col)
  def min = MinFloat(col)
}

trait DoubleAggregations extends ModelColRef {
  def avg = AvgFloating(col)
  def sum = SumDouble(col)
  def max = MaxDouble(col)
  def min = MinDouble(col)
}