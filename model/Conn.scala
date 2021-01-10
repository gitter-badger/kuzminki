package kuzminki.model

import org.reactivestreams.Publisher
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi._
import kuzminki.rdbc._
import kuzminki.model.select._


trait Conn {
  def select[R](statement: SqlWithParams)(transform: Row => R): Future[List[R]]
  def selectHead[R](statement: SqlWithParams)(transform: Row => R): Future[R]
  def selectHeadOption[R](statement: SqlWithParams)(transform: Row => R): Future[Option[R]]
  def exec(statement: SqlWithParams): Future[Unit]
  def execNum(statement: SqlWithParams): Future[Long]
  def stream[R](statement: SqlWithParams, sink: Sink[R, Future[Done]])(transform: Row => R): Future[Done]
  def insertStream(template: String, source: Source[Vector[Any], NotUsed]): Future[Unit]
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

  def stream[R](statement: SqlWithParams, sink: Sink[R, Future[Done]])(transform: Row => R): Future[Done] = {
    throw new Exception("dummy")
  }

  def insertStream(template: String, source: Source[Vector[Any], NotUsed]): Future[Unit] = {
    throw new Exception("dummy")
  }
}


