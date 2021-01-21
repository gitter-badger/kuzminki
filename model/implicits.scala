package kuzminki.model

import io.rdbc.sapi.DecimalNumber
import kuzminki.model.aggregate.RunAggregation
import kuzminki.model.insert._

object implicits {

  // column
  implicit val implColString: ColInfo => TypeCol[String] = info => StringCol(info)
  implicit val implColBoolean: ColInfo => TypeCol[Boolean] = info => BooleanCol(info)
  implicit val implColShort: ColInfo => TypeCol[Short] = info => ShortCol(info)
  implicit val implColInt: ColInfo => TypeCol[Int] = info => IntCol(info)
  implicit val implColLong: ColInfo => TypeCol[Long] = info => LongCol(info)
  implicit val implColFloat: ColInfo => TypeCol[Float] = info => FloatCol(info)
  implicit val implColDouble: ColInfo => TypeCol[Double] = info => DoubleCol(info)

  // filters
  
  implicit val modelColToStringCol: TypeCol[String] => StringCol = col => col.asInstanceOf[StringCol]
  implicit val modelColToBooleanCol: TypeCol[Boolean] => BooleanCol = col => col.asInstanceOf[BooleanCol]
  implicit val modelColToShortCol: TypeCol[Short] => ShortCol = col => col.asInstanceOf[ShortCol]
  implicit val modelColToIntCol: TypeCol[Int] => IntCol = col => col.asInstanceOf[IntCol]
  implicit val modelColToLongCol: TypeCol[Long] => LongCol = col => col.asInstanceOf[LongCol]
  implicit val modelColToFloatCol: TypeCol[Float] => FloatCol = col => col.asInstanceOf[FloatCol]
  implicit val modelColToDoubleCol: TypeCol[Double] => DoubleCol = col => col.asInstanceOf[DoubleCol]

  implicit val modelColToDecimalNumberCol: TypeCol[DecimalNumber] => DecimalNumberCol = col => col.asInstanceOf[DecimalNumberCol]
  implicit val modelColToBigDecimalCol: TypeCol[BigDecimal] => BigDecimalCol = col => col.asInstanceOf[BigDecimalCol]

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





















