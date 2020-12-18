package kuzminki.model

import scala.concurrent.Future


trait Executor {
  def run(sections: ModelCollector): Future[List[Seq[Any]]]
}