package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggSum extends AggFunction {
  def template = "SUM(%s)"
}


case class SumShort(col: ShortCol) extends AggSum
                                      with LongColValue
                                      with UniversalFilters[Long]
                                      with ComparativeFilters[Long]


case class SumInt(col: IntCol) extends AggSum
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class SumLong(col: LongCol) extends AggSum
                                    with DecimalNumberColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class SumFloat(col: FloatCol) extends AggSum
                                      with FloatColValue
                                      with UniversalFilters[Double]
                                      with ComparativeFilters[Double]


case class SumDouble(col: DoubleCol) extends AggSum
                                        with DoubleColValue
                                        with UniversalFilters[Double]
                                        with ComparativeFilters[Double]



































