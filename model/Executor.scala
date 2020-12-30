package kuzminki.model

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import io.rdbc.sapi._
import kuzminki.rdbc._


case class IndexedExecutor(statement: SqlWithParams,
                           cols: Seq[TypeCol[_]],
                           db: DbConn)
                          (implicit ec: ExecutionContext) {

  import kuzminki.model.implicits._

  def asSeq: Future[List[Seq[Any]]] = {
    val indexedCols = cols.zipWithIndex
    db.select(statement).map { rows =>
      rows.map { row =>
        indexedCols.map {
          case (col, index) =>
            col.get(row, index)
        }
      }
    }
  }
  /*
  def asSeqTo[T](implicit custom: Seq[Any] => T): Future[List[T]] = {
    db.select(statement).map { rows =>
      rows.map { row =>
        custom(
          cols.map(col => col.get(row))
        )
      }
    }
  }
  
  def asMap: Future[List[Map[String, Any]]] = {
    db.select(statement).map { rows =>
      rows.map { row =>
        cols.map(col => (col.name, col.get(row))).toMap
      }
    }
  }

  def asMapTo[T](implicit custom: Map[String, Any] => T): Future[List[T]] = {
    db.select(statement).map { rows =>
      rows.map { row =>
        custom(
          cols.map(col => (col.name, col.get(row))).toMap
        )
      }
    }
  }
  */
  def asRow: Future[List[Row]] = {
    db.select(statement)
  }

  def asRowTo[T](implicit custom: Row => T): Future[List[T]] = {
    db.select(statement).map { rows =>
      rows.map { row =>
        custom(row)
      }
    }
  }
}


case class TypedExecutor[R](statement: SqlWithParams,
                            transformer: TypedTransformer[R],
                            db: DbConn)
                           (implicit ec: ExecutionContext) {

  def list: Future[List[R]] = {
    db.select(statement).map { rows =>
      rows.map { row =>
        transformer.transform(row)
      }
    }
  }

  def headOpt: Future[Option[R]] = {
    list.map(_.headOption)
  }

  def as[T](implicit custom: R => T): Future[List[T]] = {
    db.select(statement).map { rows =>
      rows.map { row =>
        custom(
          transformer.transform(row)
        )
      }
    }
  }
}


case class OperationExecutor[R](statement: SqlWithParams,
                                db: DbConn)
                               (implicit ec: ExecutionContext) {

  def forUnit: Future[Unit] = db.exec(statement)

  def forNum: Future[Long] = db.execNum(statement)
}


case class CountExecutor[R](statement: SqlWithParams,
                            db: DbConn)
                           (implicit ec: ExecutionContext) {

  def forNum: Future[Int] = db.count(statement)
}













