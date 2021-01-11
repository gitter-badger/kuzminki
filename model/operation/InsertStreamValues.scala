package kuzminki.model.operation

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import kuzminki.model._


class InsertStreamOptions[M <: Model, T](model: M, coll: InsertCollector[T]) extends InsertStreamRun(model, coll) {

  def whereNotExistsOne(pick: M => ModelCol) = {
    whereNotExistsApply(
      Seq(pick(model))
    )
  }

  def whereNotExistsAll(pick: M => Seq[ModelCol]) = {
    whereNotExistsApply(pick(model))
  }

  private def whereNotExistsApply(uniqueCols: Seq[ModelCol]) = {

    val insertCols = coll.form.colSeq

    val indexes = uniqueCols.map { col => 
      insertCols.indexOf(col) match {
        case -1 => throw KuzminkiModelException(s"column [%s] is not among inserted columns")
        case index: Int => index
      }
    }

    new InsertStreamUniqueRun(
      model,
      indexes.toVector,
      coll.add(
        InsertBlankWhereNotExistsSec(
          coll.form.size,
          ModelTable(model),
          WhereAllSec(
            uniqueCols.map(FilterMatchesNoArg(_))
          )
        )
      )
    )
  }
}


class InsertStreamRun[M, T](model: M, coll: InsertCollector[T]) {

  def cache = coll.add(InsertBlankValuesSec(coll.form.size)).cache

  def run(data: T) = cache.run(data)

  def runNum(data: T) = cache.runNum(data)

  def stream(source: Source[T, NotUsed]) = cache.stream(source)

  def streamList(data: List[T]) = stream(Source(data))
}


class InsertStreamUniqueRun[M, T](model: M, indexes: Vector[Int], coll: InsertCollector[T]) {

  def cache = coll.cacheUnique(indexes)

  def run(data: T) = cache.run(data)

  def runNum(data: T) = cache.runNum(data)

  def stream(source: Source[T, NotUsed]) = cache.stream(source)

  def streamList(data: List[T]) = cache.stream(Source(data))
}









