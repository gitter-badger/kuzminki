package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggMax extends ColFunction {
  def name = "max"
  def template = "MAX(%s)"
}


case class MaxShort(col: ShortCol) extends AggMax
                                      with ShortColValue
                                      with UniversalFilters[Long]
                                      with ComparativeFilters[Long]


case class MaxInt(col: IntCol) extends AggMax
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MaxLong(col: LongCol) extends AggMax
                                    with LongColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MaxFloat(col: FloatCol) extends AggMax
                                      with FloatColValue
                                      with UniversalFilters[Double]
                                      with ComparativeFilters[Double]


case class MaxDouble(col: DoubleCol) extends AggMax
                                        with DoubleColValue
                                        with UniversalFilters[Double]
                                        with ComparativeFilters[Double]



































