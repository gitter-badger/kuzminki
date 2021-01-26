package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait InsertStatement[P] {
  
  protected val template: String
  protected def tansformParams(params: P): Vector[Any]

  protected def statement(params: P) = {
    SqlWithParams(
      template,
      tansformParams(params)
    )
  }
}