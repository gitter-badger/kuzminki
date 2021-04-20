package kuzminki.model


trait ParamShape[P] {
  def size: Int
  def cols: Seq[AnyCol]
  def conv: ParamConv[P]
}