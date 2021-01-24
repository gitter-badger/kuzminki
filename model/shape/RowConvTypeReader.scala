package kuzminki.model

import io.rdbc.sapi.Row


class RowConvTypeReader[R](typeReader: TypeReader[R]) extends RowShape[R] {

  def fromRow(row: Row): R = typeReader.read(row)
}