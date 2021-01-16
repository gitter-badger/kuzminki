package kuzminki.model.operation

import kuzminki.model._
import kuzminki.model.insert.{InsertShape, InsertShape1, InsertShape2, InsertShape3, InsertShape4, InsertShape5}


class Where[M](model: M, coll: OpCollector) {

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

  private def cache[S](shape: InsertShape[S]) = {
    coll.add(
      WhereAllSec(
        shape.cols.map(NoArgMatches(_))
      )
    ).cache(shape)
  }

  def cacheWhere1[R](pick: M => TypeCol[R]) = {
    cache(new InsertShape1(pick(model)))
  }
  
  def cacheWhere2[R1, R2](pick: M => Tuple2[TypeCol[R1], TypeCol[R2]]) = {
    cache(new InsertShape2(pick(model)))
  }

  def cacheWhere3[R1, R2, R3](pick: M => Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) = {
    cache(new InsertShape3(pick(model)))
  }

  def cacheWhere4[R1, R2, R3, R4](pick: M => Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) = {
    cache(new InsertShape4(pick(model)))
  }

  def cacheWhere5[R1, R2, R3, R4, R5](pick: M => Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) = {
    cache(new InsertShape5(pick(model)))
  }
}


















