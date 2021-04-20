package kuzminki.model

import io.rdbc.sapi.Row


class RowConvSeq(val cols: Seq[ValConv[_]]) extends RowConv[Seq[Any]] {

  private val indexedCols = cols.zipWithIndex

  def fromRow(row: Row) = {
    indexedCols.map {
      case (col, index) =>
        col.get(row, index)
    }
  }
}