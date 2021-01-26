package kuzminki.model


class ParamConvSingle[P](col: ValConv[P]) extends ParamConv[P] {

  def fromShape(param: P) = Vector(param) 
}