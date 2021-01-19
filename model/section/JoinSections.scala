package kuzminki.model


case class OnSec(leftCol: ModelCol, rightCol: ModelCol) extends Section {
  def expression = "ON %s = %s"
  def render = expression.format(leftCol.render, rightCol.render)
  def prefix(picker: Prefix) = expression.format(leftCol.prefix(picker), rightCol.prefix(picker))
  def args = Seq.empty[Any]
}

case class InnerJoinSec(part: ModelTable) extends SinglePart {
  def expression = "INNER JOIN %s"
}


case class LeftJoinSec(part: ModelTable) extends SinglePart {
  def expression = "LEFT JOIN %s"
}


case class LeftOuterJoinSec(part: ModelTable) extends SinglePart {
  def expression = "LEFT OUTER JOIN %s"
}


case class RightJoinSec(part: ModelTable) extends SinglePart {
  def expression = "RIGHT JOIN %s"
}


case class RightOuterJoinSec(part: ModelTable) extends SinglePart {
  def expression = "RIGHT OUTER JOIN %s"
}


case class FullOuterJoinSec(part: ModelTable) extends SinglePart {
  def expression = "FULL OUTER JOIN %s"
}


case class CrossJoinSec(part: ModelTable) extends SinglePart {
  def expression = "CROSS JOIN %s"
}




















