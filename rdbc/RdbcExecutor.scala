package kuzminki.rdbc

import scala.concurrent.Future
import kuzminki.model.Executor


class RdbcExecutor(db: RdbcConn) extends Executor {

  def run(template: String, args: Seq[Any]) = {
    db.modelSelect(template, args)
  }
}