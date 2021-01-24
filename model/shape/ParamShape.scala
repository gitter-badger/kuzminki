package kuzminki.model


trait ParamShape[S] {
  def size: Int
  def cols: Vector[ModelCol]
  def transformer: ParamShape[S]
}