package kuzminki


object containers {

  sealed trait Column {
    def render: String
  }

  case object All extends Column {
    def render = "*"
  }

  case class Col(name: String) extends Column {
    def render = name
    def as(alias: String) = ColAs(name, alias)
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
    def render = s"MIN($name)"
  }

  sealed trait TableRef {
    def render: String
  }
  case class TableName(name: String) extends TableRef {
    def render = name
    def alias(alias: String) = TableNameAlias(name, alias)
  }
  case class TableNameAlias(name: String, alias: String) extends TableRef {
    def render = s"$name $alias"
  }

  // order

  sealed trait SelectOrder {
    def render: String
  }

  case class DefaultOrder(name: String) extends SelectOrder {
    def render = s"$name ASC"
    def asc = Asc(name)
    def desc = Desc(name)
  }

  case class Asc(name: String) extends SelectOrder {
    def render = s"$name ASC"
  }

  case class Desc(name: String) extends SelectOrder {
    def render = s"$name DESC"
  }

  // changes

  sealed trait UpdateChange
  case class Inc(amount: Int) extends UpdateChange
  case class Dec(amount: Int) extends UpdateChange
  case class Raw(value: String) extends UpdateChange


  

  
}






