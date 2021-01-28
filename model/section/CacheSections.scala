package kuzminki.model

import akka.Done


object WhereBlankSec extends TextOnly {
  def expression = ""
}

case class SelectSec(parts: Seq[AnyCol]) extends MultiRender {
  def expression = "SELECT %s"
  def glue = ", "
}

case class WhereCacheSec(cols: Seq[AnyCol]) extends Section {

  def expression = "WHERE %s"
  
  def render(prefix: Prefix) = {
    expression.format(
      cols.map(CacheCond(_)).map(_.render(prefix)).mkString(" AND ")
    )
  }
  
  def args = Seq(Done)
}

case class WhereMixedSec(conds: Seq[Renderable], cols: Seq[AnyCol]) extends Section {
  
  def expression = "WHERE %s"
  
  def render(prefix: Prefix) = {
    val both = conds ++ cols.map(CacheCond(_))
    expression.format(
      both.map(_.render(prefix)).mkString(" AND ")
    )
  }
  
  def args = conds.map(_.args).flatten ++ Seq(Done)
}