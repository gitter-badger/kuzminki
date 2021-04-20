package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggMax extends AggNumeric {
  def template = "MAX(%s)"
}


case class MaxShort(col: AnyCol) extends AggMax
                                    with ShortColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MaxInt(col: AnyCol) extends AggMax
                                  with IntColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MaxLong(col: AnyCol) extends AggMax
                                   with LongColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class MaxFloat(col: AnyCol) extends AggMax
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class MaxDouble(col: AnyCol) extends AggMax
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]



































