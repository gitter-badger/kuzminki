package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done
import io.rdbc.sapi.SqlWithParams


class StoredSelect[R](
      db: Conn,
      statement: SqlWithParams,
      rowConv: RowConv[R]
    ) extends SelectSubquery[R] {
  
  def run() = {
    db.select(statement) { row =>
      rowConv.fromRow(row)
    }  
  }

  def first() = {
    db.selectHeadOption(statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    db.select(statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def firstAs[T](implicit custom: R => T) = {
    db.selectHeadOption(statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def runCount() = {
    db.count(statement)
  }

  def stream(sink: Sink[R, Future[Done]]) = {
    db.stream(statement, sink) { row =>
      rowConv.fromRow(row)
    }
  }

  def streamAs[T](sink: Sink[T, Future[Done]])(implicit custom: R => T) = {
    db.stream(statement, sink) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }
  }

  def render(prefix: Prefix) = statement.sql
  
  def args = statement.params.toSeq
  
  def renderTo(printer: String => Unit): Unit = {
    printer(statement.sql)
  }
}





















