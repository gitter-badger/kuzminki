package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi._


case class StringCol(info: ColInfo) extends ModelCol
                                      with StringColValue
                                      with UpdateMethod[String]
                                      with UniversalFilters[String]
                                      with StringFilters


case class BooleanCol(info: ColInfo) extends ModelCol
                                       with BooleanColValue
                                       with UpdateMethod[Boolean]
                                       with UniversalFilters[Boolean]


case class ShortCol(info: ColInfo) extends ModelCol
                                     with ShortColValue
                                     with ShortAggregations
                                     with NumericUpdateMethods[Short]
                                     with UniversalFilters[Int]
                                     with ComparativeFilters[Short]


case class IntCol(info: ColInfo) extends ModelCol
                                   with IntColValue
                                   with IntAggregations
                                   with SubqueryNumberFilters
                                   with NumericUpdateMethods[Int]
                                   with UniversalFilters[Int]
                                   with ComparativeFilters[Int]


case class LongCol(info: ColInfo) extends ModelCol
                                    with LongColValue
                                    with LongAggregations
                                    with NumericUpdateMethods[Long]
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class FloatCol(info: ColInfo) extends ModelCol
                                     with FloatColValue
                                     with FloatAggregations
                                     with NumericUpdateMethods[Float]
                                     with UniversalFilters[Float]
                                     with ComparativeFilters[Float]


case class DoubleCol(info: ColInfo) extends ModelCol
                                      with DoubleColValue
                                      with DoubleAggregations
                                      with NumericUpdateMethods[Double]
                                      with UniversalFilters[Double]
                                      with ComparativeFilters[Double]


case class DecimalNumberCol(info: ColInfo) extends ModelCol
                                             with DecimalNumberColValue
                                             with NumericUpdateMethods[DecimalNumber]
                                             with UniversalFilters[DecimalNumber]
                                             with ComparativeFilters[DecimalNumber]


case class BigDecimalCol(info: ColInfo) extends ModelCol
                                          with BigDecimalColValue
                                          with NumericUpdateMethods[BigDecimal]
                                          with UniversalFilters[BigDecimal]
                                          with ComparativeFilters[BigDecimal]

/*
case class CharCol(name: String, model: String) extends ModelCol
                                                  with TypeCol[Char]
                                                  with UniversalFilters[Char] {

  def get(row: Row): Char = row.char(name)
}


case class InstantCol(name: String, model: String) extends ModelCol
                                                     with TypeCol[Instant]
                                                     with UniversalFilters[Instant] {

  def get(row: Row): Instant = row.instant(name)
}


case class ZonedDateTimeCol(name: String, model: String) extends ModelCol
                                                           with TypeCol[ZonedDateTime]
                                                           with UniversalFilters[ZonedDateTime]
                                                           with ComparativeFilters[ZonedDateTime] {

  def get(row: Row): ZonedDateTime = row.zonedDateTime(name)
}


case class LocalDateTimeCol(name: String, model: String) extends ModelCol
                                                           with TypeCol[LocalDateTime]
                                                           with UniversalFilters[LocalDateTime]
                                                           with ComparativeFilters[LocalDateTime] {

  def get(row: Row): LocalDateTime = row.localDateTime(name)
}


case class LocalDateCol(name: String, model: String) extends ModelCol
                                                       with TypeCol[LocalDate]
                                                       with UniversalFilters[LocalDate]
                                                       with ComparativeFilters[LocalDate] {

  def get(row: Row): LocalDate = row.localDate(name)
}


case class UUIDCol(name: String, model: String) extends ModelCol
                                                  with TypeCol[UUID]
                                                  with UniversalFilters[UUID]
                                                  with ComparativeFilters[UUID] {

  def get(row: Row): UUID = row.uuid(name)
}
*/