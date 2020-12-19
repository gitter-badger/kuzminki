package kuzminki.model

import scala.concurrent.Future
import io.rdbc.sapi._


trait Executor {
  def run(template: String, args: Seq[Any]): Future[List[Row]]
}