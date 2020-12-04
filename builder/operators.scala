package kuzminki

/*
class Col(name: String) {


} 
*/


object columns {

  sealed trait Column {
    def render: String
  }

  case object All extends Column {
    def render = "*"
  }

  case class Col(name: String) extends Column {
    def as(alias: String) = ColAs(name, alias)
    def render = name
  }

  case class ColAs(name: String, alias: String) extends Column {
    def render = s"$name $alias"
  }

  case class Sum(name: String) extends Column {
    def render = s"SUM($name)"
  }

  case class Max(name: String) extends Column {
    def render = s"MAX($name)"
  }

  case class Min(name: String) extends Column {
    def render = s"Min($name)"
  }
}


object operators {

  sealed trait QueryTable
  case class TableName(name: String) extends QueryTable {
    def as(alias: String) = TableNameAs(name, alias)
  }
  case class TableNameAs(name: String, alias: String) extends QueryTable

  sealed trait Cond
  case class Eq(value: Any) extends Cond
  case class Not(value: Any) extends Cond
  case class Gt(value: Any) extends Cond
  case class Gte(value: Any) extends Cond
  case class Lt(value: Any) extends Cond
  case class Lte(value: Any) extends Cond
  case class Like(value: String) extends Cond

  sealed trait UpdateChange
  case class Inc(amount: Int) extends UpdateChange
  case class Dec(amount: Int) extends UpdateChange
  case class Raw(value: String) extends UpdateChange

  sealed trait SelectOrder {
    def render: String
  }
  case class Asc(col: String) extends SelectOrder {
    def render = s"$col ASC"
  }
  case class Desc(col: String) extends SelectOrder {
    def render = s"$col DESC"
  }
}






