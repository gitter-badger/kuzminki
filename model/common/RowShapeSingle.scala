package kuzminki.model

import io.rdbc.sapi.Row


class RowShape1[R](col: TypeCol[R]) extends RowShape[R] {

  def cols: Seq[ModelCol] = Seq(col)

  def fromRow(row: Row): R = col.get(row, 0)
}