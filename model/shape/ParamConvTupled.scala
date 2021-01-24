package kuzminki.model


class ParamConv2[R1, R2](
      shape: Tuple2[ValConv[R1], ValConv[R2]]
    ) extends ParamConv[Tuple2[R1, R2]] {

  def fromShape(params: Tuple2[R1, R2]) = {
    params match {
      case (par1, par2) =>
        Vector(par1, par2)
    }
  }
}

class ParamConv3[R1, R2, R3](
      shape: Tuple3[ValConv[R1], ValConv[R2], ValConv[R3]]
    ) extends ParamConv[Tuple3[R1, R2, R3]] {

  def fromShape(params: Tuple3[R1, R2, R3]) = {
    params match {
      case (par1, par2, par3) =>
        Vector(par1, par2, par3)
    }
  }
}

class ParamConv4[R1, R2, R3, R4](
      shape: Tuple4[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4]]
    ) extends ParamConv[Tuple4[R1, R2, R3, R4]] {

  def fromShape(params: Tuple4[R1, R2, R3, R4]) = {
    params match {
      case (par1, par2, par3, par4) =>
        Vector(par1, par2, par3, par4)
    }
  }
}

class ParamConv5[R1, R2, R3, R4, R5](
      shape: Tuple5[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5]]
    ) extends ParamConv[Tuple5[R1, R2, R3, R4, R5]] {

  def fromShape(params: Tuple5[R1, R2, R3, R4, R5]) = {
    params match {
      case (par1, par2, par3, par4, par5) =>
        Vector(par1, par2, par3, par4, par5)
    }
  }
}

class ParamConv6[R1, R2, R3, R4, R5, R6](
      shape: Tuple6[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6]]
    ) extends ParamConv[Tuple6[R1, R2, R3, R4, R5, R6]] {

  def fromShape(params: Tuple6[R1, R2, R3, R4, R5, R6]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6) =>
        Vector(par1, par2, par3, par4, par5, par6)
    }
  }
}

class ParamConv7[R1, R2, R3, R4, R5, R6, R7](
      shape: Tuple7[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7]]
    ) extends ParamConv[Tuple7[R1, R2, R3, R4, R5, R6, R7]] {

  def fromShape(params: Tuple7[R1, R2, R3, R4, R5, R6, R7]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7) =>
        Vector(par1, par2, par3, par4, par5, par6, par7)
    }
  }
}

class ParamConv8[R1, R2, R3, R4, R5, R6, R7, R8](
      shape: Tuple8[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8]]
    ) extends ParamConv[Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]] {

  def fromShape(params: Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8)
    }
  }
}

class ParamConv9[R1, R2, R3, R4, R5, R6, R7, R8, R9](
      shape: Tuple9[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9]]
    ) extends ParamConv[Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]] {

  def fromShape(params: Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9)
    }
  }
}

class ParamConv10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](
      shape: Tuple10[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10]]
    ) extends ParamConv[Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]] {

  def fromShape(params: Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10)
    }
  }
}

class ParamConv11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](
      shape: Tuple11[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11]]
    ) extends ParamConv[Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]] {

  def fromShape(params: Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11)
    }
  }
}

class ParamConv12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](
      shape: Tuple12[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12]]
    ) extends ParamConv[Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]] {

  def fromShape(params: Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12)
    }
  }
}

class ParamConv13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](
      shape: Tuple13[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13]]
    ) extends ParamConv[Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]] {

  def fromShape(params: Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13)
    }
  }
}

class ParamConv14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](
      shape: Tuple14[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14]]
    ) extends ParamConv[Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]] {

  def fromShape(params: Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14)
    }
  }
}

class ParamConv15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](
      shape: Tuple15[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15]]
    ) extends ParamConv[Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]] {

  def fromShape(params: Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15)
    }
  }
}

class ParamConv16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](
      shape: Tuple16[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16]]
    ) extends ParamConv[Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]] {

  def fromShape(params: Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16)
    }
  }
}

class ParamConv17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](
      shape: Tuple17[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17]]
    ) extends ParamConv[Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]] {

  def fromShape(params: Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17)
    }
  }
}

class ParamConv18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](
      shape: Tuple18[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18]]
    ) extends ParamConv[Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]] {

  def fromShape(params: Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18)
    }
  }
}

class ParamConv19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](
      shape: Tuple19[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18], ValConv[R19]]
    ) extends ParamConv[Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]] {

  def fromShape(params: Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18, par19) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18, par19)
    }
  }
}

class ParamConv20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](
      shape: Tuple20[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18], ValConv[R19], ValConv[R20]]
    ) extends ParamConv[Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]] {

  def fromShape(params: Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18, par19, par20) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18, par19, par20)
    }
  }
}

class ParamConv21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](
      shape: Tuple21[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18], ValConv[R19], ValConv[R20], ValConv[R21]]
    ) extends ParamConv[Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]] {

  def fromShape(params: Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18, par19, par20, par21) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18, par19, par20, par21)
    }
  }
}

class ParamConv22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](
      shape: Tuple22[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18], ValConv[R19], ValConv[R20], ValConv[R21], ValConv[R22]]
    ) extends ParamConv[Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]] {

  def fromShape(params: Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]) = {
    params match {
      case (par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18, par19, par20, par21, par22) =>
        Vector(par1, par2, par3, par4, par5, par6, par7, par8, par9, par10, par11, par12, par13, par14, par15, par16, par17, par18, par19, par20, par21, par22)
    }
  }
}
