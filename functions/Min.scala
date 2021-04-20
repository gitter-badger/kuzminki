package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggMin extends AggNumeric {
  def template = "MIN(%s)"
}


case class MinShort(col: AnyCol) extends AggMin
                                    with ShortColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MinInt(col: AnyCol) extends AggMin
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MinLong(col: AnyCol) extends AggMin
                                   with LongColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class MinFloat(col: AnyCol) extends AggMin
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class MinDouble(col: AnyCol) extends AggMin
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]