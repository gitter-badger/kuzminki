package kuzminki.model


trait ShortAggregations extends Ref {
  def sum = SumShort(ref)
  def avg = AvgShort(ref)
  def max = MaxShort(ref)
  def min = MinShort(ref)
}

trait IntAggregations extends Ref {
  def sum = SumInt(ref)
  def avg = AvgInt(ref)
  def max = MaxInt(ref)
  def min = MinInt(ref)
}

trait LongAggregations extends Ref {
  def sum = SumLong(ref)
  def avg = AvgLong(ref)
  def max = MaxLong(ref)
  def min = MinLong(ref)
}

trait FloatAggregations extends Ref {
  def sum = SumFloat(ref)
  def avg = AvgFloat(ref)
  def max = MaxFloat(ref)
  def min = MinFloat(ref)
}

trait DoubleAggregations extends Ref {
  def sum = SumDouble(ref)
  def avg = AvgDouble(ref)
  def max = MaxDouble(ref)
  def min = MinDouble(ref)
}