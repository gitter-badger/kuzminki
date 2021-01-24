package kuzminki.model


class ParamConvSingle[S](col: ValConv[S]) extends ParamConv[S] {

  def fromShape(param: S) = Vector(param) 
}