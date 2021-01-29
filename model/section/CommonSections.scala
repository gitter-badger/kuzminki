package kuzminki.model


case class SelectSec(parts: Seq[AnyCol]) extends NotEmpty(parts) with MultiRender {
  def error = "no columns selected"
  def expression = "SELECT %s"
  def glue = ", "
}

case class FromSec(part: ModelTable) extends SingleRender {
  def expression = "FROM %s"
}

case class WhereSec(parts: Seq[Renderable]) extends NotEmpty(parts) with MultiRender {
  def error = "WHERE cannot be empty"
  def expression = "WHERE %s"
  def glue = " AND "
}

case class GroupBySec(parts: Seq[AnyCol]) extends NotEmpty(parts) with MultiRender {
  def error = "WHERE BY cannot be empty"
  def expression = "GROUP BY %s"
  def glue = ", "
}

case class HavingSec(parts: Seq[Renderable]) extends NotEmpty(parts) with MultiRender {
  def error = "HAVING cannot be empty"
  def expression = "HAVING %s"
  def glue = " AND "
}

case class OrderBySec(parts: Seq[Sorting]) extends NotEmpty(parts) with MultiRender {
  def error = "ORDER BY cannot be empty"
  def expression = "ORDER BY %s"
  def glue = ", "
}

case class OffsetSec(arg: Int) extends SingleArg {
  def expression = "OFFSET ?"
}

case class LimitSec(arg: Int) extends SingleArg {
  def expression = "LIMIT ?"
}