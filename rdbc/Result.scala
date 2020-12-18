package kuzminki.rdbc

import scala.concurrent.ExecutionContext
import scala.concurrent.{Future, Promise}
import scala.util.{Try, Success, Failure}
import scala.concurrent.duration._

import io.rdbc.sapi._

import io.rdbc.pgsql.core.config.sapi.Auth
import io.rdbc.pgsql.transport.netty.sapi.NettyPgConnectionFactory
import io.rdbc.pgsql.transport.netty.sapi.NettyPgConnectionFactory.Config

import io.rdbc.pool.sapi.ConnectionPool
import io.rdbc.pool.sapi.ConnectionPoolConfig



trait ResponseData {

  def res: Future[List[Row]]

  def head[T](implicit format: RowFormat[T]): Future[T]

  def headOpt[T](implicit format: RowFormat[T]): Future[Option[T]]

  def list[T](implicit format: RowFormat[T]): Future[List[T]]
}


object ResponseData {
  def apply(response: Future[List[Row]])(implicit ec: ExecutionContext) = new ResponseWrapper(response)
} 


class ResponseWrapper(response: Future[List[Row]])(implicit ec: ExecutionContext) extends ResponseData {

  def res: Future[List[Row]] = response

  def head[T](implicit format: RowFormat[T]): Future[T] = {
    response.map(rows => format.resolve(rows.head))
  }

  def headOpt[T](implicit format: RowFormat[T]): Future[Option[T]] = {
    response.map { rows =>
      rows.headOption match {
        case Some(row) => Some(format.resolve(row))
        case None => None
      }
    }
  }

  def list[T](implicit format: RowFormat[T]): Future[List[T]] = {
    response.map(rows => rows.map(row => format.resolve(row)))
  }
}












