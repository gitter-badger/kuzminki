

package kuzminki.model


class CondShape2[P1, P2](
      shape: Tuple2[CacheCond[P1], CacheCond[P2]]
    ) extends CondShape[Tuple2[P1, P2]] {

  def conds = {
    shape match {
      case (cond1, cond2) =>
        Seq(cond1, cond2)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2) =>
        new ParamConv2(cond1.conv, cond2.conv)
    }
  }
}

class CondShape3[P1, P2, P3](
      shape: Tuple3[CacheCond[P1], CacheCond[P2], CacheCond[P3]]
    ) extends CondShape[Tuple3[P1, P2, P3]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3) =>
        Seq(cond1, cond2, cond3)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3) =>
        new ParamConv3(cond1.conv, cond2.conv, cond3.conv)
    }
  }
}

class CondShape4[P1, P2, P3, P4](
      shape: Tuple4[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4]]
    ) extends CondShape[Tuple4[P1, P2, P3, P4]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4) =>
        Seq(cond1, cond2, cond3, cond4)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4) =>
        new ParamConv4(cond1.conv, cond2.conv, cond3.conv, cond4.conv)
    }
  }
}

class CondShape5[P1, P2, P3, P4, P5](
      shape: Tuple5[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5]]
    ) extends CondShape[Tuple5[P1, P2, P3, P4, P5]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5) =>
        Seq(cond1, cond2, cond3, cond4, cond5)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5) =>
        new ParamConv5(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv)
    }
  }
}

class CondShape6[P1, P2, P3, P4, P5, P6](
      shape: Tuple6[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6]]
    ) extends CondShape[Tuple6[P1, P2, P3, P4, P5, P6]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6) =>
        new ParamConv6(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv)
    }
  }
}

class CondShape7[P1, P2, P3, P4, P5, P6, P7](
      shape: Tuple7[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7]]
    ) extends CondShape[Tuple7[P1, P2, P3, P4, P5, P6, P7]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7) =>
        new ParamConv7(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv)
    }
  }
}

class CondShape8[P1, P2, P3, P4, P5, P6, P7, P8](
      shape: Tuple8[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8]]
    ) extends CondShape[Tuple8[P1, P2, P3, P4, P5, P6, P7, P8]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8) =>
        new ParamConv8(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv)
    }
  }
}

class CondShape9[P1, P2, P3, P4, P5, P6, P7, P8, P9](
      shape: Tuple9[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9]]
    ) extends CondShape[Tuple9[P1, P2, P3, P4, P5, P6, P7, P8, P9]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9) =>
        new ParamConv9(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv)
    }
  }
}

class CondShape10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10](
      shape: Tuple10[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10]]
    ) extends CondShape[Tuple10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10) =>
        new ParamConv10(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv)
    }
  }
}

class CondShape11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11](
      shape: Tuple11[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11]]
    ) extends CondShape[Tuple11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11) =>
        new ParamConv11(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv)
    }
  }
}

class CondShape12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12](
      shape: Tuple12[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12]]
    ) extends CondShape[Tuple12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12) =>
        new ParamConv12(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv)
    }
  }
}

class CondShape13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13](
      shape: Tuple13[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13]]
    ) extends CondShape[Tuple13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13) =>
        new ParamConv13(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv)
    }
  }
}

class CondShape14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14](
      shape: Tuple14[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14]]
    ) extends CondShape[Tuple14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14) =>
        new ParamConv14(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv)
    }
  }
}

class CondShape15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15](
      shape: Tuple15[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15]]
    ) extends CondShape[Tuple15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15) =>
        new ParamConv15(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv, cond15.conv)
    }
  }
}

class CondShape16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16](
      shape: Tuple16[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16]]
    ) extends CondShape[Tuple16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16) =>
        new ParamConv16(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv, cond15.conv, cond16.conv)
    }
  }
}

class CondShape17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17](
      shape: Tuple17[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17]]
    ) extends CondShape[Tuple17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17) =>
        new ParamConv17(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv, cond15.conv, cond16.conv, cond17.conv)
    }
  }
}

class CondShape18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18](
      shape: Tuple18[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18]]
    ) extends CondShape[Tuple18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18) =>
        new ParamConv18(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv, cond15.conv, cond16.conv, cond17.conv, cond18.conv)
    }
  }
}

class CondShape19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19](
      shape: Tuple19[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19]]
    ) extends CondShape[Tuple19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19) =>
        new ParamConv19(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv, cond15.conv, cond16.conv, cond17.conv, cond18.conv, cond19.conv)
    }
  }
}

class CondShape20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20](
      shape: Tuple20[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20]]
    ) extends CondShape[Tuple20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20) =>
        new ParamConv20(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv, cond15.conv, cond16.conv, cond17.conv, cond18.conv, cond19.conv, cond20.conv)
    }
  }
}

class CondShape21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21](
      shape: Tuple21[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21]]
    ) extends CondShape[Tuple21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20, cond21) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20, cond21)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20, cond21) =>
        new ParamConv21(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv, cond15.conv, cond16.conv, cond17.conv, cond18.conv, cond19.conv, cond20.conv, cond21.conv)
    }
  }
}

class CondShape22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22](
      shape: Tuple22[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21], CacheCond[P22]]
    ) extends CondShape[Tuple22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22]] {

  def conds = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20, cond21, cond22) =>
        Seq(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20, cond21, cond22)
    }
  }

  def conv = {
    shape match {
      case (cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15, cond16, cond17, cond18, cond19, cond20, cond21, cond22) =>
        new ParamConv22(cond1.conv, cond2.conv, cond3.conv, cond4.conv, cond5.conv, cond6.conv, cond7.conv, cond8.conv, cond9.conv, cond10.conv, cond11.conv, cond12.conv, cond13.conv, cond14.conv, cond15.conv, cond16.conv, cond17.conv, cond18.conv, cond19.conv, cond20.conv, cond21.conv, cond22.conv)
    }
  }
}
