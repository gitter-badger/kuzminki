package kuzminki.model.operation

import kuzminki.model._


abstract class TypedInsert[M <: Model](model: M, conn: Connection) {

  def col(pick: M => TypeCol[_]) = {
    new TypedValues(model, conn, new Insert1Type(pick(model)))
  }
  
  def cols2[A1, A2](pick: M => Tuple2[TypeCol[A1], TypeCol[A2]]) = {
    new TypedValues(model, conn, new Insert2Types(pick(model)))
  }

  def cols3[A1, A2, A3](pick: M => Tuple3[TypeCol[A1], TypeCol[A2], TypeCol[A3]]) = {
    new TypedValues(model, conn, new Insert3Types(pick(model)))
  }

  def cols4[A1, A2, A3, A4](pick: M => Tuple4[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4]]) = {
    new TypedValues(model, conn, new Insert4Types(pick(model)))
  }

  def cols5[A1, A2, A3, A4, A5](pick: M => Tuple5[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5]]) = {
    new TypedValues(model, conn, new Insert5Types(pick(model)))
  }

  def cols6[A1, A2, A3, A4, A5, A6](pick: M => Tuple6[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6]]) = {
    new TypedValues(model, conn, new Insert6Types(pick(model)))
  }

  def cols7[A1, A2, A3, A4, A5, A6, A7](pick: M => Tuple7[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7]]) = {
    new TypedValues(model, conn, new Insert7Types(pick(model)))
  }

  def cols8[A1, A2, A3, A4, A5, A6, A7, A8](pick: M => Tuple8[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8]]) = {
    new TypedValues(model, conn, new Insert8Types(pick(model)))
  }

  def cols9[A1, A2, A3, A4, A5, A6, A7, A8, A9](pick: M => Tuple9[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9]]) = {
    new TypedValues(model, conn, new Insert9Types(pick(model)))
  }

  def cols10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](pick: M => Tuple10[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10]]) = {
    new TypedValues(model, conn, new Insert10Types(pick(model)))
  }

  def cols11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](pick: M => Tuple11[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11]]) = {
    new TypedValues(model, conn, new Insert11Types(pick(model)))
  }

  def cols12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](pick: M => Tuple12[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12]]) = {
    new TypedValues(model, conn, new Insert12Types(pick(model)))
  }

  def cols13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](pick: M => Tuple13[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13]]) = {
    new TypedValues(model, conn, new Insert13Types(pick(model)))
  }

  def cols14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](pick: M => Tuple14[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14]]) = {
    new TypedValues(model, conn, new Insert14Types(pick(model)))
  }

  def cols15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](pick: M => Tuple15[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15]]) = {
    new TypedValues(model, conn, new Insert15Types(pick(model)))
  }

  def cols16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](pick: M => Tuple16[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16]]) = {
    new TypedValues(model, conn, new Insert16Types(pick(model)))
  }

  def cols17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](pick: M => Tuple17[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17]]) = {
    new TypedValues(model, conn, new Insert17Types(pick(model)))
  }

  def cols18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](pick: M => Tuple18[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18]]) = {
    new TypedValues(model, conn, new Insert18Types(pick(model)))
  }

  def cols19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](pick: M => Tuple19[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19]]) = {
    new TypedValues(model, conn, new Insert19Types(pick(model)))
  }

  def cols20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](pick: M => Tuple20[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20]]) = {
    new TypedValues(model, conn, new Insert20Types(pick(model)))
  }

  def cols21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](pick: M => Tuple21[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21]]) = {
    new TypedValues(model, conn, new Insert21Types(pick(model)))
  }

  def cols22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](pick: M => Tuple22[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21], TypeCol[A22]]) = {
    new TypedValues(model, conn, new Insert22Types(pick(model)))
  }
}