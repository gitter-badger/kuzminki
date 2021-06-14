package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggSum extends AggNumeric {
  def template = "sum(%s)"
}


case class SumShort(col: AnyCol) extends AggSum
                                    with LongColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class SumInt(col: AnyCol) extends AggSum
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class SumLong(col: AnyCol) extends AggSum
                                   with DecimalNumberColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class SumFloat(col: AnyCol) extends AggSum
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class SumDouble(col: AnyCol) extends AggSum
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]



































