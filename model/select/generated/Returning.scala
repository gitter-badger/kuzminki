package kuzminki.model.operation

import kuzminki.model._


class Returning[M <: Model](coll: OperationCollector[M]) extends RunOperation(coll) {

  private def typedReturning[R](transformer: TupleTransformer[R]) = {
    new RunReturning(
      Collector.forTypedReturning(
        coll,
        transformer
      )
    )
  }

  def returning1(pick: M => TypeCol[_]) = {
    typedReturning(
      SingleCol(pick(coll.model))
    )
  }
  
  def returning2[A1, A2](pick: M => Tuple2[TypeCol[A1], TypeCol[A2]]) = {
    typedReturning(
      Tuple2Cols(pick(coll.model))
    )
  }

  def returning3[A1, A2, A3](pick: M => Tuple3[TypeCol[A1], TypeCol[A2], TypeCol[A3]]) = {
    typedReturning(
      Tuple3Cols(pick(coll.model))
    )
  }

  def returning4[A1, A2, A3, A4](pick: M => Tuple4[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4]]) = {
    typedReturning(
      Tuple4Cols(pick(coll.model))
    )
  }

  def returning5[A1, A2, A3, A4, A5](pick: M => Tuple5[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5]]) = {
    typedReturning(
      Tuple5Cols(pick(coll.model))
    )
  }

  def returning6[A1, A2, A3, A4, A5, A6](pick: M => Tuple6[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6]]) = {
    typedReturning(
      Tuple6Cols(pick(coll.model))
    )
  }

  def returning7[A1, A2, A3, A4, A5, A6, A7](pick: M => Tuple7[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7]]) = {
    typedReturning(
      Tuple7Cols(pick(coll.model))
    )
  }

  def returning8[A1, A2, A3, A4, A5, A6, A7, A8](pick: M => Tuple8[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8]]) = {
    typedReturning(
      Tuple8Cols(pick(coll.model))
    )
  }

  def returning9[A1, A2, A3, A4, A5, A6, A7, A8, A9](pick: M => Tuple9[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9]]) = {
    typedReturning(
      Tuple9Cols(pick(coll.model))
    )
  }

  def returning10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](pick: M => Tuple10[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10]]) = {
    typedReturning(
      Tuple10Cols(pick(coll.model))
    )
  }

  def returning11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](pick: M => Tuple11[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11]]) = {
    typedReturning(
      Tuple11Cols(pick(coll.model))
    )
  }

  def returning12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](pick: M => Tuple12[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12]]) = {
    typedReturning(
      Tuple12Cols(pick(coll.model))
    )
  }

  def returning13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](pick: M => Tuple13[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13]]) = {
    typedReturning(
      Tuple13Cols(pick(coll.model))
    )
  }

  def returning14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](pick: M => Tuple14[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14]]) = {
    typedReturning(
      Tuple14Cols(pick(coll.model))
    )
  }

  def returning15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](pick: M => Tuple15[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15]]) = {
    typedReturning(
      Tuple15Cols(pick(coll.model))
    )
  }

  def returning16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](pick: M => Tuple16[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16]]) = {
    typedReturning(
      Tuple16Cols(pick(coll.model))
    )
  }

  def returning17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](pick: M => Tuple17[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17]]) = {
    typedReturning(
      Tuple17Cols(pick(coll.model))
    )
  }

  def returning18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](pick: M => Tuple18[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18]]) = {
    typedReturning(
      Tuple18Cols(pick(coll.model))
    )
  }

  def returning19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](pick: M => Tuple19[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19]]) = {
    typedReturning(
      Tuple19Cols(pick(coll.model))
    )
  }

  def returning20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](pick: M => Tuple20[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20]]) = {
    typedReturning(
      Tuple20Cols(pick(coll.model))
    )
  }

  def returning21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](pick: M => Tuple21[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21]]) = {
    typedReturning(
      Tuple21Cols(pick(coll.model))
    )
  }

  def returning22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](pick: M => Tuple22[TypeCol[A1], TypeCol[A2], TypeCol[A3], TypeCol[A4], TypeCol[A5], TypeCol[A6], TypeCol[A7], TypeCol[A8], TypeCol[A9], TypeCol[A10], TypeCol[A11], TypeCol[A12], TypeCol[A13], TypeCol[A14], TypeCol[A15], TypeCol[A16], TypeCol[A17], TypeCol[A18], TypeCol[A19], TypeCol[A20], TypeCol[A21], TypeCol[A22]]) = {
    typedReturning(
      Tuple22Cols(pick(coll.model))
    )
  }
}