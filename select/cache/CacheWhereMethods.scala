package kuzminki.model


trait CacheWhereMethods[R] {

  val coll: SelectCollector[R]

  def cacheWhere1[P](pick: M => TypeCol[P]) = {
    coll.cacheWhere(new CondShapeSingle(pick(model)))
  }

  def cacheWhere2[P1, P2](pick: M => Tuple2[CacheCond[P1], CacheCond[P2]]) = {
    coll.cacheWhere(new CondShape2(pick(model)))
  }

  def cacheWhere3[P1, P2, P3](pick: M => Tuple3[CacheCond[P1], CacheCond[P2], CacheCond[P3]]) = {
    coll.cacheWhere(new CondShape3(pick(model)))
  }

  def cacheWhere4[P1, P2, P3, P4](pick: M => Tuple4[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4]]) = {
    coll.cacheWhere(new CondShape4(pick(model)))
  }

  def cacheWhere5[P1, P2, P3, P4, P5](pick: M => Tuple5[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5]]) = {
    coll.cacheWhere(new CondShape5(pick(model)))
  }

  def cacheWhere6[P1, P2, P3, P4, P5, P6](pick: M => Tuple6[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6]]) = {
    coll.cacheWhere(new CondShape6(pick(model)))
  }

  def cacheWhere7[P1, P2, P3, P4, P5, P6, P7](pick: M => Tuple7[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7]]) = {
    coll.cacheWhere(new CondShape7(pick(model)))
  }

  def cacheWhere8[P1, P2, P3, P4, P5, P6, P7, P8](pick: M => Tuple8[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8]]) = {
    coll.cacheWhere(new CondShape8(pick(model)))
  }

  def cacheWhere9[P1, P2, P3, P4, P5, P6, P7, P8, P9](pick: M => Tuple9[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9]]) = {
    coll.cacheWhere(new CondShape9(pick(model)))
  }

  def cacheWhere10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10](pick: M => Tuple10[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10]]) = {
    coll.cacheWhere(new CondShape10(pick(model)))
  }

  def cacheWhere11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11](pick: M => Tuple11[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11]]) = {
    coll.cacheWhere(new CondShape11(pick(model)))
  }

  def cacheWhere12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12](pick: M => Tuple12[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12]]) = {
    coll.cacheWhere(new CondShape12(pick(model)))
  }

  def cacheWhere13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13](pick: M => Tuple13[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13]]) = {
    coll.cacheWhere(new CondShape13(pick(model)))
  }

  def cacheWhere14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14](pick: M => Tuple14[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14]]) = {
    coll.cacheWhere(new CondShape14(pick(model)))
  }

  def cacheWhere15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15](pick: M => Tuple15[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15]]) = {
    coll.cacheWhere(new CondShape15(pick(model)))
  }

  def cacheWhere16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16](pick: M => Tuple16[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16]]) = {
    coll.cacheWhere(new CondShape16(pick(model)))
  }

  def cacheWhere17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17](pick: M => Tuple17[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17]]) = {
    coll.cacheWhere(new CondShape17(pick(model)))
  }

  def cacheWhere18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18](pick: M => Tuple18[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18]]) = {
    coll.cacheWhere(new CondShape18(pick(model)))
  }

  def cacheWhere19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19](pick: M => Tuple19[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19]]) = {
    coll.cacheWhere(new CondShape19(pick(model)))
  }

  def cacheWhere20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20](pick: M => Tuple20[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20]]) = {
    coll.cacheWhere(new CondShape20(pick(model)))
  }

  def cacheWhere21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21](pick: M => Tuple21[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21]]) = {
    coll.cacheWhere(new CondShape21(pick(model)))
  }

  def cacheWhere22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22](pick: M => Tuple22[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21], CacheCond[P22]]) = {
    coll.cacheWhere(new CondShape22(pick(model)))
  }
}
