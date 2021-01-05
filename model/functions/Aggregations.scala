package kuzminki.model


trait IntAggregations extends Ref {
  def max = MaxInt(ref)
  def min = MinInt(ref)
}