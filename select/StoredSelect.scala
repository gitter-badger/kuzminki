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

  def runAs[T](implicit custom: R => T) = {
    db.select(statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def headOpt() = {
    db.selectHeadOption(statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def headOptAs[T](implicit custom: R => T) = {
    db.selectHeadOption(statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def runCount() = {
    db.count(statement)
  }

  def source = {
    db.streamAsSource(statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def render(prefix: Prefix) = statement.sql
  
  def args = statement.params.toSeq
  
  def sql(handler: String => Unit) = {
    handler(statement.sql)
    this
  }
}





















