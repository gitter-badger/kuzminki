package kuzminki.model


trait ShortAggregations extends Ref {
  def avgShort = AvgCastShort(ref)
  def avg = AvgNumber(ref)
  def sum = SumShort(ref)
  def max = MaxShort(ref)
  def min = MinShort(ref)
}

trait IntAggregations extends Ref {
  def avgInt = AvgCastInt(ref)
  def avg = AvgNumber(ref)
  def sum = SumInt(ref)
  def max = MaxInt(ref)
  def min = MinInt(ref)
}

trait LongAggregations extends Ref {
  def avgLong = AvgCastLong(ref)
  def avg = AvgNumber(ref)
  def sum = SumLong(ref)
  def max = MaxLong(ref)
  def min = MinLong(ref)
}

trait FloatAggregations extends Ref {
  def avgFloat = AvgCastFloat(ref)
  def avg = AvgFloating(ref)
  def sum = SumFloat(ref)
  def max = MaxFloat(ref)
  def min = MinFloat(ref)
}

trait DoubleAggregations extends Ref {
  def avg = AvgFloating(ref)
  def sum = SumDouble(ref)
  def max = MaxDouble(ref)
  def min = MinDouble(ref)
}