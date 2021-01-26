package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done


class RunSelect[R](coll: SelectCollector[R]) extends SelectSubquery[R] {
  
  def cache = new StoredSelect(coll.db, coll.statement, coll.rowShape.conv)

  def run() = cache.run()

  def first() = cache.first()

  def runAs[T](implicit custom: R => T) = cache.runAs(custom)

  def firstAs[T](implicit custom: R => T) = cache.firstAs(custom)

  def stream(sink: Sink[R, Future[Done]]) = cache.stream(sink)

  def streamAs[T](sink: Sink[T, Future[Done]])(implicit custom: R => T) = cache.streamAs(sink)(custom)

  def render(prefix: Prefix) = coll.render
  
  def args = coll.args

  def renderTo(printer: String => Unit): Unit = {
    printer(coll.render)
  }
}





















