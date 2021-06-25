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



case class StringOptCol(underlying: UsableCol) extends StringOptColValue
                                                  with OptColTransformMethods[String]


case class CharOptCol(underlying: UsableCol) extends CharOptColValue
                                                with OptColTransformMethods[Char]


case class BooleanOptCol(underlying: UsableCol) extends BooleanOptColValue
                                                   with OptColTransformMethods[Boolean]


case class ShortOptCol(underlying: UsableCol) extends ShortOptColValue
                                                 with OptColTransformMethods[Short]


case class IntOptCol(underlying: UsableCol) extends IntOptColValue
                                               with OptColTransformMethods[Int]


case class LongOptCol(underlying: UsableCol) extends LongOptColValue
                                                with OptColTransformMethods[Long]


case class FloatOptCol(underlying: UsableCol) extends FloatOptColValue
                                                 with OptColTransformMethods[Float]


case class DoubleOptCol(underlying: UsableCol) extends DoubleOptColValue
                                                  with OptColTransformMethods[Double]


case class NumericOptCol(underlying: UsableCol) extends NumericOptColValue
                                                   with OptColTransformMethods[DecimalNumber]


case class BigDecimalOptCol(underlying: UsableCol) extends BigDecimalOptColValue
                                                      with OptColTransformMethods[BigDecimal]


case class InstantOptCol(underlying: UsableCol) extends InstantOptColValue
                                                   with OptColTransformMethods[Instant]


case class ZonedDateTimeOptCol(underlying: UsableCol) extends ZonedDateTimeOptColValue
                                                         with OptColTransformMethods[ZonedDateTime]


case class LocalDateTimeOptCol(underlying: UsableCol) extends LocalDateTimeOptColValue
                                                         with OptColTransformMethods[LocalDateTime]


case class LocalDateOptCol(underlying: UsableCol) extends LocalDateOptColValue
                                                     with OptColTransformMethods[LocalDate]


case class UUIDOptCol(underlying: UsableCol) extends UUIDOptColValue
                                                with OptColTransformMethods[UUID]






