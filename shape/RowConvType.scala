package kuzminki.model

import io.rdbc.sapi.Row


class RowConvType[R](typeReader: TypeReader[R]) extends RowConv[R] {

  def fromRow(row: Row) = typeReader.read(row)
}