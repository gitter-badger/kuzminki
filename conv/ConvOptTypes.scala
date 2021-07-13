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


object StringOptConv extends ValOptConv[String] {
  def get(row: Row, index: Int) = row.colOpt[String](index)
}

object CharOptConv extends ValOptConv[Char] {
  def get(row: Row, index: Int) = SpecialConv.toCharOpt(row.colOpt[String](index))
}

object BooleanOptConv extends ValOptConv[Boolean] {
  def get(row: Row, index: Int) = row.colOpt[Boolean](index)
}

object ShortOptConv extends ValOptConv[Short] {
  def get(row: Row, index: Int) = row.colOpt[Short](index)
}

object IntOptConv extends ValOptConv[Int] {
  def get(row: Row, index: Int) = row.colOpt[Int](index)
}

object LongOptConv extends ValOptConv[Long] {
  def get(row: Row, index: Int) = row.colOpt[Long](index)
}

object FloatOptConv extends ValOptConv[Float] {
  def get(row: Row, index: Int) = row.colOpt[Float](index)
}

object DoubleOptConv extends ValOptConv[Double] {
  def get(row: Row, index: Int) = row.colOpt[Double](index)
}

object NumericOptConv extends ValOptConv[DecimalNumber] {
  def get(row: Row, index: Int) = row.colOpt[DecimalNumber](index)
}

object BigDecimalOptConv extends ValOptConv[BigDecimal] {
  def get(row: Row, index: Int) = row.colOpt[BigDecimal](index)
}

object InstantOptConv extends ValOptConv[Instant] {
  def get(row: Row, index: Int) = row.colOpt[Instant](index)
}

object ZonedDateTimeOptConv extends ValOptConv[ZonedDateTime] {
  def get(row: Row, index: Int) = row.colOpt[ZonedDateTime](index)
}

object LocalDateTimeOptConv extends ValOptConv[LocalDateTime] {
  def get(row: Row, index: Int) = row.colOpt[LocalDateTime](index)
}

object LocalDateOptConv extends ValOptConv[LocalDate] {
  def get(row: Row, index: Int) = row.colOpt[LocalDate](index)
}

object UUIDOptConv extends ValOptConv[UUID] {
  def get(row: Row, index: Int) = row.colOpt[UUID](index)
}






