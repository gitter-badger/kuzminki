package kuzminki


object operators {

  sealed trait QueryTable
  case class TableName(name: String) extends QueryTable {
    def as(alias: String) = TableNameAs(name, alias)
  }
  case class TableNameAs(name: String, alias: String) extends QueryTable

  sealed trait TableCol
  case object AllCols extends TableCol
  case class ColName(name: String) extends TableCol {
    def as(alias: String) = ColNameAs(name, alias)
  }
  case class ColNameAs(name: String, alias: String) extends TableCol

  sealed trait Cond
  case class Eq(value: Any) extends Cond
  case class Not(value: Any) extends Cond
  case class Gt(value: Any) extends Cond
  case class Gte(value: Any) extends Cond
  case class Lt(value: Any) extends Cond
  case class Lte(value: Any) extends Cond
  case class Like(value: String) extends Cond

  sealed trait Change
  case class Inc(amount: Int) extends Change
  case class Dec(amount: Int) extends Change
  case class Raw(value: String) extends Change

  sealed trait Sort
  case class Asc(col: String) extends Sort
  case class Desc(col: String) extends Sort
}