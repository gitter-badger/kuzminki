package kuzminki.model

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import com.github.vertical_blank.sqlformatter.scala.SqlFormatter
import kuzminki.model.select._

// collector

case class Query(template: String, args: Seq[Any])


// SeqCollector

object Collector {
  
  def standard[M <: Model](model: M, cols: Seq[TypeCol[_]], conn: Connection): SeqCollector[M] = {
    SeqCollector(
      model,
      Array(
        SelectSec(cols),
        FromSec(ModelTable(model))
      ),
      SeqOutput(cols, conn)
    )
  }

  def tuple[M <: Model, R](model: M, transformer: TupleTransformer[R], conn: Connection): TupleCollector[M, R] = {
    TupleCollector(
      model,
      Array(
        SelectSec(transformer.toSeq),
        FromSec(ModelTable(model))
      ),
      TupleOutput(transformer, conn)
    )
  }

  def standardJoin[A <: Model, B <: Model](join: Join[A, B], cols: Seq[TypeCol[_]], conn: Connection): SeqJoinCollector[A, B] = {
    SeqJoinCollector(
      join,
      Array(
        SelectSec(cols),
        FromSec(ModelTable(join.a))
      ),
      SeqOutput(cols, conn)
    )
  }

  def tupleJoin[A <: Model, B <: Model, R](join: Join[A, B], transformer: TupleTransformer[R], conn: Connection): TupleJoinCollector[A, B, R] = {
    TupleJoinCollector(
      join,
      Array(
        SelectSec(transformer.toSeq),
        FromSec(ModelTable(join.a))
      ),
      TupleOutput(transformer, conn)
    )
  }
}

trait ResultMethods {
  val sections: Array[Section]
  def render = sections.map(_.render).mkString(" ")
  def args = sections.toSeq.map(_.args).flatten
  def query = Query(render, args)
}

case class SeqCollector[M <: Model](model: M,
                               sections: Array[Section],
                               output: SeqOutput) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = output.executor(query)
}


case class TupleCollector[M <: Model, R](model: M,
                                         sections: Array[Section],
                                         output: TupleOutput[R]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = output.executor(query)
}


case class SeqJoinCollector[A <: Model, B <: Model](join: Join[A, B],
                                               sections: Array[Section],
                                               output: SeqOutput) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = output.executor(query)
}


case class TupleJoinCollector[A <: Model, B <: Model, R](join: Join[A, B],
                                                         sections: Array[Section],
                                                         output: TupleOutput[R]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = output.executor(query)
}



/*
case class Collector[T <: Model](model: T, sections: Array[Section], cols: Seq[TypeCol[_]], exec: Executor) extends ModelRender {

  def add(section: Section) = this.copy(sections = sections)

  def where(conds: Seq[ModelFilter]) = add(WhereAllSec(conds))

  def orderBy(sorting: Seq[ModelSorting]) = add(OrderBySec(sorting))

  def offset(num: Int) = add(OffsetSec(num))

  def limit(num: Int) = add(LimitSec(num))

  def render = sections.map(_.render).mkString(" ")

  def args = sections.toSeq.map(_.args).flatten

  def pretty = SqlFormatter.format(render)

  def tup = (render, args)

  def results = new Results(render, args, cols, exec)(exec.ec)
}
*/



