package kuzminki.model

import io.rdbc.sapi.DecimalNumber


case class AvgNumber(col: RenderableCol) extends AggNumeric
                                     with DecimalNumberColValue
                                     with UniversalFilters[Long]
                                     with ComparativeFilters[Long] {

  def template = "AVG(%s)"
}


case class AvgFloating(col: RenderableCol) extends AggNumeric
                                       with DoubleColValue
                                       with UniversalFilters[Double]
                                       with ComparativeFilters[Double] {

  def template = "AVG(%s)"
}


case class AvgCastShort(col: RenderableCol) extends AggNumeric
                                        with ShortColValue
                                        with UniversalFilters[Long]
                                        with ComparativeFilters[Long] {

  def template = "AVG(%s)::smallint"
}


case class AvgCastInt(col: RenderableCol) extends AggNumeric
                                      with IntColValue
                                      with UniversalFilters[Long]
                                      with ComparativeFilters[Long] {

  def template = "AVG(%s)::int"
}


case class AvgCastLong(col: RenderableCol) extends AggNumeric
                                       with DecimalNumberColValue
                                       with UniversalFilters[Long]
                                       with ComparativeFilters[Long] {

  def template = "AVG(%s)::bigint"
}


case class AvgCastFloat(col: RenderableCol) extends AggNumeric
                                        with DoubleColValue
                                        with UniversalFilters[Double]
                                        with ComparativeFilters[Double] {

  def template = "AVG(%s)::real"
}






































