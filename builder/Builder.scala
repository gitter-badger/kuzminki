package kuzminki

import scala.collection.mutable.ArrayBuffer
import io.rdbc.sapi._
import operators._


case class Arg(tmpl: String, arg: Option[Any])
case class Part(tmpl: String, args: Seq[Any] = Seq.empty[Any])


object QueryData {
  
  def init = QueryData(Vector.empty[Part])
  
  def create(part: Part) = QueryData(Vector(part))
}


case class QueryData(parts: Vector[Part]) {
  
  def addPart(part: Part) = QueryData(parts :+ part)

  def addTmpl(tmpl: String) = QueryData(parts :+ Part(tmpl))

  def addData(tmpl: String, args: Seq[Any]) = QueryData(parts :+ Part(tmpl, args))

  def sql = SqlWithParams(parts.map(_.tmpl).mkString(" "), parts.map(_.args).flatten)

  def toPart = Part(parts.map(_.tmpl).mkString(" "), parts.map(_.args).flatten)

  def asNested = Part("(" + parts.map(_.tmpl).mkString(" ") + ")", parts.map(_.args).flatten)
}


object Builder {
  
  def select(args: String*) = new Select(QueryData.init).columns(args.toList.map(ColName(_)))

  def select(args: List[TableCol]) = new Select(QueryData.init).columns(args)

  def insert = new Insert(QueryData.init)

  def update(table: String) = new Update(QueryData.init).table(table)
}