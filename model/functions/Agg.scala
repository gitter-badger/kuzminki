package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggFunction extends Render {
  def col: RealCol
  def template: String
  def render = template.format(col.render)
  def args = col.args
}


object Agg {  

  def sum(aggCol: AggCol): ModelCol = {
    aggCol match {
      case col: ShortCol => SumShort(col)
      case col: IntCol => SumInt(col)
      case col: LongCol => SumLong(col)
      case col: FloatCol => SumFloat(col)
      case col: DoubleCol => SumDouble(col)
    }
  }

  def avg(aggCol: AggCol): ModelCol = {
    aggCol match {
      case col: ShortCol => AvgShort(col)
      case col: IntCol => AvgInt(col)
      case col: LongCol => AvgLong(col)
      case col: FloatCol => AvgFloat(col)
      case col: DoubleCol => AvgDouble(col)
    }
  }

  def max(aggCol: AggCol): ModelCol = {
    aggCol match {
      case col: ShortCol => MaxShort(col)
      case col: IntCol => MaxInt(col)
      case col: LongCol => MaxLong(col)
      case col: FloatCol => MaxFloat(col)
      case col: DoubleCol => MaxDouble(col)
    }
  }

  def min(aggCol: AggCol): ModelCol = {
    aggCol match {
      case col: ShortCol => MinShort(col)
      case col: IntCol => MinInt(col)
      case col: LongCol => MinLong(col)
      case col: FloatCol => MinFloat(col)
      case col: DoubleCol => MinDouble(col)
    }
  }
}