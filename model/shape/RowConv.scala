package kuzminki.model

import io.rdbc.sapi.Row


trait RowConv[R] {
  def fromRow(row: Row): R
}
