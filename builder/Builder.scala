package kuzminki

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import io.rdbc.sapi._
import kuzminki.containers._
import kuzminki.implicits._


case class Arg(tmpl: String, arg: Option[Any])


object Part {
  def create(tmpl: String) = Part(tmpl, Seq.empty[Any])
  def create(tmpl: String, value: Any) = Part(tmpl, Seq(value))
}

case class Part(tmpl: String, args: Seq[Any])


object PartCollector {
  
  def init = PartCollector(Vector.empty[Part])
  
  def create(part: Part) = PartCollector(Vector(part))

  def start(tmpl: String) = create(Part.create(tmpl))
}


case class PartCollector(parts: Vector[Part]) {
  
  def add(part: Part) = PartCollector(parts :+ part)

  def add(tmpl: String) = PartCollector(parts :+ Part.create(tmpl))

  def add(tmpl: String, args: Seq[Any]) = PartCollector(parts :+ Part(tmpl, args))

  def extend(extension: Seq[Part]) = PartCollector(parts ++ extension)

  def toPart = Part(parts.map(_.tmpl).mkString(" "), parts.map(_.args).flatten)

  def asNested = Part("(" + parts.map(_.tmpl).mkString(" ") + ")", parts.map(_.args).flatten)

  def sql = SqlWithParams(parts.map(_.tmpl).mkString(" "), parts.map(_.args).flatten)
}


object Builder {
  
  def select(cols: Column*) = new Select(PartCollector.start("SELECT")).columnsList(cols.toList)

  def select(cols: List[Column]) = new Select(PartCollector.start("SELECT")).columnsList(cols)

  def insert = new Insert(PartCollector.init)

  def update(table: TableName) = new Update(PartCollector.init).table(table)
}













