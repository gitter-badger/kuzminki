package kuzminki.model.operation

import kuzminki.model._


trait InsertType[T] {
  def toSeq: Seq[ModelCol]
  def argsToSeq(arg: T): Seq[Any]
}

case class Insert1Type[T](col: TypeCol[T]) extends InsertType[T] {

  def toSeq = Seq(col)

  def argsToSeq(arg: T) = Seq(arg) 
}

case class Insert2Types[T1, T2](cols: Tuple2[TypeCol[T1], TypeCol[T2]]) extends InsertType[Tuple2[T1, T2]] {

  def toSeq = {
    cols match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }

  def argsToSeq(args: Tuple2[T1, T2]) = {
    args match {
      case (arg1, arg2) =>
        Seq(arg1, arg2)
    }
  }
}