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


trait StringCol extends StringColValue
                   with UniversalFilters[String]
                   with StringFilters

trait CharCol extends CharColValue
                      with UniversalFilters[Char]


trait BooleanCol extends BooleanColValue
                         with UniversalFilters[Boolean]


trait ShortCol extends ShortColValue
                       with UniversalFilters[Int]
                       with ComparativeFilters[Short]


trait IntCol extends IntColValue
                     with UniversalFilters[Int]
                     with ComparativeFilters[Int]


trait LongCol extends LongColValue
                      with UniversalFilters[Long]
                      with ComparativeFilters[Long]


trait FloatCol extends FloatColValue
                       with UniversalFilters[Float]
                       with ComparativeFilters[Float]


trait DoubleCol extends DoubleColValue
                        with UniversalFilters[Double]
                        with ComparativeFilters[Double]


trait NumericCol extends NumericColValue
                         with UniversalFilters[DecimalNumber]
                         with ComparativeFilters[DecimalNumber]


trait BigDecimalCol extends BigDecimalColValue
                            with UniversalFilters[BigDecimal]
                            with ComparativeFilters[BigDecimal]


trait InstantCol extends InstantColValue
                         with UniversalFilters[Instant]
                         with ComparativeFilters[Instant]


trait ZonedDateTimeCol extends ZonedDateTimeColValue
                               with UniversalFilters[ZonedDateTime]
                               with ComparativeFilters[ZonedDateTime]


trait LocalDateTimeCol extends LocalDateTimeColValue
                               with UniversalFilters[LocalDateTime]
                               with ComparativeFilters[LocalDateTime]


trait LocalDateCol extends LocalDateColValue
                           with UniversalFilters[LocalDate]
                           with ComparativeFilters[LocalDate]


trait UUIDCol extends UUIDColValue
                      with UniversalFilters[UUID]
                      with ComparativeFilters[UUID]


























