#! /usr/bin/env python



model = """
  def cols2[A1, A2](pick: Join[A, B] => Tuple2[TypeCol[A1], TypeCol[A2]]) = {
    tupledWhere(Tuple2Cols(pick(join)))
  }"""

func = """
  def cols%s[%s](pick: Join[A, B] => Tuple%s[%s]) = {
    tupledWhere(Tuple%sCols(pick(join)))
  }"""



template = """package kuzminki.model.select

import kuzminki.model._


trait TupleJoinCols[A <: Model, B <: Model] {

  val join: Join[A, B]
  val conn: Connection

  private def tupledWhere[R](transformer: TupleTransformer[R]) = {
    new tupledJoin.JoinOn(
      Collector.tupleJoin(
        join,
        transformer,
        conn
      )
    )
  }
  %s
}"""


parts = []

for num in range(2, 23):
    func_types = ', '.join(['A%d' % i for i in range(1, num + 1)])
    col_types = ', '.join(['TypeCol[A%d]' % i for i in range(1, num + 1)])
    part = func % (str(num), func_types, str(num), col_types, str(num),)
    parts.append(part)

content = template % "\n".join(parts)

f = open('./TupleJoinCols.scala', 'w')
f.write(content)
f.close()