package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggMin extends AggNumeric {
  def template = "MIN(%s)"
}


case class MinShort(col: RenderableCol) extends AggMin
                                    with ShortColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MinInt(col: RenderableCol) extends AggMin
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MinLong(col: RenderableCol) extends AggMin
                                   with LongColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class MinFloat(col: RenderableCol) extends AggMin
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class MinDouble(col: RenderableCol) extends AggMin
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]