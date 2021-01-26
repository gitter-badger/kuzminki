package kuzminki.model

import io.rdbc.sapi.Row


class RowShapeSingle[R](col: TypeCol[R]) extends RowShape[R] {
  
  def cols = Seq(col)
  
  def conv = new RowConvSingle(col.conv)
}