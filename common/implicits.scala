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
  implicit val implStringCol: ColInfo => TypeCol[String] = info => StringCol(info)
  implicit val implCharCol: ColInfo => TypeCol[Char] = info => CharCol(info)
  implicit val implBooleanCol: ColInfo => TypeCol[Boolean] = info => BooleanCol(info)
  
  implicit val implShortCol: ColInfo => TypeCol[Short] = info => ShortCol(info)
  implicit val implIntCol: ColInfo => TypeCol[Int] = info => IntCol(info)
  implicit val implLongCol: ColInfo => TypeCol[Long] = info => LongCol(info)
  implicit val implFloatCol: ColInfo => TypeCol[Float] = info => FloatCol(info)
  implicit val implDoubleCol: ColInfo => TypeCol[Double] = info => DoubleCol(info)
  implicit val implDecimalNumberCol: ColInfo => TypeCol[DecimalNumber] = info => DecimalNumberCol(info)
  implicit val implBigDecimalCol: ColInfo => TypeCol[BigDecimal] = info => BigDecimalCol(info)

  implicit val implInstantCol: ColInfo => TypeCol[Instant] = info => InstantCol(info)
  implicit val implZonedDateTimeCol: ColInfo => TypeCol[ZonedDateTime] = info => ZonedDateTimeCol(info)
  implicit val implLocalDateTimeCol: ColInfo => TypeCol[LocalDateTime] = info => LocalDateTimeCol(info)
  implicit val implLocalDateCol: ColInfo => TypeCol[LocalDate] = info => LocalDateCol(info)
  implicit val implUUIDCol: ColInfo => TypeCol[UUID] = info => UUIDCol(info)

  // opt column
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

  // filters
  
  implicit val modelColToStringCol: TypeCol[String] => StringCol = col => col.asInstanceOf[StringCol]
  implicit val modelColToCharCol: TypeCol[Char] => CharCol = col => col.asInstanceOf[CharCol]
  implicit val modelColToBooleanCol: TypeCol[Boolean] => BooleanCol = col => col.asInstanceOf[BooleanCol]
  
  implicit val modelColToShortCol: TypeCol[Short] => ShortCol = col => col.asInstanceOf[ShortCol]
  implicit val modelColToIntCol: TypeCol[Int] => IntCol = col => col.asInstanceOf[IntCol]
  implicit val modelColToLongCol: TypeCol[Long] => LongCol = col => col.asInstanceOf[LongCol]
  implicit val modelColToFloatCol: TypeCol[Float] => FloatCol = col => col.asInstanceOf[FloatCol]
  implicit val modelColToDoubleCol: TypeCol[Double] => DoubleCol = col => col.asInstanceOf[DoubleCol]
  implicit val modelColToDecimalNumberCol: TypeCol[DecimalNumber] => DecimalNumberCol = col => col.asInstanceOf[DecimalNumberCol]
  implicit val modelColToBigDecimalCol: TypeCol[BigDecimal] => BigDecimalCol = col => col.asInstanceOf[BigDecimalCol]

  implicit val modelColToInstantCol: TypeCol[Instant] => InstantCol = col => col.asInstanceOf[InstantCol]
  implicit val modelColToZonedDateTimeCol: TypeCol[ZonedDateTime] => ZonedDateTimeCol = col => col.asInstanceOf[ZonedDateTimeCol]
  implicit val modelColToLocalDateTimeCol: TypeCol[LocalDateTime] => LocalDateTimeCol = col => col.asInstanceOf[LocalDateTimeCol]
  implicit val modelColToLocalDateCol: TypeCol[LocalDate] => LocalDateCol = col => col.asInstanceOf[LocalDateCol]
  implicit val modelColToUUIDCol: TypeCol[UUID] => UUIDCol = col => col.asInstanceOf[UUIDCol]

  // opt filters

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






















