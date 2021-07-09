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

package kuzminki

import kuzminki.column._


import java.time._
import java.util.UUID
import io.rdbc.sapi.DecimalNumber

package object api {

  // create model col

  implicit val implStringCol: ColInfo => TypeCol[String] = info => StringModelCol(info)
  implicit val implCharCol: ColInfo => TypeCol[Char] = info => CharModelCol(info)
  implicit val implBooleanCol: ColInfo => TypeCol[Boolean] = info => BooleanModelCol(info)
  
  implicit val implShortCol: ColInfo => TypeCol[Short] = info => ShortModelCol(info)
  implicit val implIntCol: ColInfo => TypeCol[Int] = info => IntModelCol(info)
  implicit val implLongCol: ColInfo => TypeCol[Long] = info => LongModelCol(info)
  implicit val implFloatCol: ColInfo => TypeCol[Float] = info => FloatModelCol(info)
  implicit val implDoubleCol: ColInfo => TypeCol[Double] = info => DoubleModelCol(info)
  implicit val implNumericCol: ColInfo => TypeCol[DecimalNumber] = info => NumericModelCol(info)
  implicit val implBigDecimalCol: ColInfo => TypeCol[BigDecimal] = info => BigDecimalModelCol(info)

  implicit val implInstantCol: ColInfo => TypeCol[Instant] = info => InstantModelCol(info)
  implicit val implZonedDateTimeCol: ColInfo => TypeCol[ZonedDateTime] = info => ZonedDateTimeModelCol(info)
  implicit val implLocalDateTimeCol: ColInfo => TypeCol[LocalDateTime] = info => LocalDateTimeModelCol(info)
  implicit val implLocalDateCol: ColInfo => TypeCol[LocalDate] = info => LocalDateModelCol(info)
  implicit val implUUIDCol: ColInfo => TypeCol[UUID] = info => UUIDModelCol(info)

  // model type col

  implicit val toStringModelCol: TypeCol[String] => StringModelCol = col => col.asInstanceOf[StringModelCol]
  implicit val toCharModelCol: TypeCol[Char] => CharModelCol = col => col.asInstanceOf[CharModelCol]
  implicit val toBooleanModelCol: TypeCol[Boolean] => BooleanModelCol = col => col.asInstanceOf[BooleanModelCol]
  
  implicit val toShortModelCol: TypeCol[Short] => ShortModelCol = col => col.asInstanceOf[ShortModelCol]
  implicit val toIntModelCol: TypeCol[Int] => IntModelCol = col => col.asInstanceOf[IntModelCol]
  implicit val toLongModelCol: TypeCol[Long] => LongModelCol = col => col.asInstanceOf[LongModelCol]
  implicit val toFloatModelCol: TypeCol[Float] => FloatModelCol = col => col.asInstanceOf[FloatModelCol]
  implicit val toDoubleModelCol: TypeCol[Double] => DoubleModelCol = col => col.asInstanceOf[DoubleModelCol]
  implicit val toNumericModelCol: TypeCol[DecimalNumber] => NumericModelCol = col => col.asInstanceOf[NumericModelCol]
  implicit val toBigDecimalModelCol: TypeCol[BigDecimal] => BigDecimalModelCol = col => col.asInstanceOf[BigDecimalModelCol]

  implicit val toInstantModelCol: TypeCol[Instant] => InstantModelCol = col => col.asInstanceOf[InstantModelCol]
  implicit val toZonedDateTimeModelCol: TypeCol[ZonedDateTime] => ZonedDateTimeModelCol = col => col.asInstanceOf[ZonedDateTimeModelCol]
  implicit val toLocalDateTimeModelCol: TypeCol[LocalDateTime] => LocalDateTimeModelCol = col => col.asInstanceOf[LocalDateTimeModelCol]
  implicit val toLocalDateModelCol: TypeCol[LocalDate] => LocalDateModelCol = col => col.asInstanceOf[LocalDateModelCol]
  implicit val toUUIDModelCol: TypeCol[UUID] => UUIDModelCol = col => col.asInstanceOf[UUIDModelCol]

  // type col

  implicit val typeColToStringCol: TypeCol[String] => StringCol = col => col.asInstanceOf[StringCol]
  implicit val typeColToCharCol: TypeCol[Char] => CharCol = col => col.asInstanceOf[CharCol]
  implicit val typeColToBooleanCol: TypeCol[Boolean] => BooleanCol = col => col.asInstanceOf[BooleanCol]
  
  implicit val typeColToShortCol: TypeCol[Short] => ShortCol = col => col.asInstanceOf[ShortCol]
  implicit val typeColToIntCol: TypeCol[Int] => IntCol = col => col.asInstanceOf[IntCol]
  implicit val typeColToLongCol: TypeCol[Long] => LongCol = col => col.asInstanceOf[LongCol]
  implicit val typeColToFloatCol: TypeCol[Float] => FloatCol = col => col.asInstanceOf[FloatCol]
  implicit val typeColToDoubleCol: TypeCol[Double] => DoubleCol = col => col.asInstanceOf[DoubleCol]
  implicit val typeColToNumericCol: TypeCol[DecimalNumber] => NumericCol = col => col.asInstanceOf[NumericCol]
  implicit val typeColToBigDecimalCol: TypeCol[BigDecimal] => BigDecimalCol = col => col.asInstanceOf[BigDecimalCol]

  implicit val typeColToInstantCol: TypeCol[Instant] => InstantCol = col => col.asInstanceOf[InstantCol]
  implicit val typeColToZonedDateTimeCol: TypeCol[ZonedDateTime] => ZonedDateTimeCol = col => col.asInstanceOf[ZonedDateTimeCol]
  implicit val typeColToLocalDateTimeCol: TypeCol[LocalDateTime] => LocalDateTimeCol = col => col.asInstanceOf[LocalDateTimeCol]
  implicit val typeColToLocalDateCol: TypeCol[LocalDate] => LocalDateCol = col => col.asInstanceOf[LocalDateCol]
  implicit val typeColToUUIDCol: TypeCol[UUID] => UUIDCol = col => col.asInstanceOf[UUIDCol]
}
















