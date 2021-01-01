package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._
import kuzminki.rdbc._
import kuzminki.model.select._


trait Conn {
  def select[R](statement: SqlWithParams)(transform: Row => R): Future[List[R]]
  def selectHead[R](statement: SqlWithParams)(transform: Row => R): Future[R]
  def selectHeadOption[R](statement: SqlWithParams)(transform: Row => R): Future[Option[R]]
  def exec(statement: SqlWithParams): Future[Unit]
  def execNum(statement: SqlWithParams): Future[Long]
}

class DummyConn extends Conn {
  
  def select[R](statement: SqlWithParams)(transform: Row => R): Future[List[R]] = {
    throw new Exception("dummy")
  }

  def selectHead[R](statement: SqlWithParams)(transform: Row => R): Future[R] = {
    throw new Exception("dummy")
  }

  def selectHeadOption[R](statement: SqlWithParams)(transform: Row => R): Future[Option[R]] = {
    throw new Exception("dummy")
  }
  
  def exec(statement: SqlWithParams): Future[Unit] = {
    throw new Exception("dummy")
  }
  
  def execNum(statement: SqlWithParams): Future[Long] = {
    throw new Exception("dummy")
  }
}


