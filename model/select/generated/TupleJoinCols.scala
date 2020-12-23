package kuzminki.model.select

import kuzminki.model._


trait TupleJoinCols[A <: Model, B <: Model] {

  val join: Join[A, B]
  val conn: Connection

  private def tupledWhere[R](transformer: TupleTransformer[R]) = {
    new tupledJoin.JoinOn(
      Collector.tupleJoin(
        join,
        transformer,
        conn
      )
    )
  }
  
  def cols2[A1, A2](pick: Join[A, B] => Tuple2[TypeCol[A1], TypeCol[A2]]) = {
    tupledWhere(Tuple2Cols(pick(join)))
  }

  def cols3[A1, A2, A3](pick: Join[A, B] => Tuple3[TypeCol[A1], TypeCol[A2], TypeCol[A3]]) = {
    tupledWhere(Tuple3Cols(pick(join)))
  }

  def cols4[A1, A2, A3, A4](pick: Join[A, B] => Tuple4[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4]]) = {
    tupledWhere(Tuple4Cols(pick(join)))
  }

  def cols5[A1, A2, A3, A4, A5](pick: Join[A, B] => Tuple5[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5]]) = {
    tupledWhere(Tuple5Cols(pick(join)))
  }

  def cols6[A1, A2, A3, A4, A5, A6](pick: Join[A, B] => Tuple6[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6]]) = {
    tupledWhere(Tuple6Cols(pick(join)))
  }

  def cols7[A1, A2, A3, A4, A5, A6, A7](pick: Join[A, B] => Tuple7[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7]]) = {
    tupledWhere(Tuple7Cols(pick(join)))
  }

  def cols8[A1, A2, A3, A4, A5, A6, A7, A8](pick: Join[A, B] => Tuple8[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8]]) = {
    tupledWhere(Tuple8Cols(pick(join)))
  }

  def cols9[A1, A2, A3, A4, A5, A6, A7, A8, A9](pick: Join[A, B] => Tuple9[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9]]) = {
    tupledWhere(Tuple9Cols(pick(join)))
  }

  def cols10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](pick: Join[A, B] => Tuple10[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10]]) = {
    tupledWhere(Tuple10Cols(pick(join)))
  }

  def cols11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](pick: Join[A, B] => Tuple11[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11]]) = {
    tupledWhere(Tuple11Cols(pick(join)))
  }

  def cols12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](pick: Join[A, B] => Tuple12[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12]]) = {
    tupledWhere(Tuple12Cols(pick(join)))
  }

  def cols13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](pick: Join[A, B] => Tuple13[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13]]) = {
    tupledWhere(Tuple13Cols(pick(join)))
  }

  def cols14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](pick: Join[A, B] => Tuple14[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14]]) = {
    tupledWhere(Tuple14Cols(pick(join)))
  }

  def cols15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](pick: Join[A, B] => Tuple15[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15]]) = {
    tupledWhere(Tuple15Cols(pick(join)))
  }

  def cols16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](pick: Join[A, B] => Tuple16[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16]]) = {
    tupledWhere(Tuple16Cols(pick(join)))
  }

  def cols17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](pick: Join[A, B] => Tuple17[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17]]) = {
    tupledWhere(Tuple17Cols(pick(join)))
  }

  def cols18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](pick: Join[A, B] => Tuple18[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18]]) = {
    tupledWhere(Tuple18Cols(pick(join)))
  }

  def cols19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](pick: Join[A, B] => Tuple19[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19]]) = {
    tupledWhere(Tuple19Cols(pick(join)))
  }

  def cols20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](pick: Join[A, B] => Tuple20[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20]]) = {
    tupledWhere(Tuple20Cols(pick(join)))
  }

  def cols21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](pick: Join[A, B] => Tuple21[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21]]) = {
    tupledWhere(Tuple21Cols(pick(join)))
  }

  def cols22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](pick: Join[A, B] => Tuple22[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21], TypeCol[A22]]) = {
    tupledWhere(Tuple22Cols(pick(join)))
  }
}