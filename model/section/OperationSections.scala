package kuzminki.model


case class ReturningSec(parts: Seq[RenderableCol]) extends MultiPart {
  def expression = "RETURNING %s"
  def glue = ", "
}

case class CountFromSec(part: ModelTable) extends SinglePart {
  def expression = "SELECT COUNT(*) FROM %s"
}

case class DeleteFromSec(part: ModelTable) extends SinglePart {
  def expression = "DELETE FROM %s"
}

case class UpdateSec(part: ModelTable) extends SinglePart {
  def expression = "UPDATE %s"
}

case class UpdateSetSec(parts: Seq[Assign]) extends MultiPart {
  def expression = "SET %s"
  def glue = ", "
}