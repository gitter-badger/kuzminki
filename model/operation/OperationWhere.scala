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
        paramShape.cols.map(CacheCond(_))
      )
    ).cache(paramShape)
  }

  def cacheWhere1[P](pick: M => TypeCol[P]) = {
    cache(new ParamShapeSingle(pick(model)))
  }
  
  def cacheWhere2[P1, P2](pick: M => Tuple2[TypeCol[P1], TypeCol[P2]]) = {
    cache(new ParamShape2(pick(model)))
  }

  def cacheWhere3[P1, P2, P3](pick: M => Tuple3[TypeCol[P1], TypeCol[P2], TypeCol[P3]]) = {
    cache(new ParamShape3(pick(model)))
  }

  def cacheWhere4[P1, P2, P3, P4](pick: M => Tuple4[TypeCol[P1], TypeCol[P2], TypeCol[P3], TypeCol[P4]]) = {
    cache(new ParamShape4(pick(model)))
  }

  def cacheWhere5[P1, P2, P3, P4, P5](pick: M => Tuple5[TypeCol[P1], TypeCol[P2], TypeCol[P3], TypeCol[P4], TypeCol[P5]]) = {
    cache(new ParamShape5(pick(model)))
  }
}


















