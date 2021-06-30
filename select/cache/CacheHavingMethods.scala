package kuzminki.model


abstract class CacheHavingMethods[M, R](model: M, coll: SelectCollector[R]) {

  def cacheHaving1[P](pick: M => CachePart[P]) = {
    coll.cacheHaving(new PartShapeSingle(pick(model)))
  }

  def cacheHaving2[P1, P2](pick: M => Tuple2[CachePart[P1], CachePart[P2]]) = {
    coll.cacheHaving(new PartShape2(pick(model)))
  }

  def cacheHaving3[P1, P2, P3](pick: M => Tuple3[CachePart[P1], CachePart[P2], CachePart[P3]]) = {
    coll.cacheHaving(new PartShape3(pick(model)))
  }

  def cacheHaving4[P1, P2, P3, P4](pick: M => Tuple4[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4]]) = {
    coll.cacheHaving(new PartShape4(pick(model)))
  }

  def cacheHaving5[P1, P2, P3, P4, P5](pick: M => Tuple5[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5]]) = {
    coll.cacheHaving(new PartShape5(pick(model)))
  }

  def cacheHaving6[P1, P2, P3, P4, P5, P6](pick: M => Tuple6[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6]]) = {
    coll.cacheHaving(new PartShape6(pick(model)))
  }

  def cacheHaving7[P1, P2, P3, P4, P5, P6, P7](pick: M => Tuple7[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7]]) = {
    coll.cacheHaving(new PartShape7(pick(model)))
  }

  def cacheHaving8[P1, P2, P3, P4, P5, P6, P7, P8](pick: M => Tuple8[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8]]) = {
    coll.cacheHaving(new PartShape8(pick(model)))
  }

  def cacheHaving9[P1, P2, P3, P4, P5, P6, P7, P8, P9](pick: M => Tuple9[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9]]) = {
    coll.cacheHaving(new PartShape9(pick(model)))
  }

  def cacheHaving10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10](pick: M => Tuple10[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10]]) = {
    coll.cacheHaving(new PartShape10(pick(model)))
  }

  def cacheHaving11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11](pick: M => Tuple11[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11]]) = {
    coll.cacheHaving(new PartShape11(pick(model)))
  }

  def cacheHaving12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12](pick: M => Tuple12[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12]]) = {
    coll.cacheHaving(new PartShape12(pick(model)))
  }

  def cacheHaving13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13](pick: M => Tuple13[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13]]) = {
    coll.cacheHaving(new PartShape13(pick(model)))
  }

  def cacheHaving14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14](pick: M => Tuple14[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14]]) = {
    coll.cacheHaving(new PartShape14(pick(model)))
  }

  def cacheHaving15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15](pick: M => Tuple15[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14], CachePart[P15]]) = {
    coll.cacheHaving(new PartShape15(pick(model)))
  }

  def cacheHaving16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16](pick: M => Tuple16[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14], CachePart[P15], CachePart[P16]]) = {
    coll.cacheHaving(new PartShape16(pick(model)))
  }

  def cacheHaving17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17](pick: M => Tuple17[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14], CachePart[P15], CachePart[P16], CachePart[P17]]) = {
    coll.cacheHaving(new PartShape17(pick(model)))
  }

  def cacheHaving18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18](pick: M => Tuple18[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14], CachePart[P15], CachePart[P16], CachePart[P17], CachePart[P18]]) = {
    coll.cacheHaving(new PartShape18(pick(model)))
  }

  def cacheHaving19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19](pick: M => Tuple19[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14], CachePart[P15], CachePart[P16], CachePart[P17], CachePart[P18], CachePart[P19]]) = {
    coll.cacheHaving(new PartShape19(pick(model)))
  }

  def cacheHaving20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20](pick: M => Tuple20[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14], CachePart[P15], CachePart[P16], CachePart[P17], CachePart[P18], CachePart[P19], CachePart[P20]]) = {
    coll.cacheHaving(new PartShape20(pick(model)))
  }

  def cacheHaving21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21](pick: M => Tuple21[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14], CachePart[P15], CachePart[P16], CachePart[P17], CachePart[P18], CachePart[P19], CachePart[P20], CachePart[P21]]) = {
    coll.cacheHaving(new PartShape21(pick(model)))
  }

  def cacheHaving22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22](pick: M => Tuple22[CachePart[P1], CachePart[P2], CachePart[P3], CachePart[P4], CachePart[P5], CachePart[P6], CachePart[P7], CachePart[P8], CachePart[P9], CachePart[P10], CachePart[P11], CachePart[P12], CachePart[P13], CachePart[P14], CachePart[P15], CachePart[P16], CachePart[P17], CachePart[P18], CachePart[P19], CachePart[P20], CachePart[P21], CachePart[P22]]) = {
    coll.cacheHaving(new PartShape22(pick(model)))
  }
}
