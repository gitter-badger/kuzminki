package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredInsertReturning[S, R](
      protected val template: String,
      protected val inShape: DataShape[S],
                    outShape: RowShape[R],
                    db: Conn
    ) extends ListInsert[S]
         with Printing {

  protected def render = template

  def run(data: S) = {
    db.selectHead(statement(data)) { row =>
      outShape.fromRow(row)
    }  
  }

  def runAs[T](data: S)(implicit custom: R => T) = {
    db.selectHead(statement(data)) { row =>
      custom(
        outShape.fromRow(row)
      )
    }  
  }

  def list(list: List[S]) = {
    db.select(listStatement(list)) { row =>
      outShape.fromRow(row)
    }  
  }


  def listAs[T](list: List[S])(implicit custom: R => T) = {
    db.select(listStatement(list)) { row =>
      custom(
        outShape.fromRow(row)
      )
    }  
  }
}