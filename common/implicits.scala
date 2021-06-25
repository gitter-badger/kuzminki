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
import io.rdbc.sapi.DecimalNumber

object implicits {

  // column
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

  // filters
  
  implicit val modelColToStringCol: TypeCol[String] => StringModelCol = col => col.asInstanceOf[StringModelCol]
  implicit val modelColToCharCol: TypeCol[Char] => CharModelCol = col => col.asInstanceOf[CharModelCol]
  implicit val modelColToBooleanCol: TypeCol[Boolean] => BooleanModelCol = col => col.asInstanceOf[BooleanModelCol]
  
  implicit val modelColToShortCol: TypeCol[Short] => ShortModelCol = col => col.asInstanceOf[ShortModelCol]
  implicit val modelColToIntCol: TypeCol[Int] => IntModelCol = col => col.asInstanceOf[IntModelCol]
  implicit val modelColToLongCol: TypeCol[Long] => LongModelCol = col => col.asInstanceOf[LongModelCol]
  implicit val modelColToFloatCol: TypeCol[Float] => FloatModelCol = col => col.asInstanceOf[FloatModelCol]
  implicit val modelColToDoubleCol: TypeCol[Double] => DoubleModelCol = col => col.asInstanceOf[DoubleModelCol]
  implicit val modelColToNumericCol: TypeCol[DecimalNumber] => NumericModelCol = col => col.asInstanceOf[NumericModelCol]
  implicit val modelColToBigDecimalCol: TypeCol[BigDecimal] => BigDecimalModelCol = col => col.asInstanceOf[BigDecimalModelCol]

  implicit val modelColToInstantCol: TypeCol[Instant] => InstantModelCol = col => col.asInstanceOf[InstantModelCol]
  implicit val modelColToZonedDateTimeCol: TypeCol[ZonedDateTime] => ZonedDateTimeModelCol = col => col.asInstanceOf[ZonedDateTimeModelCol]
  implicit val modelColToLocalDateTimeCol: TypeCol[LocalDateTime] => LocalDateTimeModelCol = col => col.asInstanceOf[LocalDateTimeModelCol]
  implicit val modelColToLocalDateCol: TypeCol[LocalDate] => LocalDateModelCol = col => col.asInstanceOf[LocalDateModelCol]
  implicit val modelColToUUIDCol: TypeCol[UUID] => UUIDModelCol = col => col.asInstanceOf[UUIDModelCol]

  // opt column

  /*
  implicit val impStringOptCol: ColInfo => TypeCol[Option[String]] = info => StringCol(info).opt
  implicit val implCharOptCol: ColInfo => TypeCol[Option[Char]] = info => CharCol(info).opt
  implicit val implBooleanOptCol: ColInfo => TypeCol[Option[Boolean]] = info => BooleanCol(info).opt
  
  implicit val implShortOptCol: ColInfo => TypeCol[Option[Short]] = info => ShortCol(info).opt
  implicit val implIntOptCol: ColInfo => TypeCol[Option[Int]] = info => IntCol(info).opt
  implicit val implLongOptCol: ColInfo => TypeCol[Option[Long]] = info => LongCol(info).opt
  implicit val implFloatOptCol: ColInfo => TypeCol[Option[Float]] = info => FloatCol(info).opt
  implicit val implDoubleOptCol: ColInfo => TypeCol[Option[Double]] = info => DoubleCol(info).opt
  implicit val implDecimalNumberOptCol: ColInfo => TypeCol[Option[DecimalNumber]] = info => DecimalNumberCol(info).opt
  implicit val implBigDecimalOptCol: ColInfo => TypeCol[Option[BigDecimal]] = info => BigDecimalCol(info).opt

  implicit val implInstantOptCol: ColInfo => TypeCol[Option[Instant]] = info => InstantCol(info).opt
  implicit val implZonedDateTimeOptCol: ColInfo => TypeCol[Option[ZonedDateTime]] = info => ZonedDateTimeCol(info).opt
  implicit val implLocalDateTimeOptCol: ColInfo => TypeCol[Option[LocalDateTime]] = info => LocalDateTimeCol(info).opt
  implicit val implLocalDateOptCol: ColInfo => TypeCol[Option[LocalDate]] = info => LocalDateCol(info).opt
  implicit val implUUIDOptCol: ColInfo => TypeCol[Option[UUID]] = info => UUIDCol(info).opt
  */

  // opt filters

  /*
  implicit val modelColToStringOptCol: TypeCol[Option[String]] => StringOptCol = col => col.asInstanceOf[StringOptCol]
  implicit val modelColToCharOptCol: TypeCol[Option[Char]] => CharOptCol = col => col.asInstanceOf[CharOptCol]
  implicit val modelColToBooleanOptCol: TypeCol[Option[Boolean]] => BooleanOptCol = col => col.asInstanceOf[BooleanOptCol]
  
  implicit val modelColToShortOptCol: TypeCol[Option[Short]] => ShortOptCol = col => col.asInstanceOf[ShortOptCol]
  implicit val modelColToIntOptCol: TypeCol[Option[Int]] => IntOptCol = col => col.asInstanceOf[IntOptCol]
  implicit val modelColToLongOptCol: TypeCol[Option[Long]] => LongOptCol = col => col.asInstanceOf[LongOptCol]
  implicit val modelColToFloatOptCol: TypeCol[Option[Float]] => FloatOptCol = col => col.asInstanceOf[FloatOptCol]
  implicit val modelColToDoubleOptCol: TypeCol[Option[Double]] => DoubleOptCol = col => col.asInstanceOf[DoubleOptCol]
  implicit val modelColToDecimalNumberOptCol: TypeCol[Option[DecimalNumber]] => DecimalNumberOptCol = col => col.asInstanceOf[DecimalNumberOptCol]
  implicit val modelColToBigDecimalOptCol: TypeCol[Option[BigDecimal]] => BigDecimalOptCol = col => col.asInstanceOf[BigDecimalOptCol]

  implicit val modelColToInstantOptCol: TypeCol[Option[Instant]] => InstantOptCol = col => col.asInstanceOf[InstantOptCol]
  implicit val modelColToZonedDateTimeOptCol: TypeCol[Option[ZonedDateTime]] => ZonedDateTimeOptCol = col => col.asInstanceOf[ZonedDateTimeOptCol]
  implicit val modelColToLocalDateTimeOptCol: TypeCol[Option[LocalDateTime]] => LocalDateTimeOptCol = col => col.asInstanceOf[LocalDateTimeOptCol]
  implicit val modelColToLocalDateOptCol: TypeCol[Option[LocalDate]] => LocalDateOptCol = col => col.asInstanceOf[LocalDateOptCol]
  implicit val modelColToUUIDOptCol: TypeCol[Option[UUID]] => UUIDOptCol = col => col.asInstanceOf[UUIDOptCol]
  */

  /*
  implicit def typeColToUniversalFilters[T](col: TypeCol[T]) = col.asInstanceOf[UniversalFilters[T]]
  implicit def typeColToComparativeFilters[T](col: TypeCol[T]) = col.asInstanceOf[ComparativeFilters[T]]
  implicit def typeColToUpdateMethod[T](col: TypeCol[T]) = col.asInstanceOf[UpdateMethod[T]]
  implicit def typeColToNumericMethods[T](col: TypeCol[T]) = col.asInstanceOf[NumericMethods[T]]
  */
  //implicit def typeColToRealCol(col: TypeCol[_]) = col.asInstanceOf[RealCol]
  //implicit def typeColToAggCol(col: TypeCol[_]) = col.asInstanceOf[AggCol]

  // col function
  //implicit val modelColToTypeColAny: ModelCol => TypeCol[_] = col => col.asInstanceOf[TypeCol[_]]

  // query
  //implicit val modelColToSorting: ModelCol => Sorting = col => Sort(col)

  // subquery
  //implicit def runTypedToNested[R](rt: RunSelect[R]): SubQuery[R] = rt.asSub
  //implicit def runTypedToNested[R](rt: RunAggregation[R]): AggSubQuery[R] = rt.asSub
}






















