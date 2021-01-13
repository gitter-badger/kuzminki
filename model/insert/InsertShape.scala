package kuzminki.model.insert

import kuzminki.model._


trait InsertShape[S] {
  def size: Int
  def cols: Seq[ModelCol]
  def transform(data: S): Vector[Any]
}

class InsertShape1[S](col: TypeCol[S]) extends InsertShape[S] {

  def size = 1

  def cols = Vector(col)

  def transform(data: S) = Vector(data) 
}

class InsertShape2[R1, R2](shape: Tuple2[TypeCol[R1], TypeCol[R2]]) extends InsertShape[Tuple2[R1, R2]] {

  def size = 2

  def cols = {
    shape match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }

  def transform(data: Tuple2[R1, R2]) = {
    data match {
      case (arg1, arg2) =>
        Vector(arg1, arg2)
    }
  }
}

class InsertShape3[R1, R2, R3](shape: Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) extends InsertShape[Tuple3[R1, R2, R3]] {

  def size = 3

  def cols = {
    shape match {
      case (col1, col2, col3) =>
        Seq(col1, col2, col3)
    }
  }

  def transform(data: Tuple3[R1, R2, R3]) = {
    data match {
      case (arg1, arg2, arg3) =>
        Vector(arg1, arg2, arg3)
    }
  }
}

class InsertShape4[R1, R2, R3, R4](shape: Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) extends InsertShape[Tuple4[R1, R2, R3, R4]] {

  def size = 4

  def cols = {
    shape match {
      case (col1, col2, col3, col4) =>
        Seq(col1, col2, col3, col4)
    }
  }

  def transform(data: Tuple4[R1, R2, R3, R4]) = {
    data match {
      case (arg1, arg2, arg3, arg4) =>
        Vector(arg1, arg2, arg3, arg4)
    }
  }
}

class InsertShape5[R1, R2, R3, R4, R5](shape: Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) extends InsertShape[Tuple5[R1, R2, R3, R4, R5]] {

  def size = 5

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5) =>
        Seq(col1, col2, col3, col4, col5)
    }
  }

  def transform(data: Tuple5[R1, R2, R3, R4, R5]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5) =>
        Vector(arg1, arg2, arg3, arg4, arg5)
    }
  }
}

class InsertShape6[R1, R2, R3, R4, R5, R6](shape: Tuple6[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6]]) extends InsertShape[Tuple6[R1, R2, R3, R4, R5, R6]] {

  def size = 6

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6) =>
        Seq(col1, col2, col3, col4, col5, col6)
    }
  }

  def transform(data: Tuple6[R1, R2, R3, R4, R5, R6]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6)
    }
  }
}

class InsertShape7[R1, R2, R3, R4, R5, R6, R7](shape: Tuple7[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7]]) extends InsertShape[Tuple7[R1, R2, R3, R4, R5, R6, R7]] {

  def size = 7

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7) =>
        Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }

  def transform(data: Tuple7[R1, R2, R3, R4, R5, R6, R7]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7)
    }
  }
}

class InsertShape8[R1, R2, R3, R4, R5, R6, R7, R8](shape: Tuple8[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8]]) extends InsertShape[Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]] {

  def size = 8

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }

  def transform(data: Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8)
    }
  }
}

class InsertShape9[R1, R2, R3, R4, R5, R6, R7, R8, R9](shape: Tuple9[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9]]) extends InsertShape[Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]] {

  def size = 9

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }

  def transform(data: Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
    }
  }
}

class InsertShape10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](shape: Tuple10[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10]]) extends InsertShape[Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]] {

  def size = 10

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }

  def transform(data: Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10)
    }
  }
}

class InsertShape11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](shape: Tuple11[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11]]) extends InsertShape[Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]] {

  def size = 11

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }

  def transform(data: Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11)
    }
  }
}

class InsertShape12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](shape: Tuple12[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12]]) extends InsertShape[Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]] {

  def size = 12

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }

  def transform(data: Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12)
    }
  }
}

class InsertShape13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](shape: Tuple13[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13]]) extends InsertShape[Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]] {

  def size = 13

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }

  def transform(data: Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13)
    }
  }
}

class InsertShape14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](shape: Tuple14[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14]]) extends InsertShape[Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]] {

  def size = 14

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }

  def transform(data: Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14)
    }
  }
}

class InsertShape15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](shape: Tuple15[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15]]) extends InsertShape[Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]] {

  def size = 15

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }

  def transform(data: Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15)
    }
  }
}

class InsertShape16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](shape: Tuple16[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16]]) extends InsertShape[Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]] {

  def size = 16

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }

  def transform(data: Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16)
    }
  }
}

class InsertShape17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](shape: Tuple17[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17]]) extends InsertShape[Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]] {

  def size = 17

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }

  def transform(data: Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17)
    }
  }
}

class InsertShape18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](shape: Tuple18[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18]]) extends InsertShape[Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]] {

  def size = 18

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }

  def transform(data: Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18)
    }
  }
}

class InsertShape19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](shape: Tuple19[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19]]) extends InsertShape[Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]] {

  def size = 19

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }

  def transform(data: Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19)
    }
  }
}

class InsertShape20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](shape: Tuple20[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20]]) extends InsertShape[Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]] {

  def size = 20

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }

  def transform(data: Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20)
    }
  }
}

class InsertShape21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](shape: Tuple21[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21]]) extends InsertShape[Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]] {

  def size = 21

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }

  def transform(data: Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21)
    }
  }
}

class InsertShape22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](shape: Tuple22[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21], TypeCol[R22]]) extends InsertShape[Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]] {

  def size = 22

  def cols = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }

  def transform(data: Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]) = {
    data match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22) =>
        Vector(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22)
    }
  }
}
