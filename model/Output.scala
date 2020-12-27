package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._
import kuzminki.rdbc._


case class IndexedOutput(cols: Seq[TypeCol[_]], conn: Connection) {

  def executor(statement: SqlWithParams) = IndexedExecutor(statement, cols, conn.db)(conn.ec)
}


case class TypedOutput[R](transformer: TypedTransformer[R], conn: Connection) {

  def executor(statement: SqlWithParams) = TypedExecutor(statement, transformer, conn.db)(conn.ec)
}


case class OperationOutput(conn: Connection) {

  def executor(statement: SqlWithParams) = OperationExecutor(statement, conn.db)(conn.ec)
}