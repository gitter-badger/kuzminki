package kuzminki.model.operation

import kuzminki.model._


class Returning[M <: Model](coll: OperationCollector[M]) extends RunOperation(coll) { 

  private def typedReturning[R](transformer: TypedTransformer[R]) = {
    new RunReturning(
      Collector.forTypedReturning(
        coll,
        transformer
      )
    )
  }

  def returning1[R](pick: M => TypeCol[R]) = {
    typedReturning(
      TypedCols1(pick(coll.model))
    )
  }
  
  def returning2[R1, R2](pick: M => Tuple2[TypeCol[R1], TypeCol[R2]]) = {
    typedReturning(
      TypedCols2(pick(coll.model))
    )
  }

  def returning3[R1, R2, R3](pick: M => Tuple3[TypeCol[R1], TypeCol[R2], TypeCol[R3]]) = {
    typedReturning(
      TypedCols3(pick(coll.model))
    )
  }

  def returning4[R1, R2, R3, R4](pick: M => Tuple4[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4]]) = {
    typedReturning(
      TypedCols4(pick(coll.model))
    )
  }

  def returning5[R1, R2, R3, R4, R5](pick: M => Tuple5[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5]]) = {
    typedReturning(
      TypedCols5(pick(coll.model))
    )
  }

  def returning6[R1, R2, R3, R4, R5, R6](pick: M => Tuple6[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6]]) = {
    typedReturning(
      TypedCols6(pick(coll.model))
    )
  }

  def returning7[R1, R2, R3, R4, R5, R6, R7](pick: M => Tuple7[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7]]) = {
    typedReturning(
      TypedCols7(pick(coll.model))
    )
  }

  def returning8[R1, R2, R3, R4, R5, R6, R7, R8](pick: M => Tuple8[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8]]) = {
    typedReturning(
      TypedCols8(pick(coll.model))
    )
  }

  def returning9[R1, R2, R3, R4, R5, R6, R7, R8, R9](pick: M => Tuple9[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9]]) = {
    typedReturning(
      TypedCols9(pick(coll.model))
    )
  }

  def returning10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](pick: M => Tuple10[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10]]) = {
    typedReturning(
      TypedCols10(pick(coll.model))
    )
  }

  def returning11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](pick: M => Tuple11[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11]]) = {
    typedReturning(
      TypedCols11(pick(coll.model))
    )
  }

  def returning12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](pick: M => Tuple12[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12]]) = {
    typedReturning(
      TypedCols12(pick(coll.model))
    )
  }

  def returning13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](pick: M => Tuple13[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13]]) = {
    typedReturning(
      TypedCols13(pick(coll.model))
    )
  }

  def returning14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](pick: M => Tuple14[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14]]) = {
    typedReturning(
      TypedCols14(pick(coll.model))
    )
  }

  def returning15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](pick: M => Tuple15[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15]]) = {
    typedReturning(
      TypedCols15(pick(coll.model))
    )
  }

  def returning16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](pick: M => Tuple16[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16]]) = {
    typedReturning(
      TypedCols16(pick(coll.model))
    )
  }

  def returning17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](pick: M => Tuple17[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17]]) = {
    typedReturning(
      TypedCols17(pick(coll.model))
    )
  }

  def returning18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](pick: M => Tuple18[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18]]) = {
    typedReturning(
      TypedCols18(pick(coll.model))
    )
  }

  def returning19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](pick: M => Tuple19[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19]]) = {
    typedReturning(
      TypedCols19(pick(coll.model))
    )
  }

  def returning20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](pick: M => Tuple20[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20]]) = {
    typedReturning(
      TypedCols20(pick(coll.model))
    )
  }

  def returning21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](pick: M => Tuple21[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21]]) = {
    typedReturning(
      TypedCols21(pick(coll.model))
    )
  }

  def returning22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](pick: M => Tuple22[TypeCol[R1], TypeCol[R2], TypeCol[R3], TypeCol[R4], TypeCol[R5], TypeCol[R6], TypeCol[R7], TypeCol[R8], TypeCol[R9], TypeCol[R10], TypeCol[R11], TypeCol[R12], TypeCol[R13], TypeCol[R14], TypeCol[R15], TypeCol[R16], TypeCol[R17], TypeCol[R18], TypeCol[R19], TypeCol[R20], TypeCol[R21], TypeCol[R22]]) = {
    typedReturning(
      TypedCols22(pick(coll.model))
    )
  }
}