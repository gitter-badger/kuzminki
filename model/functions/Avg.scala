package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggAvg extends AggFunction {
  def name = "avg"
  def template = "AVG(%s)"
}


case class AvgShort(col: Render) extends AggAvg
                                    with DecimalNumberColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class AvgInt(col: Render) extends AggAvg
                                  with DecimalNumberColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class AvgLong(col: Render) extends AggAvg
                                   with DecimalNumberColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class AvgFloat(col: Render) extends AggAvg
                                    with DoubleColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class AvgDouble(col: Render) extends AggAvg
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]



































