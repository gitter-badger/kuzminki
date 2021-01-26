package kuzminki.model

import io.rdbc.sapi.Row


class RowShapeSeq(val cols: Seq[TypeCol[_]]) extends RowShape[Seq[Any]] {
  
  def conv = new RowConvSeq(cols.map(_.conv)) 
}