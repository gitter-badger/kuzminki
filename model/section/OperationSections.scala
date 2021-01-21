package kuzminki.model


case class ReturningSec(parts: Seq[RenderableCol]) extends MultiRender {
  def expression = "RETURNING %s"
  def glue = ", "
}

case class CountFromSec(part: ModelTable) extends SingleRender {
  def expression = "SELECT COUNT(*) FROM %s"
}

case class DeleteFromSec(part: ModelTable) extends SingleRender {
  def expression = "DELETE FROM %s"
}

case class UpdateSec(part: ModelTable) extends SingleRender {
  def expression = "UPDATE %s"
}

case class UpdateSetSec(parts: Seq[Assign]) extends MultiRender {
  def expression = "SET %s"
  def glue = ", "
}