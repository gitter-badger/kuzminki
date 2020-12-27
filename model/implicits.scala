package kuzminki.model


object implicits {

  // column
  implicit val implColString: ColConf => TypeCol[String] = c => StringCol(c.name, c.model)
  implicit val implColInt: ColConf => TypeCol[Int] = c => IntCol(c.name, c.model)
  implicit val implColBoolean: ColConf => TypeCol[Boolean] = c => BooleanCol(c.name, c.model)

  // filters
  implicit val modelColToStringCol: TypeCol[String] => StringCol = col => col.asInstanceOf[StringCol]
  implicit val modelColToIntCol: TypeCol[Int] => IntCol = col => col.asInstanceOf[IntCol]
  implicit val modelColToBooleanCol: TypeCol[Boolean] => BooleanCol = col => col.asInstanceOf[BooleanCol]

  // query
  implicit val modelColToSorting: ModelCol => Sorting = col => Sort(col)
}