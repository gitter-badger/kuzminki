package kuzminki.model

import io.rdbc.sapi.SqlWithParams


trait CollectOperation extends Collectable {
  val sections: Array[Section]
  val prefix = Prefix.forModel

  val notBlank: Section => Boolean = {
    case WhereBlankSec => false
    case HavingBlankSec => false
    case _ => true
  }

  def render = sections.filter(notBlank).map(_.render(prefix)).mkString(" ")
  
  def args = sections.toSeq.map(_.args).flatten.toVector
  
  def statement = SqlWithParams(render, args)
}

























