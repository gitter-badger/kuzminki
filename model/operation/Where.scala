package kuzminki.model.operation

import kuzminki.model._


class Where[M](model: M, coll: Collector) {

  def all() = new RunOperation(model, coll)

  def whereOne(pick: M => Filter) = {
    new RunOperation(
      model,
      coll.add(
        WhereAllSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereAll(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiModelException("WHERE conditions cannot be empty")
      case conds =>
        new RunOperation(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new RunOperation(model, coll)
      case conds =>
        new RunOperation(
          model,
          coll.add(WhereAllSec(conds))
        )
    }
  }

  def cacheWhere1[R](pick: M => TypeCol[R]) = {
    new StoredOperation(coll, new TypedCols1(pick(model)))
  }
  
  def cacheWhere2[R1, R2](pick: M => Tuple2[TypeCol[R1], TypeCol[R2]]) = {
    new StoredOperation(coll, new TypedCols1(pick(model)))
  }

  def cacheWhere3[R1, R2, R3](pick: M => Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) = {
    new StoredOperation(coll, new TypedCols1(pick(model)))
  }

  def cacheWhere4[R1, R2, R3, R4](pick: M => Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) = {
    new StoredOperation(coll, new TypedCols1(pick(model)))
  }

  def cacheWhere5[R1, R2, R3, R4, R5](pick: M => Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) = {
    new StoredOperation(coll, new TypedCols1(pick(model)))
  }
}


















