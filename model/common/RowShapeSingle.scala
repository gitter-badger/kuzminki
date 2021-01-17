package kuzminki.model

import io.rdbc.sapi.Row


class RowShape1[R](col: TypeCol[R]) extends RowShape[R] {

  def cols = Seq(col)

  def fromRow(row: Row) = col.get(row, 0)
}