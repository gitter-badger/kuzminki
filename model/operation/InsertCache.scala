package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


trait ExtendedTemplate[T] {

  protected def transform(data: T): Vector[Any]

  private def  extend(template: String, num: Int) = {
    template + ", " + Seq.fill(num -1)(template.split(" VALUES ").last).mkString(", ")
  }

  protected def extendedTemplate(template: String, list: List[T]) = {
    list.size match {
      case 0 =>
        throw KuzminkiModelException("insert data list empty")
      case 1 =>
        SqlWithParams(template, transform(list.head))
      case _ =>
        SqlWithParams(
          extend(template, list.size),
          list.map(transform).flatten.toVector
        )
    }
  }
}

class InsertCache[T](template: String, form: InsertForm[T], db: Conn) extends ExtendedTemplate[T] {

  protected def transform(data: T) = form.toVector(data)

  def run(data: T) = {
    db.exec(SqlWithParams(template, transform(data)))
  }

  def runNum(data: T) = {
    db.execNum(SqlWithParams(template, transform(data)))
  }

  def list(list: List[T]) = {
    db.exec(extendedTemplate(template, list))
  }

  def listNum(list: List[T]) = {
    db.execNum(extendedTemplate(template, list))
  }

  def stream(source: Source[T, NotUsed]) = {
    db.insertStream(
      template,
      source.map(data => transform(data))
    )
  }

  def streamList(data: List[T]) = stream(Source(data))
}


class InsertCacheUnique[T](template: String, form: InsertForm[T], indexes: Vector[Int], db: Conn) {

  private def transform(data: T) = {
    val values = form.toVector(data)
    val duplicates = indexes.map(i => values(i))
    values ++ duplicates
  }

  def run(data: T) = {
    db.exec(SqlWithParams(template, transform(data)))
  }

  def runNum(data: T) = {
    db.execNum(SqlWithParams(template, transform(data)))
  }

  def stream(source: Source[T, NotUsed]) = {
    db.insertStream(
      template,
      source.map(data => transform(data))
    )
  }

  def streamList(data: List[T]) = stream(Source(data))
}


