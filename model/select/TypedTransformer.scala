package kuzminki.model

import io.rdbc.sapi._
import kuzminki.model._
import kuzminki.model.implicits._


sealed trait TypedTransformer[R] {
  def toSeq: Seq[ModelCol]
  def transform(row: Row): R
}

case class TypedCols1[R](col: TypeCol[R]) extends TypedTransformer[R] {

  def toSeq: Seq[ModelCol] = Seq(col)

  def transform(row: Row): R = col.get(row)
}

case class TypedCols2[R1, R2](cols: Tuple2[TypeCol[R1], TypeCol[R2]]) extends TypedTransformer[Tuple2[R1, R2]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2) => Seq(col1, col2)
    }
  }

  def transform(row: Row): Tuple2[R1, R2] = {
    cols match {
      case (col1, col2) => (col1.get(row), col2.get(row))
    }
  }
}

case class TypedCols3[R1, R2, R3](cols: Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) extends TypedTransformer[Tuple3[R1, R2, R3]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3) => Seq(col1, col2, col3)
    }
  }

  def transform(row: Row): Tuple3[R1, R2, R3] = {
    cols match {
      case (col1, col2, col3) => (col1.get(row), col2.get(row), col3.get(row))
    }
  }
}

case class TypedCols4[R1, R2, R3, R4](cols: Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) extends TypedTransformer[Tuple4[R1, R2, R3, R4]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4) => Seq(col1, col2, col3, col4)
    }
  }

  def transform(row: Row): Tuple4[R1, R2, R3, R4] = {
    cols match {
      case (col1, col2, col3, col4) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row))
    }
  }
}

case class TypedCols5[R1, R2, R3, R4, R5](cols: Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) extends TypedTransformer[Tuple5[R1, R2, R3, R4, R5]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5) => Seq(col1, col2, col3, col4, col5)
    }
  }

  def transform(row: Row): Tuple5[R1, R2, R3, R4, R5] = {
    cols match {
      case (col1, col2, col3, col4, col5) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row))
    }
  }
}

case class TypedCols6[R1, R2, R3, R4, R5, R6](cols: Tuple6[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6]]) extends TypedTransformer[Tuple6[R1, R2, R3, R4, R5, R6]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6) => Seq(col1, col2, col3, col4, col5, col6)
    }
  }

  def transform(row: Row): Tuple6[R1, R2, R3, R4, R5, R6] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row))
    }
  }
}

case class TypedCols7[R1, R2, R3, R4, R5, R6, R7](cols: Tuple7[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7]]) extends TypedTransformer[Tuple7[R1, R2, R3, R4, R5, R6, R7]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7) => Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }

  def transform(row: Row): Tuple7[R1, R2, R3, R4, R5, R6, R7] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row))
    }
  }
}

case class TypedCols8[R1, R2, R3, R4, R5, R6, R7, R8](cols: Tuple8[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8]]) extends TypedTransformer[Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) => Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }

  def transform(row: Row): Tuple8[R1, R2, R3, R4, R5, R6, R7, R8] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row))
    }
  }
}

case class TypedCols9[R1, R2, R3, R4, R5, R6, R7, R8, R9](cols: Tuple9[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9]]) extends TypedTransformer[Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }

  def transform(row: Row): Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row))
    }
  }
}

case class TypedCols10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](cols: Tuple10[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10]]) extends TypedTransformer[Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }

  def transform(row: Row): Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row))
    }
  }
}

case class TypedCols11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](cols: Tuple11[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11]]) extends TypedTransformer[Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }

  def transform(row: Row): Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row))
    }
  }
}

case class TypedCols12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](cols: Tuple12[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12]]) extends TypedTransformer[Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }

  def transform(row: Row): Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row))
    }
  }
}

case class TypedCols13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](cols: Tuple13[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13]]) extends TypedTransformer[Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }

  def transform(row: Row): Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row))
    }
  }
}

case class TypedCols14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](cols: Tuple14[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14]]) extends TypedTransformer[Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }

  def transform(row: Row): Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row))
    }
  }
}

case class TypedCols15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](cols: Tuple15[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15]]) extends TypedTransformer[Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }

  def transform(row: Row): Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row))
    }
  }
}

case class TypedCols16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](cols: Tuple16[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16]]) extends TypedTransformer[Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }

  def transform(row: Row): Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row))
    }
  }
}

case class TypedCols17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](cols: Tuple17[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17]]) extends TypedTransformer[Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }

  def transform(row: Row): Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row))
    }
  }
}

case class TypedCols18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](cols: Tuple18[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18]]) extends TypedTransformer[Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }

  def transform(row: Row): Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row))
    }
  }
}

case class TypedCols19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](cols: Tuple19[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19]]) extends TypedTransformer[Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }

  def transform(row: Row): Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row), col19.get(row))
    }
  }
}

case class TypedCols20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](cols: Tuple20[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20]]) extends TypedTransformer[Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }

  def transform(row: Row): Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row), col19.get(row), col20.get(row))
    }
  }
}

case class TypedCols21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](cols: Tuple21[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21]]) extends TypedTransformer[Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }

  def transform(row: Row): Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row), col19.get(row), col20.get(row), col21.get(row))
    }
  }
}

case class TypedCols22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](cols: Tuple22[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21], TypeCol[R22]]) extends TypedTransformer[Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }

  def transform(row: Row): Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row), col19.get(row), col20.get(row), col21.get(row), col22.get(row))
    }
  }
}
