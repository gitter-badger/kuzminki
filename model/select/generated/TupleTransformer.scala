package kuzminki.model

import io.rdbc.sapi._
import kuzminki.model._
import kuzminki.model.implicits._


trait TupleTransformer[T] {
  def toSeq: Seq[ModelCol]
  def transform(row: Row): T
}

  
case class Tuple2Cols[A1, A2](cols: Tuple2[TypeCol[A1], TypeCol[A2]]) extends TupleTransformer[Tuple2[A1, A2]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2) => Seq(col1, col2)
    }
  }

  def transform(row: Row): Tuple2[A1, A2] = {
    cols match {
      case (col1, col2) => (col1.get(row), col2.get(row))
    }
  }
}

case class Tuple3Cols[A1, A2, A3](cols: Tuple3[TypeCol[A1], TypeCol[A2], TypeCol[A3]]) extends TupleTransformer[Tuple3[A1, A2, A3]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3) => Seq(col1, col2, col3)
    }
  }

  def transform(row: Row): Tuple3[A1, A2, A3] = {
    cols match {
      case (col1, col2, col3) => (col1.get(row), col2.get(row), col3.get(row))
    }
  }
}

case class Tuple4Cols[A1, A2, A3, A4](cols: Tuple4[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4]]) extends TupleTransformer[Tuple4[A1, A2, A3, A4]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4) => Seq(col1, col2, col3, col4)
    }
  }

  def transform(row: Row): Tuple4[A1, A2, A3, A4] = {
    cols match {
      case (col1, col2, col3, col4) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row))
    }
  }
}

case class Tuple5Cols[A1, A2, A3, A4, A5](cols: Tuple5[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5]]) extends TupleTransformer[Tuple5[A1, A2, A3, A4, A5]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5) => Seq(col1, col2, col3, col4, col5)
    }
  }

  def transform(row: Row): Tuple5[A1, A2, A3, A4, A5] = {
    cols match {
      case (col1, col2, col3, col4, col5) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row))
    }
  }
}

case class Tuple6Cols[A1, A2, A3, A4, A5, A6](cols: Tuple6[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6]]) extends TupleTransformer[Tuple6[A1, A2, A3, A4, A5, A6]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6) => Seq(col1, col2, col3, col4, col5, col6)
    }
  }

  def transform(row: Row): Tuple6[A1, A2, A3, A4, A5, A6] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row))
    }
  }
}

case class Tuple7Cols[A1, A2, A3, A4, A5, A6, A7](cols: Tuple7[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7]]) extends TupleTransformer[Tuple7[A1, A2, A3, A4, A5, A6, A7]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7) => Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }

  def transform(row: Row): Tuple7[A1, A2, A3, A4, A5, A6, A7] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row))
    }
  }
}

case class Tuple8Cols[A1, A2, A3, A4, A5, A6, A7, A8](cols: Tuple8[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8]]) extends TupleTransformer[Tuple8[A1, A2, A3, A4, A5, A6, A7, A8]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) => Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }

  def transform(row: Row): Tuple8[A1, A2, A3, A4, A5, A6, A7, A8] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row))
    }
  }
}

case class Tuple9Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9](cols: Tuple9[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9]]) extends TupleTransformer[Tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }

  def transform(row: Row): Tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row))
    }
  }
}

case class Tuple10Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](cols: Tuple10[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10]]) extends TupleTransformer[Tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }

  def transform(row: Row): Tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row))
    }
  }
}

case class Tuple11Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](cols: Tuple11[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11]]) extends TupleTransformer[Tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }

  def transform(row: Row): Tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row))
    }
  }
}

case class Tuple12Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](cols: Tuple12[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12]]) extends TupleTransformer[Tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }

  def transform(row: Row): Tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row))
    }
  }
}

case class Tuple13Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](cols: Tuple13[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13]]) extends TupleTransformer[Tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }

  def transform(row: Row): Tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row))
    }
  }
}

case class Tuple14Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](cols: Tuple14[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14]]) extends TupleTransformer[Tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }

  def transform(row: Row): Tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row))
    }
  }
}

case class Tuple15Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](cols: Tuple15[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15]]) extends TupleTransformer[Tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }

  def transform(row: Row): Tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row))
    }
  }
}

case class Tuple16Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](cols: Tuple16[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16]]) extends TupleTransformer[Tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }

  def transform(row: Row): Tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row))
    }
  }
}

case class Tuple17Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](cols: Tuple17[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17]]) extends TupleTransformer[Tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }

  def transform(row: Row): Tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row))
    }
  }
}

case class Tuple18Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](cols: Tuple18[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18]]) extends TupleTransformer[Tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }

  def transform(row: Row): Tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row))
    }
  }
}

case class Tuple19Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](cols: Tuple19[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19]]) extends TupleTransformer[Tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }

  def transform(row: Row): Tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row), col19.get(row))
    }
  }
}

case class Tuple20Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](cols: Tuple20[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20]]) extends TupleTransformer[Tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }

  def transform(row: Row): Tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row), col19.get(row), col20.get(row))
    }
  }
}

case class Tuple21Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](cols: Tuple21[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21]]) extends TupleTransformer[Tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }

  def transform(row: Row): Tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row), col19.get(row), col20.get(row), col21.get(row))
    }
  }
}

case class Tuple22Cols[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](cols: Tuple22[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21], TypeCol[A22]]) extends TupleTransformer[Tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) => Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }

  def transform(row: Row): Tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22] = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row), col5.get(row), col6.get(row), col7.get(row), col8.get(row), col9.get(row), col10.get(row), col11.get(row), col12.get(row), col13.get(row), col14.get(row), col15.get(row), col16.get(row), col17.get(row), col18.get(row), col19.get(row), col20.get(row), col21.get(row), col22.get(row))
    }
  }
}
