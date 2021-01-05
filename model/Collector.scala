package kuzminki.model

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import com.github.vertical_blank.sqlformatter.scala.SqlFormatter
import io.rdbc.sapi.SqlWithParams
import kuzminki.model.select._


trait ResultMethods {
  val sections: Array[Section]
  def render = sections.map(_.render).mkString(" ")
  def args = sections.toSeq.map(_.args).flatten
  def statement = SqlWithParams(render, args.toVector)
}


case class Collector(db: Conn, sections: Array[Section]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def returning[R](transformer: TypedTransformer[R]) = {
    TypedCollector(db, transformer, sections :+ ReturningSec(transformer.toSeq))
  }
}


case class TypedCollector[R](db: Conn,
                             transformer: TypedTransformer[R],
                             sections: Array[Section]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)
}

















