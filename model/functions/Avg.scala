package kuzminki.model

import io.rdbc.sapi.DecimalNumber


case class AvgNumber(col: Render) extends AggNumeric
                                     with DecimalNumberColValue
                                     with UniversalFilters[Long]
                                     with ComparativeFilters[Long] {

  def name = "avg"
  def template = "AVG(%s)"
}


case class AvgFloating(col: Render) extends AggNumeric
                                       with DoubleColValue
                                       with UniversalFilters[Double]
                                       with ComparativeFilters[Double] {

  def name = "avg"
  def template = "AVG(%s)"
}


case class AvgCastShort(col: Render) extends AggNumeric
                                        with ShortColValue
                                        with UniversalFilters[Long]
                                        with ComparativeFilters[Long] {

  def name = "avg"
  def template = "AVG(%s)::smallint"
}


case class AvgCastInt(col: Render) extends AggNumeric
                                      with IntColValue
                                      with UniversalFilters[Long]
                                      with ComparativeFilters[Long] {

  def name = "avg"
  def template = "AVG(%s)::int"
}


case class AvgCastLong(col: Render) extends AggNumeric
                                       with DecimalNumberColValue
                                       with UniversalFilters[Long]
                                       with ComparativeFilters[Long] {

  def name = "avg"
  def template = "AVG(%s)::bigint"
}


case class AvgCastFloat(col: Render) extends AggNumeric
                                        with DoubleColValue
                                        with UniversalFilters[Double]
                                        with ComparativeFilters[Double] {

  def name = "avg"
  def template = "AVG(%s)::real"
}






































