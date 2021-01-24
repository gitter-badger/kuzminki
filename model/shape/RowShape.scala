package kuzminki.model

import io.rdbc.sapi.Row


trait RowShape[R] {
  def cols: Seq[RenderableCol]
  def conv: RowConv[R]
}

