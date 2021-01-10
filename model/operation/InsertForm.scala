package kuzminki.model.operation

import kuzminki.model._


trait InsertForm[R] {
  def size: Int
  def colSeq: Seq[ModelCol]
  def toSeq(data: R): Seq[Any]
  def toVector(data: R) = toSeq(data).toVector
}

case class InsertForm1[R](col: TypeCol[R]) extends InsertForm[R] {

  def size = 1

  def colSeq = Seq(col)

  def toSeq(value: R) = Seq(value) 
}

class InsertForm2[R1, R2](cols: Tuple2[TypeCol[R1], TypeCol[R2]]) extends InsertForm[Tuple2[R1, R2]] {

  def size = 2

  def colSeq = {
    cols match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }

  def toSeq(values: Tuple2[R1, R2]) = {
    values match {
      case (arg1, arg2) =>
        Seq(arg1, arg2)
    }
  }
}

class InsertForm3[R1, R2, R3](cols: Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) extends InsertForm[Tuple3[R1, R2, R3]] {

  def size = 3

  def colSeq = {
    cols match {
      case (col1, col2, col3) =>
        Seq(col1, col2, col3)
    }
  }

  def toSeq(values: Tuple3[R1, R2, R3]) = {
    values match {
      case (arg1, arg2, arg3) =>
        Seq(arg1, arg2, arg3)
    }
  }
}

class InsertForm4[R1, R2, R3, R4](cols: Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) extends InsertForm[Tuple4[R1, R2, R3, R4]] {

  def size = 4

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4) =>
        Seq(col1, col2, col3, col4)
    }
  }

  def toSeq(values: Tuple4[R1, R2, R3, R4]) = {
    values match {
      case (arg1, arg2, arg3, arg4) =>
        Seq(arg1, arg2, arg3, arg4)
    }
  }
}

class InsertForm5[R1, R2, R3, R4, R5](cols: Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) extends InsertForm[Tuple5[R1, R2, R3, R4, R5]] {

  def size = 5

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5) =>
        Seq(col1, col2, col3, col4, col5)
    }
  }

  def toSeq(values: Tuple5[R1, R2, R3, R4, R5]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5) =>
        Seq(arg1, arg2, arg3, arg4, arg5)
    }
  }
}

class InsertForm6[R1, R2, R3, R4, R5, R6](cols: Tuple6[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6]]) extends InsertForm[Tuple6[R1, R2, R3, R4, R5, R6]] {

  def size = 6

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6) =>
        Seq(col1, col2, col3, col4, col5, col6)
    }
  }

  def toSeq(values: Tuple6[R1, R2, R3, R4, R5, R6]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6)
    }
  }
}

class InsertForm7[R1, R2, R3, R4, R5, R6, R7](cols: Tuple7[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7]]) extends InsertForm[Tuple7[R1, R2, R3, R4, R5, R6, R7]] {

  def size = 7

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7) =>
        Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }

  def toSeq(values: Tuple7[R1, R2, R3, R4, R5, R6, R7]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7)
    }
  }
}

class InsertForm8[R1, R2, R3, R4, R5, R6, R7, R8](cols: Tuple8[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8]]) extends InsertForm[Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]] {

  def size = 8

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }

  def toSeq(values: Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8)
    }
  }
}

class InsertForm9[R1, R2, R3, R4, R5, R6, R7, R8, R9](cols: Tuple9[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9]]) extends InsertForm[Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]] {

  def size = 9

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }

  def toSeq(values: Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
    }
  }
}

class InsertForm10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](cols: Tuple10[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10]]) extends InsertForm[Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]] {

  def size = 10

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }

  def toSeq(values: Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10)
    }
  }
}

class InsertForm11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](cols: Tuple11[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11]]) extends InsertForm[Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]] {

  def size = 11

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }

  def toSeq(values: Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11)
    }
  }
}

class InsertForm12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](cols: Tuple12[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12]]) extends InsertForm[Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]] {

  def size = 12

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }

  def toSeq(values: Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12)
    }
  }
}

class InsertForm13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](cols: Tuple13[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13]]) extends InsertForm[Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]] {

  def size = 13

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }

  def toSeq(values: Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13)
    }
  }
}

class InsertForm14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](cols: Tuple14[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14]]) extends InsertForm[Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]] {

  def size = 14

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }

  def toSeq(values: Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14)
    }
  }
}

class InsertForm15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](cols: Tuple15[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15]]) extends InsertForm[Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]] {

  def size = 15

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }

  def toSeq(values: Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15)
    }
  }
}

class InsertForm16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](cols: Tuple16[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16]]) extends InsertForm[Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]] {

  def size = 16

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }

  def toSeq(values: Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16)
    }
  }
}

class InsertForm17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](cols: Tuple17[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17]]) extends InsertForm[Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]] {

  def size = 17

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }

  def toSeq(values: Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17)
    }
  }
}

class InsertForm18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](cols: Tuple18[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18]]) extends InsertForm[Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]] {

  def size = 18

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }

  def toSeq(values: Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18)
    }
  }
}

class InsertForm19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](cols: Tuple19[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19]]) extends InsertForm[Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]] {

  def size = 19

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }

  def toSeq(values: Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19)
    }
  }
}

class InsertForm20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](cols: Tuple20[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20]]) extends InsertForm[Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]] {

  def size = 20

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }

  def toSeq(values: Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20)
    }
  }
}

class InsertForm21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](cols: Tuple21[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21]]) extends InsertForm[Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]] {

  def size = 21

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }

  def toSeq(values: Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21)
    }
  }
}

class InsertForm22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](cols: Tuple22[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21], TypeCol[R22]]) extends InsertForm[Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]] {

  def size = 22

  def colSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }

  def toSeq(values: Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]) = {
    values match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22)
    }
  }
}
