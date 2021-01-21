package kuzminki.model.insert

import kuzminki.model._


object Reuse {

  def noChange: Reuse = NoChange

  def fromIndex(insertCols: Seq[RenderableCol], reuseCols: Seq[RenderableCol]): Reuse = {

    val indexes = reuseCols.map { col =>
      insertCols.indexOf(col) match {
        case -1 =>
          throw KuzminkiException(
            "column [%s] is not among inserted columns".format("col")
          )
        case index: Int => index
      }
    }

    new ReuseIndexes(indexes.toVector)
  }
}  

trait Reuse {
  def extend(values: Vector[Any]): Vector[Any]
}

class ReuseIndexes(indexes: Vector[Int]) extends Reuse {
  def extend(values: Vector[Any]): Vector[Any] = {
    values ++ indexes.map(values)
  }
}

object NoChange extends Reuse {
  def extend(values: Vector[Any]) = values
}