package kuzminki

import scala.annotation.tailrec
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

  def start(tmpl: String) = create(Part.create(tmpl))

  def join(glue: Part, items: List[Part]): Seq[Part] = {
    
    @tailrec
    def connect(old: List[Part], joined: Seq[Part]): Seq[Part] = {
      old match {
        case head :: tail =>
          connect(tail, joined ++ Seq(head, glue))
        case Nil =>
          joined.dropRight(1)
      }
    }

    connect(items, Seq.empty[Part])
  }
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
  
  def select(args: String*) = new Select(PartCollector.start("SELECT")).columns(args.toList.map(Col(_)))

  def select(args: List[Col]) = new Select(PartCollector.start("SELECT")).columns(args)

  def insert = new Insert(PartCollector.init)

  def update(table: String) = new Update(PartCollector.init).table(table)
}