#! /usr/bin/env python


model = """
  def cols2[T1, T2](pick: M => Tuple2[TypeCol[T1], TypeCol[T2]]) = {
    TypedValues(model, conn, Insert2Types(pick(model)))
  }"""

func = """
  def cols%s[%s](pick: M => Tuple%s[%s]) = {
    TypedValues(model, conn, Insert%sTypes(pick(model)))
  }"""



template = """package kuzminki.model.operation

import kuzminki.model._


trait TypedInsert[M <: Model] {

  val model: M
  val conn: Connection

  def col(pick: M => TypeCol[_]) = {
    TypedValues(model, conn, Insert1Type(pick(model)))
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

f = open('./TypedInsert.scala', 'w')
f.write(content)
f.close()