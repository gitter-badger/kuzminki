package kuzminki.model

import io.rdbc.sapi.Row


class RowShapeSeq(val cols: Seq[TypeCol[_]]) extends RowShape[Seq[Any]] {

  private val indexedCols = cols.zipWithIndex

  def fromRow(row: Row) = {
    indexedCols.map {
      case (col, index) =>
        col.get(row, index)
    }
  }
}