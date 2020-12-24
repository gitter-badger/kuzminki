package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._
import kuzminki.rdbc._
import kuzminki.model.select._


trait DbConn {
  def select(query: Query): Future[List[Row]]
}

class DummyConn extends DbConn {
  def select(query: Query): Future[List[Row]] = {
    throw new Exception("dummy")
  }
}


case class Connection(db: DbConn, ec: ExecutionContext)
