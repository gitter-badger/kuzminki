package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggAvg extends AggFunction {
  def name = "avg"
  def template = "AVG(%s)"
}


case class AvgShort(col: ShortCol) extends AggAvg
                                      with ShortColValue
                                      with UniversalFilters[Long]
                                      with ComparativeFilters[Long]


case class AvgInt(col: IntCol) extends AggAvg
                                  with IntColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class AvgLong(col: LongCol) extends AggAvg
                                    with LongColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class AvgFloat(col: FloatCol) extends AggAvg
                                      with FloatColValue
                                      with UniversalFilters[Double]
                                      with ComparativeFilters[Double]


case class AvgDouble(col: DoubleCol) extends AggAvg
                                        with DoubleColValue
                                        with UniversalFilters[Double]
                                        with ComparativeFilters[Double]



































