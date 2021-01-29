package kuzminki.model

import io.rdbc.sapi.Row


class RowShapeSingle[R](col: TypeCol[R]) extends RowShape[R] {
  val cols = Seq(col)
  def conv = new RowConvSingle(col.conv)
}