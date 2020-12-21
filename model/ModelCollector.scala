package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import com.github.vertical_blank.sqlformatter.scala.SqlFormatter
import kuzminki.model.select._

// collector

case class Query(template: String, args: Seq[Any])


object SeqCollector {
  
  def create[M <: Model](model: M, cols: Seq[TypeCol[_]], conn: Connection): SeqCollector[M] = {
    SeqCollector(
      model,
      Array(
        SelectSec(cols),
        FromSec(ModelTable(model))
      ),
      SeqExecutor(cols, conn.db)(conn.ec)
    )
  }
}


object TupleCollector {
  
  def create[T <: Model, R](model: T, transformer: TupleTransformer[R], conn: Connection) = {
    TupleCollector(
      model,
      Array(
        SelectSec(transformer.toSeq),
        FromSec(ModelTable(model))
      ),
      TupleExecutor(transformer, conn.db)(conn.ec)
    )
  }
}


trait Gather {
  val sections: Array[Section]
  def add[M](section: Section): M
  def where(conds: Seq[ModelFilter]) = add(WhereAllSec(conds))
  def orderBy(sorting: Seq[ModelSorting]) = add(OrderBySec(sorting))
  def offset(num: Int) = add(OffsetSec(num))
  def limit(num: Int) = add(LimitSec(num))
}


trait SelectQuery extends ModelRender {
  val sections: Array[Section]
  def render = sections.map(_.render).mkString(" ")
  def args = sections.toSeq.map(_.args).flatten
  def query = Query(render, args)
}


case class SeqCollector[M <: Model](model: M,
                                    sections: Array[Section],
                                    exec: SeqExecutor) extends SelectQuery {

  def add(section: Section) = this.copy(sections = sections)
  
  def where(conds: Seq[ModelFilter]) = add(WhereAllSec(conds))
  def orderBy(sorting: Seq[ModelSorting]) = add(OrderBySec(sorting))
  def offset(num: Int) = add(OffsetSec(num))
  def limit(num: Int) = add(LimitSec(num))

  def asSeq(): Future[List[Seq[Any]]] = exec.asSeq(query)
  def asMap(): Future[List[Map[String, Any]]] = exec.asMap(query)
}


case class TupleCollector[M <: Model, R](model: M,
                                         sections: Array[Section],
                                         exec: TupleExecutor[R]) extends SelectQuery {

  def add(section: Section) = this.copy(sections = sections)
  
  def where(conds: Seq[ModelFilter]) = add(WhereAllSec(conds))
  def orderBy(sorting: Seq[ModelSorting]) = add(OrderBySec(sorting))
  def offset(num: Int) = add(OffsetSec(num))
  def limit(num: Int) = add(LimitSec(num))

  def asTuple(): Future[List[R]] = exec.asTuple(query)
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



