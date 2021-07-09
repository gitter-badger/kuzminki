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

package kuzminki.column

import java.time.{Instant, LocalDate, LocalDateTime, ZonedDateTime}
import java.util.UUID
import io.rdbc.sapi.DecimalNumber



case class StringOptCol(underlying: AnyCol) extends StringOptColValue
                                               with OptColTransformMethods[String]


case class CharOptCol(underlying: AnyCol) extends CharOptColValue
                                             with OptColTransformMethods[Char]


case class BooleanOptCol(underlying: AnyCol) extends BooleanOptColValue
                                                with OptColTransformMethods[Boolean]


case class ShortOptCol(underlying: AnyCol) extends ShortOptColValue
                                              with OptColTransformMethods[Short]


case class IntOptCol(underlying: AnyCol) extends IntOptColValue
                                            with OptColTransformMethods[Int]


case class LongOptCol(underlying: AnyCol) extends LongOptColValue
                                             with OptColTransformMethods[Long]


case class FloatOptCol(underlying: AnyCol) extends FloatOptColValue
                                              with OptColTransformMethods[Float]


case class DoubleOptCol(underlying: AnyCol) extends DoubleOptColValue
                                               with OptColTransformMethods[Double]


case class NumericOptCol(underlying: AnyCol) extends NumericOptColValue
                                                with OptColTransformMethods[DecimalNumber]


case class BigDecimalOptCol(underlying: AnyCol) extends BigDecimalOptColValue
                                                   with OptColTransformMethods[BigDecimal]


case class InstantOptCol(underlying: AnyCol) extends InstantOptColValue
                                                with OptColTransformMethods[Instant]


case class ZonedDateTimeOptCol(underlying: AnyCol) extends ZonedDateTimeOptColValue
                                                      with OptColTransformMethods[ZonedDateTime]


case class LocalDateTimeOptCol(underlying: AnyCol) extends LocalDateTimeOptColValue
                                                      with OptColTransformMethods[LocalDateTime]


case class LocalDateOptCol(underlying: AnyCol) extends LocalDateOptColValue
                                                  with OptColTransformMethods[LocalDate]


case class UUIDOptCol(underlying: AnyCol) extends UUIDOptColValue
                                             with OptColTransformMethods[UUID]






