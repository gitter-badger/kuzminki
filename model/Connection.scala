package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._
import kuzminki.rdbc._
import kuzminki.model.select._


trait DbConn {
  def select(statement: SqlWithParams): Future[List[Row]]
  def exec(statement: SqlWithParams): Future[Unit]
  def execNum(statement: SqlWithParams): Future[Long]
}

class DummyConn extends DbConn {
  
  def select(statement: SqlWithParams): Future[List[Row]] = {
    throw new Exception("dummy")
  }
  
  def exec(statement: SqlWithParams): Future[Unit] = {
    throw new Exception("dummy")
  }
  
  def execNum(statement: SqlWithParams): Future[Long] = {
    throw new Exception("dummy")
  }
}


case class Connection(db: DbConn, ec: ExecutionContext)
