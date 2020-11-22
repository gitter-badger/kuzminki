package kuzminki

import io.rdbc.sapi._
import operators._


class Select(data: QueryData) {

  def columns(args: String*): SelectFrom = columns(args.toList.map(ColName(_)))

  def columns(args: List[TableCol]): SelectFrom = {
    val cols = args.map {
      case ColName(name) => name
      case ColNameAs(name, alias) => s"$name AS $alias"
      case AllCols => "*"
    }

    new SelectFrom(
      data.addPart(
       Part(cols.mkString(", "), Seq.empty[Any])
      )
    )
  }
}


class SelectFrom(data: QueryData) {

  def from(table: String): CondOrJoin = buildFrom(s"FROM table")

  def from(table: String, alias: String): CondOrJoin = buildFrom(s"FROM $table $alias")

  private def buildFrom(arg: String) = new CondOrJoin(data.addTmpl(arg))
}


class SelectCond(data: QueryData) extends SelectExec(data) {

  def where(args: (String, Cond)*): SelectOrder = where(args.toList)

  def where(args: List[(String, Cond)]): SelectOrder = {
    val conds = args.map {
      case (key, Eq(value)) => Arg(s"$key = ?", Some(value))
      case (key, Not(value)) => Arg(s"$key != ?", Some(value))
      case (key, Gt(value)) => Arg(s"$key > ?", Some(value))
      case (key, Gte(value)) => Arg(s"$key >= ?", Some(value))
      case (key, Lt(value)) => Arg(s"$key < ?", Some(value))
      case (key, Lte(value)) => Arg(s"$key <= ?", Some(value))
      case (key, Like(value)) => Arg(s"$key LIKE ?", Some(value))
      case (key, op) => throw new KuzminkiException(s"invalid operator ($key -> $op)")
    }

    new SelectOrder(
      data.addPart(
        Part("WHERE " + conds.map(_.tmpl).mkString(" AND "), conds.map(_.arg).flatten)
      )
    )
  }
}


class CondOrJoin(data: QueryData) extends SelectCond(data) {

  def join(table: String): JoinOn = buildJoin(s"INNER JOIN $table")

  def join(table: String, alias: String): JoinOn = buildJoin(s"INNER JOIN $table $alias")

  def innerJoin(table: String): JoinOn = buildJoin(s"INNER JOIN $table")

  def innerJoin(table: String, alias: String): JoinOn = buildJoin(s"INNER JOIN $table $alias")

  def leftJoin(table: String): JoinOn = buildJoin(s"LEFT JOIN $table")

  def leftJoin(table: String, alias: String): JoinOn = buildJoin(s"LEFT JOIN $table $alias")

  def leftOuterJoin(table: String): JoinOn = buildJoin(s"LEFT OUTER JOIN $table")

  def leftOuterJoin(table: String, alias: String): JoinOn = buildJoin(s"LEFT OUTER JOIN $table $alias")

  def rightJoin(table: String): JoinOn = buildJoin(s"RIGHT JOIN $table")

  def rightJoin(table: String, alias: String): JoinOn = buildJoin(s"RIGHT JOIN $table $alias")

  def rightOuterJoin(table: String): JoinOn = buildJoin(s"RIGHT OUTER JOIN $table")

  def rightOuterJoin(table: String, alias: String): JoinOn = buildJoin(s"RIGHT OUTER JOIN $table $alias")

  def fullOuterJoin(table: String): JoinOn = buildJoin(s"FULL OUTER JOIN $table")

  def fullOuterJoin(table: String, alias: String): JoinOn = buildJoin(s"FULL OUTER JOIN $table $alias")

  def crossJoin(table: String): JoinOn = buildJoin(s"CROSS JOIN $table")

  def crossJoin(table: String, alias: String): JoinOn = buildJoin(s"CROSS JOIN $table $alias")

  private def buildJoin(arg: String) = new JoinOn(data.addTmpl(arg))
}


class JoinOn(data: QueryData) extends  {

  def on(leftCol: String, rightCol: String) = {
    new SelectCond(data.addTmpl(s"ON $leftCol = $rightCol"))
  }
}


class SelectOrder(data: QueryData) extends SelectOffset(data) {

  def orderBy(args: Sort*): SelectOffset = orderBy(args.toList)

  def orderBy(args: List[Sort]): SelectOffset = {
    val sorts = args.map {
      case Asc(col) => s"$col ASC"
      case Desc(col) => s"$col DESC"
    }
    new SelectOffset(data.addPart(Part("ORDER BY " + sorts.mkString(", "))))
  }
}


class SelectOffset(data: QueryData) extends SelectLimit(data) {

  def offset(num: Int) = new SelectLimit(data.addTmpl(s"OFFSET $num"))
}


class SelectLimit(data: QueryData) extends SelectExec(data) {

  def limit(num: Int) = new SelectExec(data.addTmpl(s"LIMIT $num"))
}


trait NestedSelect {

  def toPart: Part

  def asNested: Part
}


class SelectExec(data: QueryData) extends NestedSelect {

  def sql: SqlWithParams = data.sql

  def toPart: Part = data.toPart

  def asNested: Part = data.asNested

  def print: Unit = {
    sql match {
      case SqlWithParams(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }
}







