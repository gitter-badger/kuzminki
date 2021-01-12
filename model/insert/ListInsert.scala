package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


trait ListInsert[S] {

  protected val template: String
  protected val shape: InsertShape[S]

  protected def transform(data: S) = shape.transform(data)
  protected def statement(data: S) = SqlWithParams(template, transform(data))

  private lazy val argsTempl = "(%s)".format(Vector.fill(in.size)("?").mkString(", "))

  private def extend(template: String, num: Int) = {
    template.replace(
      args,
      Seq.fill(num)(argsTempl).mkString(", ")
    )
  }

  protected def listStatement(list: List[N]) = {
    list.size match {
      case 0 =>
        throw KuzminkiModelException("insert list cannot be empty")
      case 1 =>
        SqlWithParams(template, transform(list.head))
      case _ =>
        SqlWithParams(
          extend(template, list.size),
          list.map(transform).flatten.toVector
        )
    }
  }
}