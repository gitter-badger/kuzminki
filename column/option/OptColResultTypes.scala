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
import kuzminki.conv._


trait StringOptColValue extends TypeOptCol[String] {
  def conv = StringOptConv
}

trait CharOptColValue extends TypeOptCol[Char] {
  def conv = CharOptConv
}

trait BooleanOptColValue extends TypeOptCol[Boolean] {
  def conv = BooleanOptConv
}

trait ShortOptColValue extends TypeOptCol[Short] {
  def conv = ShortOptConv
}

trait IntOptColValue extends TypeOptCol[Int] {
  def conv = IntOptConv
}

trait LongOptColValue extends TypeOptCol[Long] {
  def conv = LongOptConv
}

trait FloatOptColValue extends TypeOptCol[Float] {
  def conv = FloatOptConv
}

trait DoubleOptColValue extends TypeOptCol[Double] {
  def conv = DoubleOptConv
}

trait NumericOptColValue extends TypeOptCol[DecimalNumber] {
  def conv = NumericOptConv
}

trait BigDecimalOptColValue extends TypeOptCol[BigDecimal] {
  def conv = BigDecimalOptConv
}

trait InstantOptColValue extends TypeOptCol[Instant] {
  def conv = InstantOptConv
}

trait ZonedDateTimeOptColValue extends TypeOptCol[ZonedDateTime] {
  def conv = ZonedDateTimeOptConv
}

trait LocalDateTimeOptColValue extends TypeOptCol[LocalDateTime] {
  def conv = LocalDateTimeOptConv
}

trait LocalDateOptColValue extends TypeOptCol[LocalDate] {
  def conv = LocalDateOptConv
}

trait UUIDOptColValue extends TypeOptCol[UUID] {
  def conv = UUIDOptConv
}












