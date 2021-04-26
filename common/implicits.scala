package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi.DecimalNumber

object implicits {

  // column
  implicit val implColString: ColInfo => TypeCol[String] = info => StringCol(info)
  //implicit val implColChar: ColInfo => TypeCol[Char] = info => CharCol(info)
  implicit val implColBoolean: ColInfo => TypeCol[Boolean] = info => BooleanCol(info)
  implicit val implColShort: ColInfo => TypeCol[Short] = info => ShortCol(info)
  implicit val implColInt: ColInfo => TypeCol[Int] = info => IntCol(info)
  implicit val implColLong: ColInfo => TypeCol[Long] = info => LongCol(info)
  implicit val implColFloat: ColInfo => TypeCol[Float] = info => FloatCol(info)
  implicit val implColDouble: ColInfo => TypeCol[Double] = info => DoubleCol(info)

  implicit val implColInstant: ColInfo => TypeCol[Instant] = info => InstantCol(info)
  implicit val implColZonedDateTime: ColInfo => TypeCol[ZonedDateTime] = info => ZonedDateTimeCol(info)
  implicit val implColLocalDateTime: ColInfo => TypeCol[LocalDateTime] = info => LocalDateTimeCol(info)
  implicit val implColLocalDate: ColInfo => TypeCol[LocalDate] = info => LocalDateCol(info)
  implicit val implColUUID: ColInfo => TypeCol[UUID] = info => UUIDCol(info)

  // filters
  
  implicit val modelColToStringCol: TypeCol[String] => StringCol = col => col.asInstanceOf[StringCol]
  //implicit val modelColToCharCol: TypeCol[Char] => CharCol = col => col.asInstanceOf[CharCol]
  implicit val modelColToBooleanCol: TypeCol[Boolean] => BooleanCol = col => col.asInstanceOf[BooleanCol]
  implicit val modelColToShortCol: TypeCol[Short] => ShortCol = col => col.asInstanceOf[ShortCol]
  implicit val modelColToIntCol: TypeCol[Int] => IntCol = col => col.asInstanceOf[IntCol]
  implicit val modelColToLongCol: TypeCol[Long] => LongCol = col => col.asInstanceOf[LongCol]
  implicit val modelColToFloatCol: TypeCol[Float] => FloatCol = col => col.asInstanceOf[FloatCol]
  implicit val modelColToDoubleCol: TypeCol[Double] => DoubleCol = col => col.asInstanceOf[DoubleCol]
  implicit val modelColToDecimalNumberCol: TypeCol[DecimalNumber] => DecimalNumberCol = col => col.asInstanceOf[DecimalNumberCol]
  implicit val modelColToBigDecimalCol: TypeCol[BigDecimal] => BigDecimalCol = col => col.asInstanceOf[BigDecimalCol]

  implicit val modelColToInstant: TypeCol[Instant] => InstantCol = col => col.asInstanceOf[InstantCol]
  implicit val modelColToZonedDateTime: TypeCol[ZonedDateTime] => ZonedDateTimeCol = col => col.asInstanceOf[ZonedDateTimeCol]
  implicit val modelColToLocalDateTime: TypeCol[LocalDateTime] => LocalDateTimeCol = col => col.asInstanceOf[LocalDateTimeCol]
  implicit val modelColToLocalDate: TypeCol[LocalDate] => LocalDateCol = col => col.asInstanceOf[LocalDateCol]
  implicit val modelColToUUID: TypeCol[UUID] => UUIDCol = col => col.asInstanceOf[UUIDCol]

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
  implicit val modelColToSorting: ModelCol => Sorting = col => Sort(col)

  // subquery
  //implicit def runTypedToNested[R](rt: RunSelect[R]): SubQuery[R] = rt.asSub
  //implicit def runTypedToNested[R](rt: RunAggregation[R]): AggSubQuery[R] = rt.asSub
}






















