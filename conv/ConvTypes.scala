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

package kuzminki.conv

import java.time.{Instant, LocalDate, LocalDateTime, ZonedDateTime}
import java.util.UUID
import io.rdbc.sapi.{Row, DecimalNumber}


object StringConv extends ValConv[String] {
  def get(row: Row, index: Int) = row.col[String](index)
}

object CharConv extends ValConv[Char] {
  def get(row: Row, index: Int) = SpecialConv.toChar(row.col[String](index))
}

object BooleanConv extends ValConv[Boolean] {
  def get(row: Row, index: Int) = row.col[Boolean](index)
}

object ShortConv extends ValConv[Short] {
  def get(row: Row, index: Int) = row.col[Short](index)
}

object IntConv extends ValConv[Int] {
  def get(row: Row, index: Int) = row.col[Int](index)
}

object LongConv extends ValConv[Long] {
  def get(row: Row, index: Int) = row.col[Long](index)
}

object FloatConv extends ValConv[Float] {
  def get(row: Row, index: Int) = row.col[Float](index)
}

object DoubleConv extends ValConv[Double] {
  def get(row: Row, index: Int) = row.col[Double](index)
}

object NumericConv extends ValConv[DecimalNumber] {
  def get(row: Row, index: Int) = row.col[DecimalNumber](index)
}

object BigDecimalConv extends ValConv[BigDecimal] {
  def get(row: Row, index: Int) = row.col[BigDecimal](index)
}

object InstantConv extends ValConv[Instant] {
  def get(row: Row, index: Int) = row.col[Instant](index)
}

object ZonedDateTimeConv extends ValConv[ZonedDateTime] {
  def get(row: Row, index: Int) = row.col[ZonedDateTime](index)
}

object LocalDateTimeConv extends ValConv[LocalDateTime] {
  def get(row: Row, index: Int) = row.col[LocalDateTime](index)
}

object LocalDateConv extends ValConv[LocalDate] {
  def get(row: Row, index: Int) = row.col[LocalDate](index)
}

object UUIDConv extends ValConv[UUID] {
  def get(row: Row, index: Int) = row.col[UUID](index)
}








