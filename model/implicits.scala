package kuzminki.model


object implicits {

  // column
  implicit val implColString: ColConf => TypedModelCol[String] = c => StringCol(c.name, c.model)
  implicit val implColInt: ColConf => TypedModelCol[Int] = c => IntCol(c.name, c.model)
  implicit val implColBoolean: ColConf => TypedModelCol[Boolean] = c => BooleanCol(c.name, c.model)

  // filters
  implicit val modelColToStringCol: TypedModelCol[String] => StringCol = col => col.asInstanceOf[StringCol]
  implicit val modelColToIntCol: TypedModelCol[Int] => IntCol = col => col.asInstanceOf[IntCol]
  implicit val modelColToBooleanCol: TypedModelCol[Boolean] => BooleanCol = col => col.asInstanceOf[BooleanCol]

  // query
  implicit val modelColToSorting: ModelCol => ModelSorting = col => ModelSort(col)
}