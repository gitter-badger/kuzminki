package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggMin extends AggFunction {
  def template = "MIN(%s)"
}


case class MinShort(col: ShortCol) extends AggMin
                                      with ShortColValue
                                      with UniversalFilters[Long]
                                      with ComparativeFilters[Long]


case class MinInt(col: IntCol) extends AggMin
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MinLong(col: LongCol) extends AggMin
                                    with LongColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MinFloat(col: FloatCol) extends AggMin
                                      with FloatColValue
                                      with UniversalFilters[Double]
                                      with ComparativeFilters[Double]


case class MinDouble(col: DoubleCol) extends AggMin
                                        with DoubleColValue
                                        with UniversalFilters[Double]
                                        with ComparativeFilters[Double]