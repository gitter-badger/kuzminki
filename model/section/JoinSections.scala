package kuzminki.model


case class OnSec(leftCol: AnyCol, rightCol: AnyCol) extends Section with NoArgs {
  def expression = "ON %s = %s"
  def render(prefix: Prefix) = expression.format(leftCol.render(prefix), rightCol.render(prefix))
}

case class InnerJoinSec(part: ModelTable) extends SingleRender {
  def expression = "INNER JOIN %s"
}


case class LeftJoinSec(part: ModelTable) extends SingleRender {
  def expression = "LEFT JOIN %s"
}


case class LeftOuterJoinSec(part: ModelTable) extends SingleRender {
  def expression = "LEFT OUTER JOIN %s"
}


case class RightJoinSec(part: ModelTable) extends SingleRender {
  def expression = "RIGHT JOIN %s"
}


case class RightOuterJoinSec(part: ModelTable) extends SingleRender {
  def expression = "RIGHT OUTER JOIN %s"
}


case class FullOuterJoinSec(part: ModelTable) extends SingleRender {
  def expression = "FULL OUTER JOIN %s"
}


case class CrossJoinSec(part: ModelTable) extends SingleRender {
  def expression = "CROSS JOIN %s"
}




















