package kuzminki.model.insert

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class RunUpsert[M, S](
      protected val model: M,
                    reuse: Reuse,
                    coll: InsertCollector[S]) extends PickReturning[M, S] {

  protected def next[R](transformer: TypedTransformer[R]) = {
    new RunUpsertReturning(
      reuse,
      coll.extend(Array(
        InsertBlankValuesSec(coll.shape.size),
        ReturningSec(transformer.toSeq)
      )),
      transformer
    )
  }

  def cache = coll.cacheUpsert(reuse)

  def run(data: S) = cache.run(data)

  def runNum(data: S) = cache.runNum(data)
}