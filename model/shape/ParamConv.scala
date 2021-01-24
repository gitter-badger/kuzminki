package kuzminki.model


trait ParamConv[S] {
  def fromShape(params: S): Vector[S]
}
