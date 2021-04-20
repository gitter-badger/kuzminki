package kuzminki.model


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done
import io.rdbc.sapi.SqlWithParams


class StoredSelectWhere[P, R](
      db: Conn,
      template: String,
      firstArgs: Vector[Any],
      lastArgs: Vector[Any],
      paramConv: ParamConv[P],
      rowConv: RowConv[R]
    ) {

  def transformParams(params: P) = {
    firstArgs ++ paramConv.fromShape(params) ++ lastArgs
  }

  def statement(params: P) = {
    SqlWithParams(
      template,
      transformParams(params)
    )
  }
  
  def run(params: P) = {
    db.select(statement(params)) { row =>
      rowConv.fromRow(row)
    }  
  }

  def first(params: P) = {
    db.selectHeadOption(statement(params)) { row =>
      rowConv.fromRow(row)
    }
  }

  def runAs[T](params: P)(implicit custom: R => T) = {
    db.select(statement(params)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def firstAs[T](params: P)(implicit custom: R => T) = {
    db.selectHeadOption(statement(params)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def stream(params: P, sink: Sink[R, Future[Done]]) = {
    db.stream(statement(params), sink) { row =>
      rowConv.fromRow(row)
    }
  }

  def streamAs[T](params: P, sink: Sink[T, Future[Done]])(implicit custom: R => T) = {
    db.stream(statement(params), sink) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }
  }

  def render(prefix: Prefix) = template
  
  def args = firstArgs ++ lastArgs

  def sql(handler: String => Unit): StoredSelectWhere[P, R] = {
    handler(template)
    this
  }
}





















