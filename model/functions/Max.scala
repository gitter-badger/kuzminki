package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggMax extends AggFunction {
  def name = "max"
  def template = "MAX(%s)"
}


case class MaxShort(col: Render) extends AggMax
                                    with ShortColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MaxInt(col: Render) extends AggMax
                                  with IntColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MaxLong(col: Render) extends AggMax
                                   with LongColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class MaxFloat(col: Render) extends AggMax
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class MaxDouble(col: Render) extends AggMax
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]



































