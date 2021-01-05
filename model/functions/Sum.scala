package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggSum extends AggFunction {
  def name = "sum"
  def template = "SUM(%s)"
}


case class SumShort(col: Render) extends AggSum
                                    with LongColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class SumInt(col: Render) extends AggSum
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class SumLong(col: Render) extends AggSum
                                   with DecimalNumberColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class SumFloat(col: Render) extends AggSum
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class SumDouble(col: Render) extends AggSum
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]



































