package kuzminki.model

import io.rdbc.sapi.DecimalNumber


trait AggSum extends AggNumeric {
  def template = "SUM(%s)"
}


case class SumShort(col: RenderableCol) extends AggSum
                                    with LongColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class SumInt(col: RenderableCol) extends AggSum
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class SumLong(col: RenderableCol) extends AggSum
                                   with DecimalNumberColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class SumFloat(col: RenderableCol) extends AggSum
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class SumDouble(col: RenderableCol) extends AggSum
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]



































