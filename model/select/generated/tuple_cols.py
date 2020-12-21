#! /usr/bin/env python



model = """
  def cols2[A1, A2](pick: M => Tuple2[TypeCol[A1], TypeCol[A2]]) = {
    tupledWhere(Tuple2Cols(pick(model)))
  }"""

func = """
  def cols%s[%s](pick: M => Tuple%s[%s]) = {
    tupledWhere(Tuple%sCols(pick(model)))
  }"""



template = """package kuzminki.model.select

import kuzminki.model._


trait TupleCols[M <: Model] {

  val model: M
  val conn: Connection

  private def tupledWhere[R](transformer: TupleTransformer[R]) = {
    new tupled.Where(
      TupleCollector.create(
        model,
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

f = open('./TupleCols.scala', 'w')
f.write(content)
f.close()