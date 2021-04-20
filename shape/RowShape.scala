package kuzminki.model

import io.rdbc.sapi.Row


trait RowShape[R] {
  val cols: Seq[AnyCol]
  def conv: RowConv[R]
}

