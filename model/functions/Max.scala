package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggMax extends AggNumeric {
  def name = "max"
  def template = "MAX(%s)"
}


case class MaxShort(col: RenderableCol) extends AggMax
                                    with ShortColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MaxInt(col: RenderableCol) extends AggMax
                                  with IntColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MaxLong(col: RenderableCol) extends AggMax
                                   with LongColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class MaxFloat(col: RenderableCol) extends AggMax
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class MaxDouble(col: RenderableCol) extends AggMax
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]



































