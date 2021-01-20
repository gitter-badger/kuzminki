package kuzminki.model


trait ShortAggregations extends ColRef {
  def avgShort = AvgCastShort(col)
  def avg = AvgNumber(col)
  def sum = SumShort(col)
  def max = MaxShort(col)
  def min = MinShort(col)
}

trait IntAggregations extends ColRef {
  def avgInt = AvgCastInt(col)
  def avg = AvgNumber(col)
  def sum = SumInt(col)
  def max = MaxInt(col)
  def min = MinInt(col)
}

trait LongAggregations extends ColRef {
  def avgLong = AvgCastLong(col)
  def avg = AvgNumber(col)
  def sum = SumLong(col)
  def max = MaxLong(col)
  def min = MinLong(col)
}

trait FloatAggregations extends ColRef {
  def avgFloat = AvgCastFloat(col)
  def avg = AvgFloating(col)
  def sum = SumFloat(col)
  def max = MaxFloat(col)
  def min = MinFloat(col)
}

trait DoubleAggregations extends ColRef {
  def avg = AvgFloating(col)
  def sum = SumDouble(col)
  def max = MaxDouble(col)
  def min = MinDouble(col)
}