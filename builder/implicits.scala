package kuzminki


object implicits {

  implicit val stringToColumn: String => Col = name => Col(name)
  implicit val stringToFilter: String => Condition = name => Condition(name)

  implicit val stringToTableName: String => TableName = name => TableName(name)
  implicit val tupleToTableNameAlias: Tuple2[String, String] => TableNameAlias = pair => TableNameAlias(pair._1, pair._2)

  implicit val stringToDefaultOrder: String => DefaultOrder = name => DefaultOrder(name)
  implicit val tupleToChange: Tuple2[String, Any] => Change = pair => Change(Col(pair._1), Change.box(pair._2))
}