package kuzminki.model

import io.rdbc.sapi.DecimalNumber


case class AvgNumber(col: AnyCol) extends AggNumeric
                                     with DecimalNumberColValue
                                     with UniversalFilters[Long]
                                     with ComparativeFilters[Long] {

  def template = "avg(%s)"
}


case class AvgFloating(col: AnyCol) extends AggNumeric
                                       with DoubleColValue
                                       with UniversalFilters[Double]
                                       with ComparativeFilters[Double] {

  def template = "avg(%s)"
}


case class AvgCastShort(col: AnyCol) extends AggNumeric
                                        with ShortColValue
                                        with UniversalFilters[Long]
                                        with ComparativeFilters[Long] {

  def template = "avg(%s)::smallint"
}


case class AvgCastInt(col: AnyCol) extends AggNumeric
                                      with IntColValue
                                      with UniversalFilters[Long]
                                      with ComparativeFilters[Long] {

  def template = "avg(%s)::int"
}


case class AvgCastLong(col: AnyCol) extends AggNumeric
                                       with DecimalNumberColValue
                                       with UniversalFilters[Long]
                                       with ComparativeFilters[Long] {

  def template = "avg(%s)::bigint"
}


case class AvgCastFloat(col: AnyCol) extends AggNumeric
                                        with DoubleColValue
                                        with UniversalFilters[Double]
                                        with ComparativeFilters[Double] {

  def template = "avg(%s)::real"
}






































