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
                   with UsableCol
                   with UniversalMethods[String]
                   with StringFilters {

  def asOpt = StringOptCol(this)
}


trait CharCol extends CharColValue
                 with UsableCol
                 with UniversalMethods[Char] {

  def asOpt = CharOptCol(this)
}


trait BooleanCol extends BooleanColValue
                    with UsableCol
                    with UniversalMethods[Boolean] {

  def asOpt = BooleanOptCol(this)
}


trait ShortCol extends ShortColValue
                  with UsableCol
                  with UniversalMethods[Short]
                  with ComparativeFilters[Short] {

  def asOpt = ShortOptCol(this)
}


trait IntCol extends IntColValue
                with UsableCol
                with UniversalMethods[Int]
                with ComparativeFilters[Int] {

  def asOpt = IntOptCol(this)
}


trait LongCol extends LongColValue
                 with UsableCol
                 with UniversalMethods[Long]
                 with ComparativeFilters[Long] {

  def asOpt = LongOptCol(this)
}


trait FloatCol extends FloatColValue
                  with UsableCol
                  with UniversalMethods[Float]
                  with ComparativeFilters[Float] {

  def asOpt = FloatOptCol(this)
}


trait DoubleCol extends DoubleColValue
                   with UsableCol
                   with UniversalMethods[Double]
                   with ComparativeFilters[Double] {

  def asOpt = DoubleOptCol(this)
}


trait NumericCol extends NumericColValue
                    with UsableCol
                    with UniversalMethods[DecimalNumber]
                    with ComparativeFilters[DecimalNumber] {

  def asOpt = NumericOptCol(this)
}


trait BigDecimalCol extends BigDecimalColValue
                       with UsableCol
                       with UniversalMethods[BigDecimal]
                       with ComparativeFilters[BigDecimal] {

  def asOpt = BigDecimalOptCol(this)
}


trait InstantCol extends InstantColValue
                    with UsableCol
                    with UniversalMethods[Instant]
                    with ComparativeFilters[Instant] {

  def asOpt = InstantOptCol(this)
}


trait ZonedDateTimeCol extends ZonedDateTimeColValue
                          with UsableCol
                          with UniversalMethods[ZonedDateTime]
                          with ComparativeFilters[ZonedDateTime] {

  def asOpt = ZonedDateTimeOptCol(this)
}


trait LocalDateTimeCol extends LocalDateTimeColValue
                          with UsableCol
                          with UniversalMethods[LocalDateTime]
                          with ComparativeFilters[LocalDateTime] {

  def asOpt = LocalDateTimeOptCol(this)
}


trait LocalDateCol extends LocalDateColValue
                      with UsableCol
                      with UniversalMethods[LocalDate]
                      with ComparativeFilters[LocalDate] {

  def asOpt = LocalDateOptCol(this)
}


trait UUIDCol extends UUIDColValue
                 with UsableCol
                 with UniversalMethods[UUID]
                 with ComparativeFilters[UUID] {

  def asOpt = UUIDOptCol(this)
}


























