package kuzminki.model.operation

import kuzminki.model._


trait InsertType[A] {
  def toSeq: Seq[ModelCol]
  def argsToSeq(arg: A): Seq[Any]
}

case class Insert1Type[A](col: TypeCol[A]) extends InsertType[A] {

  def toSeq = Seq(col)

  def argsToSeq(arg: A) = Seq(arg) 
}

  case class Insert2Types[A1, A2](cols: Tuple2[TypeCol[A1], TypeCol[A2]]) extends InsertType[Tuple2[A1, A2]] {

  def toSeq = {
    cols match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }

  def argsToSeq(args: Tuple2[A1, A2]) = {
    args match {
      case (arg1, arg2) =>
        Seq(arg1, arg2)
    }
  }
}

  case class Insert3Types[A1, A2, A3](cols: Tuple3[TypeCol[A1], TypeCol[A2], TypeCol[A3]]) extends InsertType[Tuple3[A1, A2, A3]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3) =>
        Seq(col1, col2, col3)
    }
  }

  def argsToSeq(args: Tuple3[A1, A2, A3]) = {
    args match {
      case (arg1, arg2, arg3) =>
        Seq(arg1, arg2, arg3)
    }
  }
}

  case class Insert4Types[A1, A2, A3, A4](cols: Tuple4[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4]]) extends InsertType[Tuple4[A1, A2, A3, A4]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4) =>
        Seq(col1, col2, col3, col4)
    }
  }

  def argsToSeq(args: Tuple4[A1, A2, A3, A4]) = {
    args match {
      case (arg1, arg2, arg3, arg4) =>
        Seq(arg1, arg2, arg3, arg4)
    }
  }
}

  case class Insert5Types[A1, A2, A3, A4, A5](cols: Tuple5[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5]]) extends InsertType[Tuple5[A1, A2, A3, A4, A5]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5) =>
        Seq(col1, col2, col3, col4, col5)
    }
  }

  def argsToSeq(args: Tuple5[A1, A2, A3, A4, A5]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5) =>
        Seq(arg1, arg2, arg3, arg4, arg5)
    }
  }
}

  case class Insert6Types[A1, A2, A3, A4, A5, A6](cols: Tuple6[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6]]) extends InsertType[Tuple6[A1, A2, A3, A4, A5, A6]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6) =>
        Seq(col1, col2, col3, col4, col5, col6)
    }
  }

  def argsToSeq(args: Tuple6[A1, A2, A3, A4, A5, A6]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6)
    }
  }
}

  case class Insert7Types[A1, A2, A3, A4, A5, A6, A7](cols: Tuple7[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7]]) extends InsertType[Tuple7[A1, A2, A3, A4, A5, A6, A7]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7) =>
        Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }

  def argsToSeq(args: Tuple7[A1, A2, A3, A4, A5, A6, A7]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7)
    }
  }
}

  case class Insert8Types[A1, A2, A3, A4, A5, A6, A7, A8](cols: Tuple8[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8]]) extends InsertType[Tuple8[A1, A2, A3, A4, A5, A6, A7, A8]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }

  def argsToSeq(args: Tuple8[A1, A2, A3, A4, A5, A6, A7, A8]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8)
    }
  }
}

  case class Insert9Types[A1, A2, A3, A4, A5, A6, A7, A8, A9](cols: Tuple9[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9]]) extends InsertType[Tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }

  def argsToSeq(args: Tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
    }
  }
}

  case class Insert10Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](cols: Tuple10[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10]]) extends InsertType[Tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }

  def argsToSeq(args: Tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10)
    }
  }
}

  case class Insert11Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](cols: Tuple11[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11]]) extends InsertType[Tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }

  def argsToSeq(args: Tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11)
    }
  }
}

  case class Insert12Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](cols: Tuple12[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12]]) extends InsertType[Tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }

  def argsToSeq(args: Tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12)
    }
  }
}

  case class Insert13Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](cols: Tuple13[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13]]) extends InsertType[Tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }

  def argsToSeq(args: Tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13)
    }
  }
}

  case class Insert14Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](cols: Tuple14[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14]]) extends InsertType[Tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }

  def argsToSeq(args: Tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14)
    }
  }
}

  case class Insert15Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](cols: Tuple15[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15]]) extends InsertType[Tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }

  def argsToSeq(args: Tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15)
    }
  }
}

  case class Insert16Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](cols: Tuple16[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16]]) extends InsertType[Tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }

  def argsToSeq(args: Tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16)
    }
  }
}

  case class Insert17Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](cols: Tuple17[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17]]) extends InsertType[Tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }

  def argsToSeq(args: Tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17)
    }
  }
}

  case class Insert18Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](cols: Tuple18[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18]]) extends InsertType[Tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }

  def argsToSeq(args: Tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18)
    }
  }
}

  case class Insert19Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](cols: Tuple19[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19]]) extends InsertType[Tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }

  def argsToSeq(args: Tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19)
    }
  }
}

  case class Insert20Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](cols: Tuple20[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20]]) extends InsertType[Tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }

  def argsToSeq(args: Tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20)
    }
  }
}

  case class Insert21Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](cols: Tuple21[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21]]) extends InsertType[Tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }

  def argsToSeq(args: Tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21)
    }
  }
}

  case class Insert22Types[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](cols: Tuple22[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21], TypeCol[A22]]) extends InsertType[Tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22]] {

  def toSeq = {
    cols match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }

  def argsToSeq(args: Tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22]) = {
    args match {
      case (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22) =>
        Seq(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22)
    }
  }
}
