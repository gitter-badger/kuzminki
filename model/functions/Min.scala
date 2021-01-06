package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggMin extends AggNumeric {
  def name = "min"
  def template = "MIN(%s)"
}


case class MinShort(col: Render) extends AggMin
                                    with ShortColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MinInt(col: Render) extends AggMin
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MinLong(col: Render) extends AggMin
                                   with LongColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class MinFloat(col: Render) extends AggMin
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class MinDouble(col: Render) extends AggMin
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]