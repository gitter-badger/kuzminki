package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._
import kuzminki.rdbc._
import kuzminki.model.select._


case class Connection(db: RdbcConn, ec: ExecutionContext)


case class SeqExecutor(cols: Seq[TypeCol[_]], db: RdbcConn)(implicit ec: ExecutionContext) {

  import kuzminki.model.implicits._

  def asSeq(query: Query): Future[List[Seq[Any]]] = {
    db.select(query).map { rows =>
      rows.map { row =>
        cols.map(col => col.get(row))
      }
    }
  }

  def asMap(query: Query): Future[List[Map[String, Any]]] = {
    db.select(query).map { rows =>
      rows.map { row =>
        cols.map(col => (col.name, col.get(row))).toMap
      }
    }
  }
}


case class TupleExecutor[R](transformer: TupleTransformer[R], db: RdbcConn)(implicit ec: ExecutionContext) {

  def asTuple(query: Query): Future[List[R]] = {
    db.select(query).map { rows =>
      rows.map { row =>
        transformer.transform(row)
      }
    }
  }
}