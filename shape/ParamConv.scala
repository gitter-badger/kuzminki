package kuzminki.model


trait ParamConv[P] {
  def fromShape(params: P): Vector[Any]
}
