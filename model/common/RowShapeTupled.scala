package kuzminki.model

import io.rdbc.sapi.Row


class RowShape2[R1, R2](shape: Tuple2[TypeCol[R1], TypeCol[R2]]) extends RowShape[Tuple2[R1, R2]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2) => Seq(col1, col2)
    }
  }

  def fromRow(row: Row): Tuple2[R1, R2] = {
    shape match {
      case (col1, col2) => (col1.get(row, 0), col2.get(row, 1))
    }
  }
}

class RowShape3[R1, R2, R3](shape: Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) extends RowShape[Tuple3[R1, R2, R3]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3) => Seq(col1, col2, col3)
    }
  }

  def fromRow(row: Row): Tuple3[R1, R2, R3] = {
    shape match {
      case (col1, col2, col3) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2))
    }
  }
}

class RowShape4[R1, R2, R3, R4](shape: Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) extends RowShape[Tuple4[R1, R2, R3, R4]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4) => Seq(col1, col2, col3, col4)
    }
  }

  def fromRow(row: Row): Tuple4[R1, R2, R3, R4] = {
    shape match {
      case (col1, col2, col3, col4) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3))
    }
  }
}

class RowShape5[R1, R2, R3, R4, R5](shape: Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) extends RowShape[Tuple5[R1, R2, R3, R4, R5]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5) => Seq(col1, col2, col3, col4, col5)
    }
  }

  def fromRow(row: Row): Tuple5[R1, R2, R3, R4, R5] = {
    shape match {
      case (col1, col2, col3, col4, col5) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4))
    }
  }
}

class RowShape6[R1, R2, R3, R4, R5, R6](shape: Tuple6[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6]]) extends RowShape[Tuple6[R1, R2, R3, R4, R5, R6]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6) => Seq(col1, col2, col3, col4, col5, col6)
    }
  }

  def fromRow(row: Row): Tuple6[R1, R2, R3, R4, R5, R6] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5))
    }
  }
}

class RowShape7[R1, R2, R3, R4, R5, R6, R7](shape: Tuple7[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7]]) extends RowShape[Tuple7[R1, R2, R3, R4, R5, R6, R7]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7) => Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }

  def fromRow(row: Row): Tuple7[R1, R2, R3, R4, R5, R6, R7] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6))
    }
  }
}

class RowShape8[R1, R2, R3, R4, R5, R6, R7, R8](shape: Tuple8[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8]]) extends RowShape[Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) => Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }

  def fromRow(row: Row): Tuple8[R1, R2, R3, R4, R5, R6, R7, R8] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7))
    }
  }
}

class RowShape9[R1, R2, R3, R4, R5, R6, R7, R8, R9](shape: Tuple9[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9]]) extends RowShape[Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }

  def fromRow(row: Row): Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8))
    }
  }
}

class RowShape10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](shape: Tuple10[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10]]) extends RowShape[Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }

  def fromRow(row: Row): Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9))
    }
  }
}

class RowShape11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](shape: Tuple11[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11]]) extends RowShape[Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }

  def fromRow(row: Row): Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10))
    }
  }
}

class RowShape12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](shape: Tuple12[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12]]) extends RowShape[Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }

  def fromRow(row: Row): Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11))
    }
  }
}

class RowShape13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](shape: Tuple13[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13]]) extends RowShape[Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }

  def fromRow(row: Row): Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12))
    }
  }
}

class RowShape14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](shape: Tuple14[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14]]) extends RowShape[Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }

  def fromRow(row: Row): Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13))
    }
  }
}

class RowShape15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](shape: Tuple15[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15]]) extends RowShape[Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }

  def fromRow(row: Row): Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14))
    }
  }
}

class RowShape16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](shape: Tuple16[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16]]) extends RowShape[Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }

  def fromRow(row: Row): Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15))
    }
  }
}

class RowShape17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](shape: Tuple17[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17]]) extends RowShape[Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }

  def fromRow(row: Row): Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16))
    }
  }
}

class RowShape18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](shape: Tuple18[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18]]) extends RowShape[Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }

  def fromRow(row: Row): Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17))
    }
  }
}

class RowShape19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](shape: Tuple19[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19]]) extends RowShape[Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }

  def fromRow(row: Row): Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17), col19.get(row, 18))
    }
  }
}

class RowShape20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](shape: Tuple20[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20]]) extends RowShape[Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }

  def fromRow(row: Row): Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17), col19.get(row, 18), col20.get(row, 19))
    }
  }
}

class RowShape21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](shape: Tuple21[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21]]) extends RowShape[Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }

  def fromRow(row: Row): Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17), col19.get(row, 18), col20.get(row, 19), col21.get(row, 20))
    }
  }
}

class RowShape22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](shape: Tuple22[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21], TypeCol[R22]]) extends RowShape[Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]] {

  def cols: Seq[RenderableCol] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }

  def fromRow(row: Row): Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) => (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17), col19.get(row, 18), col20.get(row, 19), col21.get(row, 20), col22.get(row, 21))
    }
  }
}
