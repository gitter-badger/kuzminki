package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class InsertCache[T](template: String, form: InsertForm[T], db: Conn) {

  def run(data: T) = {
    db.exec(SqlWithParams(template, form.toVector(data)))
  }

  def runNum(data: T) = {
    db.execNum(SqlWithParams(template, form.toVector(data)))
  }

  def stream(source: Source[T, NotUsed]) = {
    db.insertStream(
      template,
      source.map(data => form.toVector(data))
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