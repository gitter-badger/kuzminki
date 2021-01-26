package kuzminki.model


case class SelectSec(parts: Seq[AnyCol]) extends MultiRender {
  def expression = "SELECT %s"
  def glue = ", "
}

case class FromSec(part: ModelTable) extends SingleRender {
  def expression = "FROM %s"
}

case class WhereSec(parts: Seq[Renderable]) extends MultiRender {
  def expression = "WHERE %s"
  def glue = " AND "
}

case class GroupBySec(parts: Seq[AnyCol]) extends MultiRender {
  def expression = "GROUP BY %s"
  def glue = ", "
}

case class HavingSec(parts: Seq[Renderable]) extends MultiRender {
  def expression = "HAVING %s"
  def glue = " AND "
}

case class OrderBySec(parts: Seq[Sorting]) extends MultiRender {
  def expression = "ORDER BY %s"
  def glue = ", "
}

case class OffsetSec(arg: Int) extends SingleArg {
  def expression = "OFFSET ?"
}

case class LimitSec(arg: Int) extends SingleArg {
  def expression = "LIMIT ?"
}