package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi._


case class StringCol(info: ColInfo) extends ModelCol
                                       with StringColValue
                                       with UpdateMethod[String]
                                       with UniversalFilters[String]
                                       with StringFilters


case class CharCol(info: ColInfo) extends ModelCol
                                     with CharColValue
                                     with UpdateMethod[Char]
                                     with UniversalFilters[Char]


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


case class InstantCol(info: ColInfo) extends ModelCol
                                        with InstantColValue
                                        with UniversalFilters[Instant]
                                        with ComparativeFilters[Instant]


case class ZonedDateTimeCol(info: ColInfo) extends ModelCol
                                              with ZonedDateTimeColValue
                                              with UniversalFilters[ZonedDateTime]
                                              with ComparativeFilters[ZonedDateTime]


case class LocalDateTimeCol(info: ColInfo) extends ModelCol
                                              with LocalDateTimeColValue
                                              with UniversalFilters[LocalDateTime]
                                              with ComparativeFilters[LocalDateTime]


case class LocalDateCol(info: ColInfo) extends ModelCol
                                          with LocalDateColValue
                                          with UniversalFilters[LocalDate]
                                          with ComparativeFilters[LocalDate]


case class UUIDCol(info: ColInfo) extends ModelCol
                                     with UUIDColValue
                                     with UniversalFilters[UUID]
                                     with ComparativeFilters[UUID]


















