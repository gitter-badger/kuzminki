package kuzminki.model


class ParamShape2[R1, R2](
      shape: Tuple2[TypeCol[R1], TypeCol[R2]]
    ) extends ParamShape[Tuple2[R1, R2]] {

  def size = 2

  def cols = {
    shape match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }

  def conv = {
    shape match {
      case (col1, col2) =>
        ParamConv2(col1.conv, col2.conv)
    }
  }
}

class ParamShape3[R1, R2, R3](
      shape: Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]
    ) extends ParamShape[Tuple3[R1, R2, R3]] {

  def size = 3

  def cols = {
    shape match {
      case (col1, col2, col3) =>
        Seq(col1, col2, col3)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3) =>
        ParamConv3(col1.conv, col2.conv, col3.conv)
    }
  }
}

class ParamShape4[R1, R2, R3, R4](
      shape: Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]
    ) extends ParamShape[Tuple4[R1, R2, R3, R4]] {

  def size = 4

  def cols = {
    shape match {
      case (col1, col2, col3, col4) =>
        Seq(col1, col2, col3, col4)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4) =>
        ParamConv4(col1.conv, col2.conv, col3.conv, col4.conv)
    }
  }
}

class ParamShape5[R1, R2, R3, R4, R5](
      shape: Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]
    ) extends ParamShape[Tuple5[R1, R2, R3, R4, R5]] {

  def size = 5

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5) =>
        Seq(col1, col2, col3, col4, col5)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5) =>
        ParamConv5(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv)
    }
  }
}

class ParamShape6[R1, R2, R3, R4, R5, R6](
      shape: Tuple6[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6]]
    ) extends ParamShape[Tuple6[R1, R2, R3, R4, R5, R6]] {

  def size = 6

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6) =>
        Seq(col1, col2, col3, col4, col5, col6)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6) =>
        ParamConv6(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv)
    }
  }
}

class ParamShape7[R1, R2, R3, R4, R5, R6, R7](
      shape: Tuple7[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7]]
    ) extends ParamShape[Tuple7[R1, R2, R3, R4, R5, R6, R7]] {

  def size = 7

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7) =>
        Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7) =>
        ParamConv7(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv)
    }
  }
}

class ParamShape8[R1, R2, R3, R4, R5, R6, R7, R8](
      shape: Tuple8[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8]]
    ) extends ParamShape[Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]] {

  def size = 8

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) =>
        ParamConv8(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv)
    }
  }
}

class ParamShape9[R1, R2, R3, R4, R5, R6, R7, R8, R9](
      shape: Tuple9[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9]]
    ) extends ParamShape[Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]] {

  def size = 9

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) =>
        ParamConv9(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv)
    }
  }
}

class ParamShape10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](
      shape: Tuple10[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10]]
    ) extends ParamShape[Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]] {

  def size = 10

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) =>
        ParamConv10(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv)
    }
  }
}

class ParamShape11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](
      shape: Tuple11[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11]]
    ) extends ParamShape[Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]] {

  def size = 11

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) =>
        ParamConv11(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv)
    }
  }
}

class ParamShape12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](
      shape: Tuple12[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12]]
    ) extends ParamShape[Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]] {

  def size = 12

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) =>
        ParamConv12(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv)
    }
  }
}

class ParamShape13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](
      shape: Tuple13[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13]]
    ) extends ParamShape[Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]] {

  def size = 13

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) =>
        ParamConv13(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv)
    }
  }
}

class ParamShape14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](
      shape: Tuple14[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14]]
    ) extends ParamShape[Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]] {

  def size = 14

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) =>
        ParamConv14(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv)
    }
  }
}

class ParamShape15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](
      shape: Tuple15[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15]]
    ) extends ParamShape[Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]] {

  def size = 15

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) =>
        ParamConv15(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv, col15.conv)
    }
  }
}

class ParamShape16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](
      shape: Tuple16[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16]]
    ) extends ParamShape[Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]] {

  def size = 16

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) =>
        ParamConv16(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv, col15.conv, col16.conv)
    }
  }
}

class ParamShape17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](
      shape: Tuple17[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17]]
    ) extends ParamShape[Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]] {

  def size = 17

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) =>
        ParamConv17(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv, col15.conv, col16.conv, col17.conv)
    }
  }
}

class ParamShape18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](
      shape: Tuple18[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18]]
    ) extends ParamShape[Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]] {

  def size = 18

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) =>
        ParamConv18(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv, col15.conv, col16.conv, col17.conv, col18.conv)
    }
  }
}

class ParamShape19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](
      shape: Tuple19[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19]]
    ) extends ParamShape[Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]] {

  def size = 19

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) =>
        ParamConv19(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv, col15.conv, col16.conv, col17.conv, col18.conv, col19.conv)
    }
  }
}

class ParamShape20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](
      shape: Tuple20[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20]]
    ) extends ParamShape[Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]] {

  def size = 20

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) =>
        ParamConv20(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv, col15.conv, col16.conv, col17.conv, col18.conv, col19.conv, col20.conv)
    }
  }
}

class ParamShape21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](
      shape: Tuple21[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21]]
    ) extends ParamShape[Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]] {

  def size = 21

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) =>
        ParamConv21(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv, col15.conv, col16.conv, col17.conv, col18.conv, col19.conv, col20.conv, col21.conv)
    }
  }
}

class ParamShape22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](
      shape: Tuple22[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21], TypeCol[R22]]
    ) extends ParamShape[Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]] {

  def size = 22

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }

  def conv = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) =>
        ParamConv22(col1.conv, col2.conv, col3.conv, col4.conv, col5.conv, col6.conv, col7.conv, col8.conv, col9.conv, col10.conv, col11.conv, col12.conv, col13.conv, col14.conv, col15.conv, col16.conv, col17.conv, col18.conv, col19.conv, col20.conv, col21.conv, col22.conv)
    }
  }
}
