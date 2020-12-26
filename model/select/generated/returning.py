#! /usr/bin/env python



model = """
  def returning1(pick: M => TypeCol[_]) = {
    new RunReturning(
      Collector.forReturningTuple(
        coll,
        SingleCol(pick(coll.model))
      )
    )
  }"""

func = """
  def returning%s[%s](pick: M => Tuple%s[%s]) = {
    typedReturning(
      Tuple%sCols(pick(coll.model))
    )
  }"""



template = """package kuzminki.model.operation

import kuzminki.model._


class Returning[M <: Model](coll: OperationCollector[M]) extends RunOperation(coll) { 

  private def typedReturning[R](transformer: TupleTransformer[R]) = {
    new RunReturning(
      Collector.forTypedReturning(
        coll,
        transformer
      )
    )
  }

  def returning1(pick: M => TypeCol[_]) = {
    typedReturning(
      SingleCol(pick(coll.model))
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

f = open('./Returning.scala', 'w')
f.write(content)
f.close()