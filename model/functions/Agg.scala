package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggFunction extends ModelCol

trait ColFunction extends AggFunction {
  def col: RealCol
  def name: String
  def template: String
  def render = template.format(col.render)
  def args = col.args
}


object Agg {

  def count(col: RealCol) = Count(col) 

  def sum(aggCol: RealCol): ModelCol = {
    aggCol match {
      case col: ShortCol => SumShort(col)
      case col: IntCol => SumInt(col)
      case col: LongCol => SumLong(col)
      case col: FloatCol => SumFloat(col)
      case col: DoubleCol => SumDouble(col)
    }
  }

  def avg(aggCol: RealCol): ModelCol = {
    aggCol match {
      case col: ShortCol => AvgShort(col)
      case col: IntCol => AvgInt(col)
      case col: LongCol => AvgLong(col)
      case col: FloatCol => AvgFloat(col)
      case col: DoubleCol => AvgDouble(col)
    }
  }

  def max(aggCol: RealCol): ModelCol = {
    aggCol match {
      case col: ShortCol => MaxShort(col)
      case col: IntCol => MaxInt(col)
      case col: LongCol => MaxLong(col)
      case col: FloatCol => MaxFloat(col)
      case col: DoubleCol => MaxDouble(col)
    }
  }

  def min(aggCol: RealCol): ModelCol = {
    aggCol match {
      case col: ShortCol => MinShort(col)
      case col: IntCol => MinInt(col)
      case col: LongCol => MinLong(col)
      case col: FloatCol => MinFloat(col)
      case col: DoubleCol => MinDouble(col)
    }
  }
}