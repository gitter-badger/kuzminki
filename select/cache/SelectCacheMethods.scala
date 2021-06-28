package kuzminki.model


abstract class SelectCacheMethods[M, R](model: M, coll: SelectCollector[R]) {

  def cacheWhere1[P](pick: M => CacheCond[P]) = {
    coll.cacheWhere(new CondShapeSingle(pick(model)))
  }

  def cacheWhereWithOffset1[P](pick: M => CacheCond[P]) = {
    coll.cacheWhereWithOffset(new CondShapeSingle(pick(model)))
  }

  def cacheHaving1[P](pick: M => CacheCond[P]) = {
    coll.cacheHaving(new CondShapeSingle(pick(model)))
  }

  def cacheHavingWithOffset1[P](pick: M => CacheCond[P]) = {
    coll.cacheHavingWithOffset(new CondShapeSingle(pick(model)))
  }

  def cacheWhere2[P1, P2](
        pick: M => Tuple2[CacheCond[P1], CacheCond[P2]]
      ) = {
    coll.cacheWhere(new CondShape2(pick(model)))
  }

  def cacheWhereWithOffset2[P1, P2](
        pick: M => Tuple2[CacheCond[P1], CacheCond[P2]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape2(pick(model)))
  }

  def cacheHaving2[P1, P2](
        pick: M => Tuple2[CacheCond[P1], CacheCond[P2]]
      ) = {
    coll.cacheHaving(new CondShape2(pick(model)))
  }

  def cacheHavingWithOffset2[P1, P2](
        pick: M => Tuple2[CacheCond[P1], CacheCond[P2]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape2(pick(model)))
  }

  def cacheWhere3[P1, P2, P3](
        pick: M => Tuple3[CacheCond[P1], CacheCond[P2], CacheCond[P3]]
      ) = {
    coll.cacheWhere(new CondShape3(pick(model)))
  }

  def cacheWhereWithOffset3[P1, P2, P3](
        pick: M => Tuple3[CacheCond[P1], CacheCond[P2], CacheCond[P3]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape3(pick(model)))
  }

  def cacheHaving3[P1, P2, P3](
        pick: M => Tuple3[CacheCond[P1], CacheCond[P2], CacheCond[P3]]
      ) = {
    coll.cacheHaving(new CondShape3(pick(model)))
  }

  def cacheHavingWithOffset3[P1, P2, P3](
        pick: M => Tuple3[CacheCond[P1], CacheCond[P2], CacheCond[P3]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape3(pick(model)))
  }

  def cacheWhere4[P1, P2, P3, P4](
        pick: M => Tuple4[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4]]
      ) = {
    coll.cacheWhere(new CondShape4(pick(model)))
  }

  def cacheWhereWithOffset4[P1, P2, P3, P4](
        pick: M => Tuple4[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape4(pick(model)))
  }

  def cacheHaving4[P1, P2, P3, P4](
        pick: M => Tuple4[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4]]
      ) = {
    coll.cacheHaving(new CondShape4(pick(model)))
  }

  def cacheHavingWithOffset4[P1, P2, P3, P4](
        pick: M => Tuple4[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape4(pick(model)))
  }

  def cacheWhere5[P1, P2, P3, P4, P5](
        pick: M => Tuple5[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5]]
      ) = {
    coll.cacheWhere(new CondShape5(pick(model)))
  }

  def cacheWhereWithOffset5[P1, P2, P3, P4, P5](
        pick: M => Tuple5[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape5(pick(model)))
  }

  def cacheHaving5[P1, P2, P3, P4, P5](
        pick: M => Tuple5[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5]]
      ) = {
    coll.cacheHaving(new CondShape5(pick(model)))
  }

  def cacheHavingWithOffset5[P1, P2, P3, P4, P5](
        pick: M => Tuple5[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape5(pick(model)))
  }

  def cacheWhere6[P1, P2, P3, P4, P5, P6](
        pick: M => Tuple6[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6]]
      ) = {
    coll.cacheWhere(new CondShape6(pick(model)))
  }

  def cacheWhereWithOffset6[P1, P2, P3, P4, P5, P6](
        pick: M => Tuple6[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape6(pick(model)))
  }

  def cacheHaving6[P1, P2, P3, P4, P5, P6](
        pick: M => Tuple6[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6]]
      ) = {
    coll.cacheHaving(new CondShape6(pick(model)))
  }

  def cacheHavingWithOffset6[P1, P2, P3, P4, P5, P6](
        pick: M => Tuple6[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape6(pick(model)))
  }

  def cacheWhere7[P1, P2, P3, P4, P5, P6, P7](
        pick: M => Tuple7[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7]]
      ) = {
    coll.cacheWhere(new CondShape7(pick(model)))
  }

  def cacheWhereWithOffset7[P1, P2, P3, P4, P5, P6, P7](
        pick: M => Tuple7[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape7(pick(model)))
  }

  def cacheHaving7[P1, P2, P3, P4, P5, P6, P7](
        pick: M => Tuple7[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7]]
      ) = {
    coll.cacheHaving(new CondShape7(pick(model)))
  }

  def cacheHavingWithOffset7[P1, P2, P3, P4, P5, P6, P7](
        pick: M => Tuple7[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape7(pick(model)))
  }

  def cacheWhere8[P1, P2, P3, P4, P5, P6, P7, P8](
        pick: M => Tuple8[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8]]
      ) = {
    coll.cacheWhere(new CondShape8(pick(model)))
  }

  def cacheWhereWithOffset8[P1, P2, P3, P4, P5, P6, P7, P8](
        pick: M => Tuple8[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape8(pick(model)))
  }

  def cacheHaving8[P1, P2, P3, P4, P5, P6, P7, P8](
        pick: M => Tuple8[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8]]
      ) = {
    coll.cacheHaving(new CondShape8(pick(model)))
  }

  def cacheHavingWithOffset8[P1, P2, P3, P4, P5, P6, P7, P8](
        pick: M => Tuple8[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape8(pick(model)))
  }

  def cacheWhere9[P1, P2, P3, P4, P5, P6, P7, P8, P9](
        pick: M => Tuple9[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9]]
      ) = {
    coll.cacheWhere(new CondShape9(pick(model)))
  }

  def cacheWhereWithOffset9[P1, P2, P3, P4, P5, P6, P7, P8, P9](
        pick: M => Tuple9[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape9(pick(model)))
  }

  def cacheHaving9[P1, P2, P3, P4, P5, P6, P7, P8, P9](
        pick: M => Tuple9[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9]]
      ) = {
    coll.cacheHaving(new CondShape9(pick(model)))
  }

  def cacheHavingWithOffset9[P1, P2, P3, P4, P5, P6, P7, P8, P9](
        pick: M => Tuple9[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape9(pick(model)))
  }

  def cacheWhere10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10](
        pick: M => Tuple10[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10]]
      ) = {
    coll.cacheWhere(new CondShape10(pick(model)))
  }

  def cacheWhereWithOffset10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10](
        pick: M => Tuple10[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape10(pick(model)))
  }

  def cacheHaving10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10](
        pick: M => Tuple10[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10]]
      ) = {
    coll.cacheHaving(new CondShape10(pick(model)))
  }

  def cacheHavingWithOffset10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10](
        pick: M => Tuple10[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape10(pick(model)))
  }

  def cacheWhere11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11](
        pick: M => Tuple11[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11]]
      ) = {
    coll.cacheWhere(new CondShape11(pick(model)))
  }

  def cacheWhereWithOffset11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11](
        pick: M => Tuple11[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape11(pick(model)))
  }

  def cacheHaving11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11](
        pick: M => Tuple11[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11]]
      ) = {
    coll.cacheHaving(new CondShape11(pick(model)))
  }

  def cacheHavingWithOffset11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11](
        pick: M => Tuple11[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape11(pick(model)))
  }

  def cacheWhere12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12](
        pick: M => Tuple12[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12]]
      ) = {
    coll.cacheWhere(new CondShape12(pick(model)))
  }

  def cacheWhereWithOffset12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12](
        pick: M => Tuple12[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape12(pick(model)))
  }

  def cacheHaving12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12](
        pick: M => Tuple12[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12]]
      ) = {
    coll.cacheHaving(new CondShape12(pick(model)))
  }

  def cacheHavingWithOffset12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12](
        pick: M => Tuple12[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape12(pick(model)))
  }

  def cacheWhere13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13](
        pick: M => Tuple13[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13]]
      ) = {
    coll.cacheWhere(new CondShape13(pick(model)))
  }

  def cacheWhereWithOffset13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13](
        pick: M => Tuple13[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape13(pick(model)))
  }

  def cacheHaving13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13](
        pick: M => Tuple13[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13]]
      ) = {
    coll.cacheHaving(new CondShape13(pick(model)))
  }

  def cacheHavingWithOffset13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13](
        pick: M => Tuple13[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape13(pick(model)))
  }

  def cacheWhere14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14](
        pick: M => Tuple14[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14]]
      ) = {
    coll.cacheWhere(new CondShape14(pick(model)))
  }

  def cacheWhereWithOffset14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14](
        pick: M => Tuple14[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape14(pick(model)))
  }

  def cacheHaving14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14](
        pick: M => Tuple14[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14]]
      ) = {
    coll.cacheHaving(new CondShape14(pick(model)))
  }

  def cacheHavingWithOffset14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14](
        pick: M => Tuple14[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape14(pick(model)))
  }

  def cacheWhere15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15](
        pick: M => Tuple15[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15]]
      ) = {
    coll.cacheWhere(new CondShape15(pick(model)))
  }

  def cacheWhereWithOffset15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15](
        pick: M => Tuple15[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape15(pick(model)))
  }

  def cacheHaving15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15](
        pick: M => Tuple15[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15]]
      ) = {
    coll.cacheHaving(new CondShape15(pick(model)))
  }

  def cacheHavingWithOffset15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15](
        pick: M => Tuple15[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape15(pick(model)))
  }

  def cacheWhere16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16](
        pick: M => Tuple16[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16]]
      ) = {
    coll.cacheWhere(new CondShape16(pick(model)))
  }

  def cacheWhereWithOffset16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16](
        pick: M => Tuple16[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape16(pick(model)))
  }

  def cacheHaving16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16](
        pick: M => Tuple16[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16]]
      ) = {
    coll.cacheHaving(new CondShape16(pick(model)))
  }

  def cacheHavingWithOffset16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16](
        pick: M => Tuple16[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape16(pick(model)))
  }

  def cacheWhere17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17](
        pick: M => Tuple17[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17]]
      ) = {
    coll.cacheWhere(new CondShape17(pick(model)))
  }

  def cacheWhereWithOffset17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17](
        pick: M => Tuple17[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape17(pick(model)))
  }

  def cacheHaving17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17](
        pick: M => Tuple17[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17]]
      ) = {
    coll.cacheHaving(new CondShape17(pick(model)))
  }

  def cacheHavingWithOffset17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17](
        pick: M => Tuple17[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape17(pick(model)))
  }

  def cacheWhere18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18](
        pick: M => Tuple18[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18]]
      ) = {
    coll.cacheWhere(new CondShape18(pick(model)))
  }

  def cacheWhereWithOffset18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18](
        pick: M => Tuple18[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape18(pick(model)))
  }

  def cacheHaving18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18](
        pick: M => Tuple18[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18]]
      ) = {
    coll.cacheHaving(new CondShape18(pick(model)))
  }

  def cacheHavingWithOffset18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18](
        pick: M => Tuple18[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape18(pick(model)))
  }

  def cacheWhere19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19](
        pick: M => Tuple19[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19]]
      ) = {
    coll.cacheWhere(new CondShape19(pick(model)))
  }

  def cacheWhereWithOffset19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19](
        pick: M => Tuple19[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape19(pick(model)))
  }

  def cacheHaving19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19](
        pick: M => Tuple19[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19]]
      ) = {
    coll.cacheHaving(new CondShape19(pick(model)))
  }

  def cacheHavingWithOffset19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19](
        pick: M => Tuple19[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape19(pick(model)))
  }

  def cacheWhere20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20](
        pick: M => Tuple20[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20]]
      ) = {
    coll.cacheWhere(new CondShape20(pick(model)))
  }

  def cacheWhereWithOffset20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20](
        pick: M => Tuple20[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape20(pick(model)))
  }

  def cacheHaving20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20](
        pick: M => Tuple20[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20]]
      ) = {
    coll.cacheHaving(new CondShape20(pick(model)))
  }

  def cacheHavingWithOffset20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20](
        pick: M => Tuple20[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape20(pick(model)))
  }

  def cacheWhere21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21](
        pick: M => Tuple21[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21]]
      ) = {
    coll.cacheWhere(new CondShape21(pick(model)))
  }

  def cacheWhereWithOffset21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21](
        pick: M => Tuple21[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape21(pick(model)))
  }

  def cacheHaving21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21](
        pick: M => Tuple21[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21]]
      ) = {
    coll.cacheHaving(new CondShape21(pick(model)))
  }

  def cacheHavingWithOffset21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21](
        pick: M => Tuple21[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape21(pick(model)))
  }

  def cacheWhere22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22](
        pick: M => Tuple22[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21], CacheCond[P22]]
      ) = {
    coll.cacheWhere(new CondShape22(pick(model)))
  }

  def cacheWhereWithOffset22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22](
        pick: M => Tuple22[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21], CacheCond[P22]]
      ) = {
    coll.cacheWhereWithOffset(new CondShape22(pick(model)))
  }

  def cacheHaving22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22](
        pick: M => Tuple22[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21], CacheCond[P22]]
      ) = {
    coll.cacheHaving(new CondShape22(pick(model)))
  }

  def cacheHavingWithOffset22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22](
        pick: M => Tuple22[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21], CacheCond[P22]]
      ) = {
    coll.cacheHavingWithOffset(new CondShape22(pick(model)))
  }
}
