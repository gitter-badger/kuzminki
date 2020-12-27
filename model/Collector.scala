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
  
  def indexed[M <: Model](model: M,
                          cols: Seq[TypeCol[_]],
                          conn: Connection): IndexedCollector[M] = {
    
    IndexedCollector(
      model,
      Array(
        SelectSec(cols),
        FromSec(ModelTable(model))
      ),
      IndexedOutput(cols, conn)
    )
  }

  def typed[M <: Model, R](model: M,
                           transformer: TypedTransformer[R], 
                           conn: Connection): TypedCollector[M, R] = {
    
    TypedCollector(
      model,
      Array(
        SelectSec(transformer.toSeq),
        FromSec(ModelTable(model))
      ),
      TypedOutput(transformer, conn)
    )
  }

  def indexedJoin[A <: Model, B <: Model](join: Join[A, B],
                                          cols: Seq[TypeCol[_]], 
                                          conn: Connection): IndexedJoinCollector[A, B] = {
    
    IndexedJoinCollector(
      join,
      Array(
        SelectSec(cols),
        FromSec(ModelTable(join.a))
      ),
      IndexedOutput(cols, conn)
    )
  }

  def typedJoin[A <: Model, B <: Model, R](join: Join[A, B], 
                                           transformer: TypedTransformer[R], 
                                           conn: Connection): TypedJoinCollector[A, B, R] = {
    
    TypedJoinCollector(
      join,
      Array(
        SelectSec(transformer.toSeq),
        FromSec(ModelTable(join.a))
      ),
      TypedOutput(transformer, conn)
    )
  }

  def forTypedReturning[M <: Model, R](collector: OperationCollector[M],
                                       transformer: TypedTransformer[R]): TypedCollector[M, R] = {
    
    TypedCollector(
      collector.model,
      collector.sections :+ ReturningSec(transformer.toSeq),
      TypedOutput(transformer, collector.conn)
    )
  }
}

trait ResultMethods {
  val sections: Array[Section]
  def render = sections.filter(_.isUsed).map(_.render).mkString(" ")
  def args = sections.toSeq.filter(_.isUsed).map(_.args).flatten
  def statement = SqlWithParams(render, args.toVector)
}


case class IndexedCollector[M <: Model](model: M,
                                        sections: Array[Section],
                                        output: IndexedOutput) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def executor = output.executor(statement)
}

case class IndexedJoinCollector[A <: Model, B <: Model](join: Join[A, B],
                                                        sections: Array[Section],
                                                        output: IndexedOutput) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def executor = output.executor(statement)
}


case class TypedCollector[M <: Model, R](model: M,
                                         sections: Array[Section],
                                         output: TypedOutput[R]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def executor = output.executor(statement)

  def nested = new NestedSelect(sections, output)
}


case class TypedJoinCollector[A <: Model, B <: Model, R](join: Join[A, B],
                                                         sections: Array[Section],
                                                         output: TypedOutput[R]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)
  
  def executor = output.executor(statement)
}


case class OperationCollector[M <: Model](model: M,
                                          conn: Connection,
                                          sections: Array[Section]) extends ResultMethods {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def executor = OperationOutput(conn).executor(statement)
}




