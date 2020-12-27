package kuzminki.model.operation

import kuzminki.model._


trait InsertType[R] {
  def toSeq: Seq[ModelCol]
  def argsToSeq(arg: R): Seq[Any]
}

case class InsertType1[R](col: TypeCol[R]) extends InsertType[R] {

  def toSeq = Seq(col)

  def argsToSeq(arg: R) = Seq(arg) 
}

class InsertType2[R1, R2](cols: Tuple2[TypeCol[R1], TypeCol[R2]]) extends InsertType[Tuple2[R1, R2]] {

  def toSeq = {
    cols match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }

  def argsToSeq(args: Tuple2[R1, R2]) = {
    args match {
      case (arg1, arg2) =>
        Seq(arg1, arg2)
    }
  }
}

class InsertType3[R1, R2, R3](cols: Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) extends InsertType[Tuple3[R1, R2, R3]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3) =>
        Seq(col1, col2, col3)
    }
  }

  def argsToSeq(args: Tuple3[R1, R2, R3]) = {
    args match {
      case (arg1, arg2, arg3) =>
        Seq(arg1, arg2, arg3)
    }
  }
}

class InsertType4[R1, R2, R3, R4](cols: Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) extends InsertType[Tuple4[R1, R2, R3, R4]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4) =>
        Seq(col1, col2, col3, col4)
    }
  }

  def argsToSeq(args: Tuple4[R1, R2, R3, R4]) = {
    args match {
      case (arg1, arg2, arg3, arg4) =>
        Seq(arg1, arg2, arg3, arg4)
    }
  }
}

class InsertType5[R1, R2, R3, R4, R5](cols: Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) extends InsertType[Tuple5[R1, R2, R3, R4, R5]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5) =>
        Seq(col1, col2, col3, col4, col5)
    }
  }

  def argsToSeq(args: Tuple5[R1, R2, R3, R4, R5]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5) =>
        Seq(arg1, arg2, arg3, arg4, arg5)
    }
  }
}

class InsertType6[R1, R2, R3, R4, R5, R6](cols: Tuple6[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6]]) extends InsertType[Tuple6[R1, R2, R3, R4, R5, R6]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6) =>
        Seq(col1, col2, col3, col4, col5, col6)
    }
  }

  def argsToSeq(args: Tuple6[R1, R2, R3, R4, R5, R6]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6)
    }
  }
}

class InsertType7[R1, R2, R3, R4, R5, R6, R7](cols: Tuple7[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7]]) extends InsertType[Tuple7[R1, R2, R3, R4, R5, R6, R7]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7) =>
        Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }

  def argsToSeq(args: Tuple7[R1, R2, R3, R4, R5, R6, R7]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7)
    }
  }
}

class InsertType8[R1, R2, R3, R4, R5, R6, R7, R8](cols: Tuple8[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8]]) extends InsertType[Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }

  def argsToSeq(args: Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8)
    }
  }
}

class InsertType9[R1, R2, R3, R4, R5, R6, R7, R8, R9](cols: Tuple9[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9]]) extends InsertType[Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }

  def argsToSeq(args: Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
    }
  }
}

class InsertType10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](cols: Tuple10[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10]]) extends InsertType[Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }

  def argsToSeq(args: Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10)
    }
  }
}

class InsertType11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](cols: Tuple11[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11]]) extends InsertType[Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }

  def argsToSeq(args: Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11)
    }
  }
}

class InsertType12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](cols: Tuple12[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12]]) extends InsertType[Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }

  def argsToSeq(args: Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12)
    }
  }
}

class InsertType13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](cols: Tuple13[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13]]) extends InsertType[Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }

  def argsToSeq(args: Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13)
    }
  }
}

class InsertType14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](cols: Tuple14[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14]]) extends InsertType[Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }

  def argsToSeq(args: Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14)
    }
  }
}

class InsertType15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](cols: Tuple15[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15]]) extends InsertType[Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }

  def argsToSeq(args: Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15)
    }
  }
}

class InsertType16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](cols: Tuple16[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16]]) extends InsertType[Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }

  def argsToSeq(args: Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16)
    }
  }
}

class InsertType17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](cols: Tuple17[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17]]) extends InsertType[Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }

  def argsToSeq(args: Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17)
    }
  }
}

class InsertType18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](cols: Tuple18[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18]]) extends InsertType[Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }

  def argsToSeq(args: Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18)
    }
  }
}

class InsertType19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](cols: Tuple19[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19]]) extends InsertType[Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }

  def argsToSeq(args: Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19)
    }
  }
}

class InsertType20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](cols: Tuple20[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20]]) extends InsertType[Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }

  def argsToSeq(args: Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20)
    }
  }
}

class InsertType21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](cols: Tuple21[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21]]) extends InsertType[Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }

  def argsToSeq(args: Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21)
    }
  }
}

class InsertType22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](cols: Tuple22[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21], TypeCol[R22]]) extends InsertType[Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }

  def argsToSeq(args: Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22)
    }
  }
}
