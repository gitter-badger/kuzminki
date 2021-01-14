package kuzminki.model

import io.rdbc.sapi.DecimalNumber
import kuzminki.model.aggregate.RunAggregation
import kuzminki.model.insert._

object implicits {

  // column
  implicit val implColString: ColConf => TypeCol[String] = c => StringCol(c.name, c.model)
  implicit val implColBoolean: ColConf => TypeCol[Boolean] = c => BooleanCol(c.name, c.model)
  implicit val implColShort: ColConf => TypeCol[Short] = c => ShortCol(c.name, c.model)
  implicit val implColInt: ColConf => TypeCol[Int] = c => IntCol(c.name, c.model)
  implicit val implColLong: ColConf => TypeCol[Long] = c => LongCol(c.name, c.model)
  implicit val implColFloat: ColConf => TypeCol[Float] = c => FloatCol(c.name, c.model)
  implicit val implColDouble: ColConf => TypeCol[Double] = c => DoubleCol(c.name, c.model)

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
  implicit def typeColToRealCol(col: TypeCol[_]) = col.asInstanceOf[RealCol]
  //implicit def typeColToAggCol(col: TypeCol[_]) = col.asInstanceOf[AggCol]

  // col function
  //implicit val modelColToTypeColAny: ModelCol => TypeCol[_] = col => col.asInstanceOf[TypeCol[_]]

  // query
  implicit val modelColToSorting: ModelCol => Sorting = col => Sort(col)

  // subquery
  implicit def runTypedToNested[R](rt: RunTyped[R]): SubQuery[R] = rt.asSub
  implicit def runTypedToNested[R](rt: RunAggregation[R]): AggSubQuery[R] = rt.asSub
}





















