package kuzminki.model

import akka.stream.scaladsl._
import akka.{NotUsed, Done}


class RunInsertDoNothing[M, P](
      model: M,
      coll: InsertCollector[P]
    ) extends PickInsertDoNothingReturning(model, coll) {

  def cache = coll.cacheInsertDoNothing

  def run(params: P) = cache.run(params)

  def runNum(params: P) = cache.runNum(params)
}