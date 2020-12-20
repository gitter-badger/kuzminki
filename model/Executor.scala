package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._


trait Executor {
  val ec: ExecutionContext
  def select(template: String, args: Seq[Any]): Future[List[Row]]
}