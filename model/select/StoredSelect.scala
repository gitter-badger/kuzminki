package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done
import io.rdbc.sapi.SqlWithParams


class StoredSelect[R](
      db: Conn,
      statement: SqlWithParams,
      outShape: RowShape[R]
    ) extends SelectSubquery[R] {
  
  def run() = {
    db.select(statement) { row =>
      outShape.fromRow(row)
    }  
  }

  def first() = {
    db.selectHeadOption(statement) { row =>
      outShape.fromRow(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    db.select(statement) { row =>
      custom(
        outShape.fromRow(row)
      )
    }  
  }

  def firstAs[T](implicit custom: R => T) = {
    db.selectHeadOption(statement) { row =>
      custom(
        outShape.fromRow(row)
      )
    }  
  }

  def stream(sink: Sink[R, Future[Done]]) = {
    db.stream(statement, sink) { row =>
      outShape.fromRow(row)
    }
  }

  def streamAs[T](sink: Sink[T, Future[Done]])(implicit custom: R => T) = {
    db.stream(statement, sink) { row =>
      custom(
        outShape.fromRow(row)
      )
    }
  }

  def render = statement.sql
  def prefix(picker: Prefix) = statement.sql
  def args = statement.params.toSeq

  def renderTo(printer: String => Unit) = {
    printer(statement.sql)
    this
  }
}





















