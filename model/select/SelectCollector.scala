package kuzminki.model

import akka.Done
import io.rdbc.sapi.SqlWithParams


case class SelectCollector[R](
      db: Conn,
      prefix: Prefix,
      rowShape: RowShape[R],
      sections: Array[Section]
    ) {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cache = new StoredSelect(db, statement, rowShape.conv)

  def cacheWhere[P](paramShape: ParamShape[P]) = {
    
    val modifiedSections = sections.map {
      
      case WhereBlankSec =>
        WhereCacheSec(paramShape.cols)
      
      case WhereSec(conds) =>
        WhereMixedSec(conds, paramShape.cols)
      
      case section: Section =>
        section
    }

    val template = modifiedSections.map(_.render(prefix)).mkString(" ")
    val cacheArgs = modifiedSections.map(_.args).flatten.toVector

    val (firstArgs, lastArgs) = cacheArgs.splitAt(cacheArgs.indexOf(Done)) match {
      case (first, last) =>
        (first, last.tail) 
    }

    new StoredSelectWhere(db, template, firstArgs, lastArgs, paramShape.conv, rowShape.conv)
  }

  val notBlank: Section => Boolean = {
    case WhereBlankSec => false
    case _ => true
  }

  def render = sections.filter(notBlank).map(_.render(prefix)).mkString(" ")

  def args = sections.toSeq.map(_.args).flatten.toVector

  def statement = SqlWithParams(render, args)
}























