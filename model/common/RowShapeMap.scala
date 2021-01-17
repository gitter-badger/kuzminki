package kuzminki.model

import io.rdbc.sapi.Row


class RowShapeMap(val cols: Seq[TypeCol[_]]) extends RowShape[Map[String, Any]] {

  private val indexedCols = cols.zipWithIndex

  def fromRow(row: Row) = {
    indexedCols.map {
      case (col, index) =>
        (col.name, col.get(row, index))
    }.toMap
  }
}