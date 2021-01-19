package kuzminki.model

import io.rdbc.sapi.Row


trait RowShape[R] {
  def cols: Seq[RenderableCol]
  def fromRow(row: Row): R
}

