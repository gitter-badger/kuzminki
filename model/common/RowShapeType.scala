package kuzminki.model

import io.rdbc.sapi.Row


class RowShapeType[R](
      val cols: Seq[TypeCol[_]],
          typeReader: TypeReader[R]
    ) extends RowShape[R] {

  def fromRow(row: Row): R = typeReader.read(row)
}