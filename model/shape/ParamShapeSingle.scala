package kuzminki.model


class ParamShapeSingle[S](col: TypeCol[S]) extends ParamShape[S] {
  def size = 1
  def cols = Vector(col)
  def transformer = new ParamShapeSingle(col.conv) 
}