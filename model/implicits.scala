package kuzminki.model

import kuzminki.model.select.typed.RunTyped
import kuzminki.model.select.typedjoin.RunTypedJoin


object implicits {

  // column
  implicit val implColString: ColConf => TypeCol[String] = c => StringCol(c.name, c.model)
  implicit val implColInt: ColConf => TypeCol[Int] = c => IntCol(c.name, c.model)
  implicit val implColBoolean: ColConf => TypeCol[Boolean] = c => BooleanCol(c.name, c.model)
  implicit val implColChar: ColConf => TypeCol[Char] = c => CharCol(c.name, c.model)
  implicit val implColShort: ColConf => TypeCol[Short] = c => ShortCol(c.name, c.model)
  implicit val implColLong: ColConf => TypeCol[Long] = c => LongCol(c.name, c.model)

  // filters
  implicit val modelColToStringCol: TypeCol[String] => StringCol = col => col.asInstanceOf[StringCol]
  implicit val modelColToIntCol: TypeCol[Int] => IntCol = col => col.asInstanceOf[IntCol]
  implicit val modelColToBooleanCol: TypeCol[Boolean] => BooleanCol = col => col.asInstanceOf[BooleanCol]
  implicit val modelColToCharCol: TypeCol[Char] => BooleanCol = col => col.asInstanceOf[CharCol]
  implicit val modelColToShortCol: TypeCol[Short] => ShortCol = col => col.asInstanceOf[ShortCol]
  implicit val modelColToLongCol: TypeCol[Long] => LongCol = col => col.asInstanceOf[LongCol]

  // query
  implicit val modelColToSorting: ModelCol => Sorting = col => Sort(col)

  // subquery
  implicit def runTypedToNested[R](rt: RunTyped[_, R]): SubQuery[R] = rt.asSub
  implicit def runTypedJoinToNested[R](rtj: RunTypedJoin[_, _, R]): SubQuery[R] = rtj.asSub
}