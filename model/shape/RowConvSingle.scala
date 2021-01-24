package kuzminki.model

import io.rdbc.sapi.Row


class RowConvSingle[R](col: ValConv[R]) extends RowConv[R] {

  def fromRow(row: Row) = col.get(row, 0)
}