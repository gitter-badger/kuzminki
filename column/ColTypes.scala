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
                   with UniversalMethods[String]
                   with StringFilters {

  val self = this
  def asOpt = StringOptCol(this)
}


trait CharCol extends CharColValue
                 with UniversalMethods[Char] {

  val self = this
  def asOpt = CharOptCol(this)
}


trait BooleanCol extends BooleanColValue
                    with UniversalMethods[Boolean] {

  val self = this
  def asOpt = BooleanOptCol(this)
}


trait ShortCol extends ShortColValue
                  with UniversalMethods[Short]
                  with ComparativeFilters[Short]
                  with AggregationSubqueryFilters[Short] {

  val self = this
  def asOpt = ShortOptCol(this)
}


trait IntCol extends IntColValue
                with SelfRef[Int]
                with UniversalMethods[Int]
                with ComparativeFilters[Int]
                with AggregationSubqueryFilters[Int] {

  val self = this
  def asOpt = IntOptCol(this)
}


trait LongCol extends LongColValue
                 with UniversalMethods[Long]
                 with ComparativeFilters[Long]
                 with AggregationSubqueryFilters[Long] {

  val self = this
  def asOpt = LongOptCol(this)
}


trait FloatCol extends FloatColValue
                  with UniversalMethods[Float]
                  with ComparativeFilters[Float]
                  with AggregationSubqueryFilters[Float] {

  val self = this
  def asOpt = FloatOptCol(this)
}


trait DoubleCol extends DoubleColValue
                   with UniversalMethods[Double]
                   with ComparativeFilters[Double]
                   with AggregationSubqueryFilters[Double] {

  val self = this
  def asOpt = DoubleOptCol(this)
}


trait NumericCol extends NumericColValue
                    with UniversalMethods[DecimalNumber]
                    with ComparativeFilters[DecimalNumber]
                    with AggregationSubqueryFilters[DecimalNumber] {

  val self = this
  def asOpt = NumericOptCol(this)
}


trait BigDecimalCol extends BigDecimalColValue
                       with UniversalMethods[BigDecimal]
                       with ComparativeFilters[BigDecimal]
                       with AggregationSubqueryFilters[BigDecimal] {

  val self = this
  def asOpt = BigDecimalOptCol(this)
}


trait InstantCol extends InstantColValue
                    with UniversalMethods[Instant]
                    with ComparativeFilters[Instant] {

  val self = this
  def asOpt = InstantOptCol(this)
}


trait ZonedDateTimeCol extends ZonedDateTimeColValue
                          with UniversalMethods[ZonedDateTime]
                          with ComparativeFilters[ZonedDateTime] {

  val self = this
  def asOpt = ZonedDateTimeOptCol(this)
}


trait LocalDateTimeCol extends LocalDateTimeColValue
                          with UniversalMethods[LocalDateTime]
                          with ComparativeFilters[LocalDateTime] {

  val self = this
  def asOpt = LocalDateTimeOptCol(this)
}


trait LocalDateCol extends LocalDateColValue
                      with UniversalMethods[LocalDate]
                      with ComparativeFilters[LocalDate] {

  val self = this
  def asOpt = LocalDateOptCol(this)
}


trait UUIDCol extends UUIDColValue
                 with UniversalMethods[UUID]
                 with ComparativeFilters[UUID] {

  val self = this
  def asOpt = UUIDOptCol(this)
}


























