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


trait StringColValue extends TypeCol[String] {
  def conv = StringConv
}

trait CharColValue extends TypeCol[Char] {
  def conv = CharConv
}

trait BooleanColValue extends TypeCol[Boolean] {
  def conv = BooleanConv
}

trait ShortColValue extends TypeCol[Short] {
  def conv = ShortConv
}

trait IntColValue extends TypeCol[Int] {
  def conv = IntConv
}

trait LongColValue extends TypeCol[Long] {
  def conv = LongConv
}

trait FloatColValue extends TypeCol[Float] {
  def conv = FloatConv
}

trait DoubleColValue extends TypeCol[Double] {
  def conv = DoubleConv
}

trait NumericColValue extends TypeCol[DecimalNumber] {
  def conv = NumericConv
}

trait BigDecimalColValue extends TypeCol[BigDecimal] {
  def conv = BigDecimalConv
}

trait InstantColValue extends TypeCol[Instant] {
  def conv = InstantConv
}

trait ZonedDateTimeColValue extends TypeCol[ZonedDateTime] {
  def conv = ZonedDateTimeConv
}

trait LocalDateTimeColValue extends TypeCol[LocalDateTime] {
  def conv = LocalDateTimeConv
}

trait LocalDateColValue extends TypeCol[LocalDate] {
  def conv = LocalDateConv
}

trait UUIDColValue extends TypeCol[UUID] {
  def conv = UUIDConv
}



















