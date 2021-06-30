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


case class StringModelCol(info: ColInfo) extends ModelCol
                                            with StringCol
                                            with UpdateMethods[String]


case class CharModelCol(info: ColInfo) extends ModelCol
                                          with CharCol
                                          with UpdateMethods[Char]


case class BooleanModelCol(info: ColInfo) extends ModelCol
                                             with BooleanCol
                                             with UpdateMethods[Boolean]


case class ShortModelCol(info: ColInfo) extends ModelCol
                                           with ShortCol
                                           with NumericUpdateMethods[Short]


case class IntModelCol(info: ColInfo) extends ModelCol
                                         with IntCol
                                         with NumericUpdateMethods[Int]


case class LongModelCol(info: ColInfo) extends ModelCol
                                          with LongCol
                                          with NumericUpdateMethods[Long]


case class FloatModelCol(info: ColInfo) extends ModelCol
                                           with FloatCol
                                           with NumericUpdateMethods[Float]


case class DoubleModelCol(info: ColInfo) extends ModelCol
                                            with DoubleCol
                                            with NumericUpdateMethods[Double]


case class NumericModelCol(info: ColInfo) extends ModelCol
                                             with NumericCol
                                             with NumericUpdateMethods[DecimalNumber]


case class BigDecimalModelCol(info: ColInfo) extends ModelCol
                                                with BigDecimalCol
                                                with NumericUpdateMethods[BigDecimal]


case class InstantModelCol(info: ColInfo) extends ModelCol
                                             with InstantCol
                                             with UpdateMethods[Instant]


case class ZonedDateTimeModelCol(info: ColInfo) extends ModelCol
                                                   with ZonedDateTimeCol
                                                   with UpdateMethods[ZonedDateTime]


case class LocalDateTimeModelCol(info: ColInfo) extends ModelCol
                                                   with LocalDateTimeCol
                                                   with UpdateMethods[LocalDateTime]


case class LocalDateModelCol(info: ColInfo) extends ModelCol
                                               with LocalDateCol
                                               with UpdateMethods[LocalDate]


case class UUIDModelCol(info: ColInfo) extends ModelCol
                                          with UUIDCol
                                          with UpdateMethods[UUID]

// option


























