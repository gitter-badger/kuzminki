package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait InsertList[P] {

  protected val template: String
  protected val paramConv: ParamConv[P]
  protected def tansformParams(params: P): Vector[Any]

  private lazy val argsTempl = {
    val parts = template.split(" ")
    val index = parts.indexOf("VALUES") + 1
    parts(index)
  }

  private def extend(template: String, num: Int) = {
    template.replace(
      argsTempl,
      Seq.fill(num)(argsTempl).mkString(", ")
    )
  }

  protected def listStatement(list: List[P]) = {
    list.size match {
      case 0 =>
        throw KuzminkiException("insert list cannot be empty")
      case 1 =>
        SqlWithParams(template, tansformParams(list.head))
      case _ =>
        SqlWithParams(
          extend(template, list.size),
          list.map(tansformParams).flatten.toVector
        )
    }
  }
}