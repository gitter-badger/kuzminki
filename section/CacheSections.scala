package kuzminki.model

import akka.Done


object WhereBlankSec extends TextOnly {
  def expression = ""
}

case class WhereCacheSec(cols: Seq[AnyCol]) extends CacheCondition {
  def expression = "WHERE %s"
}

case class WhereMixedSec(conds: Seq[Renderable], cols: Seq[AnyCol]) extends MixedCondition {
  def expression = "WHERE %s"
}

object HavingBlankSec extends TextOnly {
  def expression = ""
}

case class HavingCacheSec(cols: Seq[AnyCol]) extends CacheCondition {
  def expression = "HAVING %s"
}

case class HavingMixedSec(conds: Seq[Renderable], cols: Seq[AnyCol]) extends MixedCondition {
  def expression = "HAVING %s"
}






