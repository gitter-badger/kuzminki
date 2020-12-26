#! /usr/bin/env python


model = """
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
}"""

func = """
  case class Insert%sTypes[%s](cols: Tuple%s[%s]) extends InsertType[Tuple%s[%s]] {

  def toSeq = {
    cols match {
      case (%s) =>
        Seq(%s)
    }
  }

  def argsToSeq(args: Tuple%s[%s]) = {
    args match {
      case (%s) =>
        Seq(%s)
    }
  }
}"""



template = """package kuzminki.model.operation

import kuzminki.model._


trait InsertType[A] {
  def toSeq: Seq[ModelCol]
  def argsToSeq(arg: A): Seq[Any]
}

case class Insert1Type[A](col: TypeCol[A]) extends InsertType[A] {

  def toSeq = Seq(col)

  def argsToSeq(arg: A) = Seq(arg) 
}
%s
"""


parts = []

for num in range(2, 23):
    types = ', '.join(['A%d' % i for i in range(1, num + 1)])
    col_types = ', '.join(['TypeCol[A%d]' % i for i in range(1, num + 1)])
    col = ', '.join(['col%d' % i for i in range(1, num + 1)])
    arg = ', '.join(['arg%d' % i for i in range(1, num + 1)])
    
    part = func % (
      str(num),
      types,
      str(num),
      col_types,
      str(num),
      types,
      col,
      col,
      str(num),
      types,
      arg,
      arg,
    )
    
    parts.append(part)

content = template % "\n".join(parts)

f = open('./InsertType.scala', 'w')
f.write(content)
f.close()

