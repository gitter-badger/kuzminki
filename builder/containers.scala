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

  // condition

  case class Cond(name: Sting, op: String, args: Seq[Any]) extends Renderable {
    def render = "%s = ?".format(name)
    def wrap = "%s = ?".format(Renderable.wrapped(name))
    def start = StartCond(this)
    def and = AndCond(this)
    def or = OrCond(this)
  }

  trait CondWithOperator {
    def cond: Cond
    def template: String
    def render = template.format(cond.render)
    def wrapp = template.format(cond.wrap) 
    def pre = render + "\n"
  }

  trait OneCond extends DirectiveCond {
    def indent = render + "\n"
  }

  trait NestedCond extends DirectiveCond {
    val padding: String
    def 
  }

  case class StartCond(cond: Cond) extends Renderable with DirectiveCond {
    def template = "%s"
  }

  case class AndCond(cond: Cond) extends Renderable {
    def template = "AND %s"
  }

  case class OrCond(cond: Cond) extends Renderable {
    def template = "OR %s" 
  }

  case class AndNestedCond(cond: Filtering) extends Renderable {
    def template = "OR (%s)"
  }

  case class OrNestedCond()

  // table

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

  object Modification {
    def render(change: (Col, Any)): Part = {
      change match {
        case (col, mod: Modification) =>
          mod.toPart(col)
        case (col, value) =>
          Part.create(s"${col.render} = ?", value)
      }
    }
  }

  sealed trait Modification {
    def toPart(col: Col): Part
  }

  case class Increment(amount: Int) extends Modification {
    def toPart(col: Col) = {
      Part.create(s"${col.render} = ${col.render} + $amount")
    }
  }

  case class Decrement(amount: Int) extends Modification {
    def toPart(col: Col) = {
      Part.create(s"${col.render} = ${col.render} - $amount")
    }
  }


  

  
}






