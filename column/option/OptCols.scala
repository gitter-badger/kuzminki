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



case class StringOptCol(col: AnyCol) extends StringOptColValue
                                        with OptColMethods[String]


case class CharOptCol(col: AnyCol) extends CharOptColValue
                                      with OptColMethods[Char]


case class BooleanOptCol(col: AnyCol) extends BooleanOptColValue
                                         with OptColMethods[Boolean]


case class ShortOptCol(col: AnyCol) extends ShortOptColValue
                                       with OptColMethods[Short]


case class IntOptCol(col: AnyCol) extends IntOptColValue
                                     with OptColMethods[Int]


case class LongOptCol(col: AnyCol) extends LongOptColValue
                                      with OptColMethods[Long]


case class FloatOptCol(col: AnyCol) extends FloatOptColValue
                                       with OptColMethods[Float]


case class DoubleOptCol(col: AnyCol) extends DoubleOptColValue
                                        with OptColMethods[Double]


case class DecimalNumberOptCol(col: AnyCol) extends DecimalNumberOptColValue
                                               with OptColMethods[DecimalNumber]


case class BigDecimalOptCol(col: AnyCol) extends BigDecimalOptColValue
                                            with OptColMethods[BigDecimal]


case class InstantOptCol(col: AnyCol) extends InstantOptColValue
                                         with OptColMethods[Instant]


case class ZonedDateTimeOptCol(col: AnyCol) extends ZonedDateTimeOptColValue
                                               with OptColMethods[ZonedDateTime]


case class LocalDateTimeOptCol(col: AnyCol) extends LocalDateTimeOptColValue
                                               with OptColMethods[LocalDateTime]


case class LocalDateOptCol(col: AnyCol) extends LocalDateOptColValue
                                           with OptColMethods[LocalDate]


case class UUIDOptCol(col: AnyCol) extends UUIDOptColValue
                                      with OptColMethods[UUID]






