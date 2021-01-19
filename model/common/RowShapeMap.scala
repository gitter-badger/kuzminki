package kuzminki.model

import io.rdbc.sapi.Row


class RowShapeMap(val cols: Seq[TypeCol[_]]) extends RowShape[Map[String, Any]] {

  cols.foreach {
    case col: ModelCol =>
    case _ => throw KuzminkiException("only table columns")
  }

  private val indexedCols = cols.zipWithIndex

  def fromRow(row: Row) = {
    indexedCols.map {
      case (col, index) =>
        (col.render.replace("\"", ""), col.get(row, index))
    }.toMap
  }
}