package kuzminki.model.insert

import kuzminki.model._


object ValueReuse {

  def create(insertCols: Seq[ModelCol], reuseCols: Seq[ModelCol]) = {
    
    val indexes = reuseCols.map { col =>
      insertCols.indexOf(col) match {
        case -1 =>
          throw KuzminkiModelException(
            "column [%s] is not among inserted columns".format(col.name)
          )
        case index: Int => index
      }
    }

    new ValueReuse(indexes)
  }
}  


class ValueReuse(indexes: Vector[Int]) {

  def extend(values: Vector[Any]): Vector[Any] = {
    values ++ indexes.map(values)
  }
}