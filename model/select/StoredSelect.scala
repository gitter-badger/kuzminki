package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done
import io.rdbc.sapi.SqlWithParams


class StoredSelect[R](
      db: Conn,
      statement: SqlWithParams,
      conv: RowConv[R]
    ) extends SelectSubquery[R] {
  
  def run() = {
    db.select(statement) { row =>
      conv.fromRow(row)
    }  
  }

  def first() = {
    db.selectHeadOption(statement) { row =>
      conv.fromRow(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    db.select(statement) { row =>
      custom(
        conv.fromRow(row)
      )
    }  
  }

  def firstAs[T](implicit custom: R => T) = {
    db.selectHeadOption(statement) { row =>
      custom(
        conv.fromRow(row)
      )
    }  
  }

  def stream(sink: Sink[R, Future[Done]]) = {
    db.stream(statement, sink) { row =>
      conv.fromRow(row)
    }
  }

  def streamAs[T](sink: Sink[T, Future[Done]])(implicit custom: R => T) = {
    db.stream(statement, sink) { row =>
      custom(
        conv.fromRow(row)
      )
    }
  }

  def render(prefix: Prefix) = statement.sql
  def args = statement.params.toSeq

  def renderTo(printer: String => Unit) = {
    printer(statement.sql)
    this
  }
}





















