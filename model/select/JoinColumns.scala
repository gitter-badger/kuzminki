package kuzminki.model.select

import kuzminki.model._


class JoinColumns[A <: Model, B <: Model](join: Join[A, B], conn: Connection) {

  def cols[R](pick: Join[A, B] => Seq[TypeCol[R]]) = {
    new indexedjoin.JoinOn(
      Collector.indexedJoin(
        join,
        pick(join),
        conn
      )
    )
  }

  private def next[R](transformer: TypedTransformer[R]) = {
    new typedjoin.JoinOn(
      Collector.typedJoin(
        join,
        transformer,
        conn
      )
    )
  }

  def cols1[R](pick: Join[A, B] => TypeCol[R]) = {
    next(
      TypedCols1(pick(join))
    )
  }
  
  def cols2[R1, R2](pick: Join[A, B] => Tuple2[TypeCol[R1], TypeCol[R2]]) = {
    next(
      TypedCols2(pick(join))
    )
  }

  def cols3[R1, R2, R3](pick: Join[A, B] => Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) = {
    next(
      TypedCols3(pick(join))
    )
  }

  def cols4[R1, R2, R3, R4](pick: Join[A, B] => Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) = {
    next(
      TypedCols4(pick(join))
    )
  }

  def cols5[R1, R2, R3, R4, R5](pick: Join[A, B] => Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) = {
    next(
      TypedCols5(pick(join))
    )
  }

  def cols6[R1, R2, R3, R4, R5, R6](pick: Join[A, B] => Tuple6[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6]]) = {
    next(
      TypedCols6(pick(join))
    )
  }

  def cols7[R1, R2, R3, R4, R5, R6, R7](pick: Join[A, B] => Tuple7[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7]]) = {
    next(
      TypedCols7(pick(join))
    )
  }

  def cols8[R1, R2, R3, R4, R5, R6, R7, R8](pick: Join[A, B] => Tuple8[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8]]) = {
    next(
      TypedCols8(pick(join))
    )
  }

  def cols9[R1, R2, R3, R4, R5, R6, R7, R8, R9](pick: Join[A, B] => Tuple9[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9]]) = {
    next(
      TypedCols9(pick(join))
    )
  }

  def cols10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](pick: Join[A, B] => Tuple10[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10]]) = {
    next(
      TypedCols10(pick(join))
    )
  }

  def cols11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](pick: Join[A, B] => Tuple11[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11]]) = {
    next(
      TypedCols11(pick(join))
    )
  }

  def cols12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](pick: Join[A, B] => Tuple12[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12]]) = {
    next(
      TypedCols12(pick(join))
    )
  }

  def cols13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](pick: Join[A, B] => Tuple13[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13]]) = {
    next(
      TypedCols13(pick(join))
    )
  }

  def cols14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](pick: Join[A, B] => Tuple14[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14]]) = {
    next(
      TypedCols14(pick(join))
    )
  }

  def cols15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](pick: Join[A, B] => Tuple15[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15]]) = {
    next(
      TypedCols15(pick(join))
    )
  }

  def cols16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](pick: Join[A, B] => Tuple16[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16]]) = {
    next(
      TypedCols16(pick(join))
    )
  }

  def cols17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](pick: Join[A, B] => Tuple17[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17]]) = {
    next(
      TypedCols17(pick(join))
    )
  }

  def cols18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](pick: Join[A, B] => Tuple18[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18]]) = {
    next(
      TypedCols18(pick(join))
    )
  }

  def cols19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](pick: Join[A, B] => Tuple19[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19]]) = {
    next(
      TypedCols19(pick(join))
    )
  }

  def cols20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](pick: Join[A, B] => Tuple20[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20]]) = {
    next(
      TypedCols20(pick(join))
    )
  }

  def cols21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](pick: Join[A, B] => Tuple21[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21]]) = {
    next(
      TypedCols21(pick(join))
    )
  }

  def cols22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](pick: Join[A, B] => Tuple22[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21], TypeCol[R22]]) = {
    next(
      TypedCols22(pick(join))
    )
  }
}