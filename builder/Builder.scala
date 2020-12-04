package kuzminki

import scala.collection.mutable.ArrayBuffer
import io.rdbc.sapi._
import operators._
import columns._


case class Arg(tmpl: String, arg: Option[Any])


object Part {
  def create(tmpl: String) = Part(tmpl, Seq.empty[Any])
  def create(tmpl: String, value: Any) = Part(tmpl, Seq(value))
}

case class Part(tmpl: String, args: Seq[Any])


object PartCollector {
  
  def init = PartCollector(Vector.empty[Part])
  
  def create(part: Part) = PartCollector(Vector(part))
}


case class PartCollector(parts: Vector[Part]) {
  
  def add(part: Part) = PartCollector(parts :+ part)

  def add(tmpl: String) = PartCollector(parts :+ Part.create(tmpl))

  def add(tmpl: String, args: Seq[Any]) = PartCollector(parts :+ Part(tmpl, args))

  def extend(extension: Seq[Part]) = PartCollector(parts ++ extension)

  def sql = SqlWithParams(parts.map(_.tmpl).mkString(" "), parts.map(_.args).flatten)

  def toPart = Part(parts.map(_.tmpl).mkString(" "), parts.map(_.args).flatten)

  def asNested = Part("(" + parts.map(_.tmpl).mkString(" ") + ")", parts.map(_.args).flatten)
}


object Builder {
  
  def select(args: String*) = new Select(PartCollector.init).columns(args.toList.map(Col(_)))

  def select(args: List[Col]) = new Select(PartCollector.init).columns(args)

  def insert = new Insert(PartCollector.init)

  def update(table: String) = new Update(PartCollector.init).table(table)
}