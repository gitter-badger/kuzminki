package kuzminki.model


class OperationWhere[M](model: M, coll: OperationCollector) {

  def all() = new RunOperation(model, coll)

  def whereOne(pick: M => Filter) = {
    new RunOperation(
      model,
      coll.add(
        WhereSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereAll(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiException("WHERE conditions cannot be empty")
      case conds =>
        new RunOperation(
          model,
          coll.add(WhereSec(conds))
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
          coll.add(WhereSec(conds))
        )
    }
  }

  private def cache[P](paramShape: ParamShape[P]) = {
    coll.add(
      WhereSec(
        paramShape.cols.map(NoArgMatches(_))
      )
    ).cache(paramShape)
  }

  def cacheWhere1[R](pick: M => TypeCol[R]) = {
    cache(new ParamShapeSingle(pick(model)))
  }
  
  def cacheWhere2[R1, R2](pick: M => Tuple2[TypeCol[R1], TypeCol[R2]]) = {
    cache(new ParamShape2(pick(model)))
  }

  def cacheWhere3[R1, R2, R3](pick: M => Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) = {
    cache(new ParamShape3(pick(model)))
  }

  def cacheWhere4[R1, R2, R3, R4](pick: M => Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) = {
    cache(new ParamShape4(pick(model)))
  }

  def cacheWhere5[R1, R2, R3, R4, R5](pick: M => Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) = {
    cache(new ParamShape5(pick(model)))
  }
}


















