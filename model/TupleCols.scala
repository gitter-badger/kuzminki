package kuzminki.model


abstract class TupleCols[T <: Model](model: T, exec: Executor) {

  val model: T

  def cols(func: T => Tuple2[TypeCol[A1], TypeCol[A2]]): Where[T] = {
    sections.select(new Tuple2Cols(func(model)))
  }
}