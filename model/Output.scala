package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._
import kuzminki.rdbc._
import kuzminki.model.select._


case class SeqOutput(cols: Seq[TypeCol[_]], conn: Connection) {

  def executor(query: Query) = SeqExecutor(query, cols, conn.db)(conn.ec)
}


case class TupleOutput[R](transformer: TupleTransformer[R], conn: Connection) {

  def executor(query: Query) = TupleExecutor(query, transformer, conn.db)(conn.ec)
}