package kuzminki.rdbc

import io.rdbc.sapi._


trait RowTransform extends {

  def as[T](row: Row)(implicit format: RowFormat[T]): T = {
    format.resolve(row)
  }

  def asOpt[T](rowOpt: Option[Row])(implicit format: RowFormat[T]): Option[T] = {
    rowOpt match {
      case Some(row) => Some(format.resolve(row))
      case None => None
    }
  }

  def asList[T](rows: List[Row])(implicit format: RowFormat[T]): List[T] = {
    rows.map(row => format.resolve(row))
  }
}