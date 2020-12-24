#! /usr/bin/env python



model = """
  case class Tuple2Cols[A1, A2](cols: Tuple2[TypeCol[A1], TypeCol[A2]]) extends TupleTransformer[Tuple2[A1, A2]] {

  def toSeq = {
    cols match {
      case (col1, col2) => Seq(col1, col2)
    }
  }

  def transform(row: Row) = {
    cols match {
      case (col1, col2) => (col1.get(row), col2.get(row))
    }
  }
}"""

func = """
case class Tuple%sCols[%s](cols: Tuple%s[%s]) extends TupleTransformer[Tuple%s[%s]] {

  def toSeq: Seq[ModelCol] = {
    cols match {
      case (%s) => Seq(%s)
    }
  }

  def transform(row: Row): Tuple%s[%s] = {
    cols match {
      case (%s) => (%s)
    }
  }
}"""



template = """package kuzminki.model

import io.rdbc.sapi._
import kuzminki.model._
import kuzminki.model.implicits._


trait TupleTransformer[T] {
  def toSeq: Seq[ModelCol]
  def transform(row: Row): T
}

  %s
"""


parts = []

for num in range(2, 23):
    types = ', '.join(['A%d' % i for i in range(1, num + 1)])
    col_types = ', '.join(['TypeCol[A%d]' % i for i in range(1, num + 1)])
    col = ', '.join(['col%d' % i for i in range(1, num + 1)])
    col_get = ', '.join(['col%d.get(row)' % i for i in range(1, num + 1)])
    
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
      col,
      col_get,
    )
    
    parts.append(part)

content = template % "\n".join(parts)

f = open('./TupleTransformer.scala', 'w')
f.write(content)
f.close()




