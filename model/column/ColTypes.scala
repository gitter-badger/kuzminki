package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi._


case class StringCol(name: String, model: String) extends ModelCol
                                                    with StringColValue
                                                    with UpdateMethod[String]
                                                    with UniversalFilters[String]
                                                    with StringFilters


case class BooleanCol(name: String, model: String) extends ModelCol
                                                     with BooleanColValue
                                                     with UpdateMethod[Boolean]
                                                     with UniversalFilters[Boolean]


case class ShortCol(name: String, model: String) extends ModelCol
                                                   with ShortColValue
                                                   with ShortAggregations
                                                   with NumericMethods[Short]
                                                   with UniversalFilters[Int]
                                                   with ComparativeFilters[Short]


case class IntCol(name: String, model: String) extends ModelCol
                                                 with IntColValue
                                                 with IntAggregations
                                                 with SubqueryNumberFilters
                                                 with NumericMethods[Int]
                                                 with UniversalFilters[Int]
                                                 with ComparativeFilters[Int]


case class LongCol(name: String, model: String) extends ModelCol
                                                  with LongColValue
                                                  with LongAggregations
                                                  with NumericMethods[Long]
                                                  with UniversalFilters[Long]
                                                  with ComparativeFilters[Long]


case class FloatCol(name: String, model: String) extends ModelCol
                                                   with FloatColValue
                                                   with FloatAggregations
                                                   with NumericMethods[Float]
                                                   with UniversalFilters[Float]
                                                   with ComparativeFilters[Float]


case class DoubleCol(name: String, model: String) extends ModelCol
                                                    with DoubleColValue
                                                    with DoubleAggregations
                                                    with NumericMethods[Double]
                                                    with UniversalFilters[Double]
                                                    with ComparativeFilters[Double]


case class DecimalNumberCol(name: String, model: String) extends ModelCol
                                                           with DecimalNumberColValue
                                                           with NumericMethods[DecimalNumber]
                                                           with UniversalFilters[DecimalNumber]
                                                           with ComparativeFilters[DecimalNumber]


case class BigDecimalCol(name: String, model: String) extends ModelCol
                                                        with BigDecimalColValue
                                                        with NumericMethods[BigDecimal]
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