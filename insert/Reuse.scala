package kuzminki.model


object Reuse {

  def noChange: Reuse = NoChange

  def fromIndex(insertCols: Seq[AnyCol], reuseCols: Seq[AnyCol]): Reuse = {

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
  val indexes: Vector[Int]
  def extend(values: Vector[Any]): Vector[Any]
}

class ReuseIndexes(val indexes: Vector[Int]) extends Reuse {
  def extend(values: Vector[Any]): Vector[Any] = {
    values ++ indexes.map(values)
  }
}

object NoChange extends Reuse {
  val indexes = Vector.empty[Int]
  def extend(values: Vector[Any]) = values
}