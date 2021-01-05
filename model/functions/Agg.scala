package kuzminki.model

import io.rdbc.sapi.DecimalNumber


object Agg {

  def count(col: RealCol) = Count(col) 

  def sum(col: ShortCol) = SumShort(col)
  def sum(col: IntCol) = SumInt(col)
  def sum(col: LongCol) = SumLong(col)
  def sum(col: FloatCol) = SumFloat(col)
  def sum(col: DoubleCol) = SumDouble(col)

  def avg(col: ShortCol) = AvgShort(col)
  def avg(col: IntCol) = AvgInt(col)
  def avg(col: LongCol) = AvgLong(col)
  def avg(col: FloatCol) = AvgFloat(col)
  def avg(col: DoubleCol) = AvgDouble(col)

  def max(col: ShortCol) = MaxShort(col)
  def max(col: IntCol) = MaxInt(col)
  def max(col: LongCol) = MaxLong(col)
  def max(col: FloatCol) = MaxFloat(col)
  def max(col: DoubleCol) = MaxDouble(col)

  def min(col: ShortCol) = MinShort(col)
  def min(col: IntCol) = MinInt(col)
  def min(col: LongCol) = MinLong(col)
  def min(col: FloatCol) = MinFloat(col)
  def min(col: DoubleCol) = MinDouble(col)
}