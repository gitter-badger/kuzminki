package kuzminki.model

import io.rdbc.sapi.Row


trait RowShape[R] {
  def cols: Seq[AnyCol]
  def conv: RowConv[R]
}

