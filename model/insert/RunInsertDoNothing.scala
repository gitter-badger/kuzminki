package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class RunInsertDoNothing[M, S](
      model: M,
      coll: InsertCollector[S]
    ) extends PickInsertDoNothingReturning(model, coll) {

  def cache = coll.cacheInsertDoNothing

  def run(data: S) = cache.run(data)

  def runNum(data: S) = cache.runNum(data)
}