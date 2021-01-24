package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


trait ListInsert[S] {

  protected val template: String
  protected val inShape: DataShape[S]

  private lazy val argsTempl = "(%s)".format(Vector.fill(inShape.size)("?").mkString(", "))

  private def extend(template: String, num: Int) = {
    template.replace(
      argsTempl,
      Seq.fill(num)(argsTempl).mkString(", ")
    )
  }

  protected def listStatement(list: List[S]) = {
    list.size match {
      case 0 =>
        throw KuzminkiException("insert list cannot be empty")
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