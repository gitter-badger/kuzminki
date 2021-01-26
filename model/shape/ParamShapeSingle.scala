package kuzminki.model


class ParamShapeSingle[P](col: TypeCol[P]) extends ParamShape[P] {
  def size = 1
  def cols = Vector(col)
  def conv = new ParamConvSingle(col.conv) 
}