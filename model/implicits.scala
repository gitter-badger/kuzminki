package kuzminki.model

import kuzminki.model.select.typed.RunTyped
import kuzminki.model.select.typedjoin.RunTypedJoin


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
  /*
  implicit val modelColToStringColValue: TypeCol[String] => StringCol = col => col.asInstanceOf[StringCol]
  implicit val modelColToBooleanColValue: TypeCol[Boolean] => BooleanCol = col => col.asInstanceOf[BooleanCol]
  implicit val modelColToShortColValue: TypeCol[Short] => ShortCol = col => col.asInstanceOf[ShortCol]
  implicit val modelColToIntColValue: TypeCol[Int] => IntCol = col => col.asInstanceOf[IntCol]
  implicit val modelColToLongColValue: TypeCol[Long] => LongCol = col => col.asInstanceOf[LongCol]
  implicit val modelColToFloatColValue: TypeCol[Float] => FloatCol = col => col.asInstanceOf[FloatCol]
  implicit val modelColToDoubleColValue: TypeCol[Double] => DoubleCol = col => col.asInstanceOf[DoubleCol]
*/

  implicit def typeColToUniversalFilters[T](col: TypeCol[T]) = col.asInstanceOf[UniversalFilters[T]]
  implicit def typeColToComparativeFilters[T](col: TypeCol[T]) = col.asInstanceOf[ComparativeFilters[T]]
  implicit def typeColToIncrementUpdate[T](col: TypeCol[T]) = col.asInstanceOf[IncrementUpdate[T]]
  implicit def typeColToRealCol(col: TypeCol[_]) = col.asInstanceOf[RealCol]

  // query
  implicit val modelColToSorting: ModelCol => Sorting = col => Sort(col)

  // subquery
  implicit def runTypedToNested[R](rt: RunTyped[_, R]): SubQuery[R] = rt.asSub
  implicit def runTypedJoinToNested[R](rtj: RunTypedJoin[_, _, R]): SubQuery[R] = rtj.asSub
}