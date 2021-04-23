package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait InsertList[P] {

  protected val template: String
  protected val paramConv: ParamConv[P]
  protected def tansformParams(params: P): Vector[Any]

  private def extend(template: String, rowNum: Int, argNum: Int) = {
    val single = "(%s)".format(Seq.fill(argNum)("?").mkString(", "))
    val multiple = Seq.fill(rowNum)(single).mkString(", ")
    template.replace(single, multiple)
  }

  protected def listStatement(list: List[P]) = {
    list.map(tansformParams) match {
      case Nil =>
        throw KuzminkiException("insert list cannot be empty")
      case head :: Nil =>
        SqlWithParams(template, head)
      case arguments =>
        SqlWithParams(
          extend(template, arguments.size, arguments.head.size),
          arguments.flatten.toVector
        )
    }
  }
}