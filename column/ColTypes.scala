/*
* Copyright 2021 Kári Magnússon
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi._


case class StringCol(info: ColInfo) extends ModelCol
                                       with StringColValue
                                       with UpdateMethod[String]
                                       with UniversalFilters[String]
                                       with StringFilters {

  def opt = StringOptCol(info)
}


case class CharCol(info: ColInfo) extends ModelCol
                                     with CharColValue
                                     with UpdateMethod[Char]
                                     with UniversalFilters[Char] {

  def opt = CharOptCol(info)
}


case class BooleanCol(info: ColInfo) extends ModelCol
                                        with BooleanColValue
                                        with UpdateMethod[Boolean]
                                        with UniversalFilters[Boolean] {

  def opt = BooleanOptCol(info)
}


case class ShortCol(info: ColInfo) extends ModelCol
                                      with ShortColValue
                                      with ShortAggregations
                                      with NumericUpdateMethods[Short]
                                      with UniversalFilters[Int]
                                      with ComparativeFilters[Short] {

  def opt = ShortOptCol(info)
}


case class IntCol(info: ColInfo) extends ModelCol
                                    with IntColValue
                                    with IntAggregations
                                    with SubqueryNumberFilters
                                    with NumericUpdateMethods[Int]
                                    with UniversalFilters[Int]
                                    with ComparativeFilters[Int] {

  def opt = IntOptCol(info)
}


case class LongCol(info: ColInfo) extends ModelCol
                                     with LongColValue
                                     with LongAggregations
                                     with NumericUpdateMethods[Long]
                                     with UniversalFilters[Long]
                                     with ComparativeFilters[Long] {

  def opt = LongOptCol(info)
}


case class FloatCol(info: ColInfo) extends ModelCol
                                      with FloatColValue
                                      with FloatAggregations
                                      with NumericUpdateMethods[Float]
                                      with UniversalFilters[Float]
                                      with ComparativeFilters[Float] {

  def opt = FloatOptCol(info)
}


case class DoubleCol(info: ColInfo) extends ModelCol
                                       with DoubleColValue
                                       with DoubleAggregations
                                       with NumericUpdateMethods[Double]
                                       with UniversalFilters[Double]
                                       with ComparativeFilters[Double] {

  def opt = DoubleOptCol(info)
}


case class DecimalNumberCol(info: ColInfo) extends ModelCol
                                              with DecimalNumberColValue
                                              with NumericUpdateMethods[DecimalNumber]
                                              with UniversalFilters[DecimalNumber]
                                              with ComparativeFilters[DecimalNumber] {

  def opt = DecimalNumberOptCol(info)
}


case class BigDecimalCol(info: ColInfo) extends ModelCol
                                           with BigDecimalColValue
                                           with NumericUpdateMethods[BigDecimal]
                                           with UniversalFilters[BigDecimal]
                                           with ComparativeFilters[BigDecimal] {

  def opt = BigDecimalOptCol(info)
}


case class InstantCol(info: ColInfo) extends ModelCol
                                        with InstantColValue
                                        with UniversalFilters[Instant]
                                        with ComparativeFilters[Instant] {

  def opt = InstantOptCol(info)
}


case class ZonedDateTimeCol(info: ColInfo) extends ModelCol
                                              with ZonedDateTimeColValue
                                              with UniversalFilters[ZonedDateTime]
                                              with ComparativeFilters[ZonedDateTime] {

  def opt = ZonedDateTimeOptCol(info)
}


case class LocalDateTimeCol(info: ColInfo) extends ModelCol
                                              with LocalDateTimeColValue
                                              with UniversalFilters[LocalDateTime]
                                              with ComparativeFilters[LocalDateTime] {

  def opt = LocalDateTimeOptCol(info)
}


case class LocalDateCol(info: ColInfo) extends ModelCol
                                          with LocalDateColValue
                                          with UniversalFilters[LocalDate]
                                          with ComparativeFilters[LocalDate] {

  def opt = LocalDateOptCol(info)
}


case class UUIDCol(info: ColInfo) extends ModelCol
                                     with UUIDColValue
                                     with UniversalFilters[UUID]
                                     with ComparativeFilters[UUID] {

  def opt = UUIDOptCol(info)
}

// option

case class StringOptCol(info: ColInfo) extends ModelCol
                                          with StringOptColValue
                                          with NullUpdateMethod[String]
                                          with UniversalFilters[String]
                                          with StringFilters {

  def unOpt = StringCol(info)
}


case class CharOptCol(info: ColInfo) extends ModelCol
                                        with CharOptColValue
                                        with NullUpdateMethod[Char]
                                        with UniversalFilters[Char] {

  def unOpt = CharCol(info)
}


case class BooleanOptCol(info: ColInfo) extends ModelCol
                                           with BooleanOptColValue
                                           with NullUpdateMethod[Boolean]
                                           with UniversalFilters[Boolean] {

  def unOpt = BooleanCol(info)
}


case class ShortOptCol(info: ColInfo) extends ModelCol
                                         with ShortOptColValue
                                         with ShortAggregations
                                         with NullNumericUpdateMethods[Short]
                                         with UniversalFilters[Short]
                                         with ComparativeFilters[Short] {

  def unOpt = ShortCol(info)
}


case class IntOptCol(info: ColInfo) extends ModelCol
                                       with IntOptColValue
                                       with IntAggregations
                                       with SubqueryNumberFilters
                                       with NullNumericUpdateMethods[Int]
                                       with UniversalFilters[Int]
                                       with ComparativeFilters[Int] {

  def unOpt = IntCol(info)
}


case class LongOptCol(info: ColInfo) extends ModelCol
                                        with LongOptColValue
                                        with LongAggregations
                                        with NullNumericUpdateMethods[Long]
                                        with UniversalFilters[Long]
                                        with ComparativeFilters[Long] {

  def unOpt = LongCol(info)
}


case class FloatOptCol(info: ColInfo) extends ModelCol
                                         with FloatOptColValue
                                         with FloatAggregations
                                         with NullNumericUpdateMethods[Float]
                                         with UniversalFilters[Float]
                                         with ComparativeFilters[Float] {

  def unOpt = FloatCol(info)
}


case class DoubleOptCol(info: ColInfo) extends ModelCol
                                          with DoubleOptColValue
                                          with DoubleAggregations
                                          with NullNumericUpdateMethods[Double]
                                          with UniversalFilters[Double]
                                          with ComparativeFilters[Double] {

  def unOpt = DoubleCol(info)
}


case class DecimalNumberOptCol(info: ColInfo) extends ModelCol
                                                 with DecimalNumberOptColValue
                                                 with NullNumericUpdateMethods[DecimalNumber]
                                                 with UniversalFilters[DecimalNumber]
                                                 with ComparativeFilters[DecimalNumber] {

  def unOpt = DecimalNumberCol(info)
}


case class BigDecimalOptCol(info: ColInfo) extends ModelCol
                                              with BigDecimalOptColValue
                                              with NullNumericUpdateMethods[BigDecimal]
                                              with UniversalFilters[BigDecimal]
                                              with ComparativeFilters[BigDecimal] {

  def unOpt = BigDecimalCol(info)
}


case class InstantOptCol(info: ColInfo) extends ModelCol
                                           with InstantOptColValue
                                           with NullUpdateMethod[Boolean]
                                           with UniversalFilters[Instant]
                                           with ComparativeFilters[Instant] {

  def unOpt = BigDecimalCol(info)
}


case class ZonedDateTimeOptCol(info: ColInfo) extends ModelCol
                                                 with ZonedDateTimeOptColValue
                                                 with NullUpdateMethod[Boolean]
                                                 with UniversalFilters[ZonedDateTime]
                                                 with ComparativeFilters[ZonedDateTime] {

  def unOpt = ZonedDateTimeCol(info)
}


case class LocalDateTimeOptCol(info: ColInfo) extends ModelCol
                                                 with LocalDateTimeOptColValue
                                                 with NullUpdateMethod[Boolean]
                                                 with UniversalFilters[LocalDateTime]
                                                 with ComparativeFilters[LocalDateTime] {

  def unOpt = LocalDateTimeCol(info)
}


case class LocalDateOptCol(info: ColInfo) extends ModelCol
                                             with LocalDateOptColValue
                                             with NullUpdateMethod[Boolean]
                                             with UniversalFilters[LocalDate]
                                             with ComparativeFilters[LocalDate] {

  def unOpt = LocalDateCol(info)
}


case class UUIDOptCol(info: ColInfo) extends ModelCol
                                        with UUIDOptColValue
                                        with NullUpdateMethod[Boolean]
                                        with UniversalFilters[UUID]
                                        with ComparativeFilters[UUID] {

  def unOpt = UUIDCol(info)
}
























