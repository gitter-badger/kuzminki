package kuzminki.model


trait IntAggregations extends Underlying {
  def max = MaxInt(ref)
  def min = MinInt(ref)
}