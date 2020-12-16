package kuzminki.strings

import kuzminki.builder._


object implicits {

  implicit val stringToColName: String => ColName = name => ColName(name)
  implicit val stringToFilter: String => FilterCol = name => FilterCol(name)

  implicit val stringToTableName: String => TableName = name => TableName(name)
  implicit val tupleToTableAlias: Tuple2[String, String] => TableAlias = tup => TableAlias(tup._1, tup._2)

  implicit val colToDefaultOrder: ColRef => Sort = col => Sort(col)
  implicit val stringToDefaultOrder: String => Sort = name => Sort(ColName(name))
  
  implicit val tupleToChange: Tuple2[String, Any] => Change = tup => Change(ColName(tup._1), Change.box(tup._2))
  implicit val stringTupToColNameTup: Tuple2[String, Any] => Tuple2[ColName, Any] = tup => (ColName(tup._1), tup._2)
}