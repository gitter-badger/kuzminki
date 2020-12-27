package kuzminki.model

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import com.github.vertical_blank.sqlformatter.scala.SqlFormatter
import io.rdbc.sapi._
import kuzminki.model.select._

// collector

case class Query(template: String, args: Seq[Any])


// SeqCollector

object Collector {
  
  def standard[M <: Model](model: M,
                           cols: Seq[TypeCol[_]],
                           conn: Connection): SeqCollector[M] = {
    
    SeqCollector(
      model,
      Array(
        SelectSec(cols),
        FromSec(ModelTable(model))
      ),
      SeqOutput(cols, conn)
    )
  }

  def tuple[M <: Model, R](model: M,
                           transformer: TupleTransformer[R], 
                           conn: Connection): TupleCollector[M, R] = {
    
    TupleCollector(
      model,
      Array(
        SelectSec(transformer.toSeq),
        FromSec(ModelTable(model))
      ),
      TupleOutput(transformer, conn)
    )
  }

  def standardJoin[A <: Model, B <: Model](join: Join[A, B],
                                           cols: Seq[TypeCol[_]], 
                                           conn: Connection): SeqJoinCollector[A, B] = {
    
    SeqJoinCollector(
      join,
      Array(
        SelectSec(cols),
        FromSec(ModelTable(join.a))
      ),
      SeqOutput(cols, conn)
    )
  }

  def tupleJoin[A <: Model, B <: Model, R](join: Join[A, B], 
                                           transformer: TupleTransformer[R], 
                                           conn: Connection): TupleJoinCollector[A, B, R] = {
    
    TupleJoinCollector(
      join,
      Array(
        SelectSec(transformer.toSeq),
        FromSec(ModelTable(join.a))
      ),
      TupleOutput(transformer, conn)
    )
  }

  def forTypedReturning[M <: Model, R](collector: OperationCollector[M],
                                       transformer: TupleTransformer[R]): TupleCollector[M, R] = {
    
    TupleCollector(
      collector.model,
      collector.sections :+ ReturningSec(transformer.toSeq),
      TupleOutput(transformer, collector.conn)
    )
  }
}

trait ResultMethods {
  val sections: Array[Section]
  def render = sections.filter(_.isUsed).map(_.render).mkString(" ")
  def args = sections.toSeq.filter(_.isUsed).map(_.args).flatten
  def statement = SqlWithParams(render, args.toVector)
}


case class SeqCollector[M <: Model](model: M,
                                    sections: Array[Section],
                                    output: SeqOutput) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = output.executor(statement)
}

case class SeqJoinCollector[A <: Model, B <: Model](join: Join[A, B],
                                                    sections: Array[Section],
                                                    output: SeqOutput) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = output.executor(statement)
}


case class TupleCollector[M <: Model, R](model: M,
                                         sections: Array[Section],
                                         output: TupleOutput[R]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = output.executor(statement)

  def nested = new NestedSelect(sections, output)
}


case class TupleJoinCollector[A <: Model, B <: Model, R](join: Join[A, B],
                                                         sections: Array[Section],
                                                         output: TupleOutput[R]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = output.executor(statement)
}


case class OperationCollector[M <: Model](model: M,
                                          conn: Connection,
                                          sections: Array[Section]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def executor = OperationOutput(conn).executor(statement)
}




