package kuzminki.model.insert

import io.rdbc.sapi.SqlWithParams
import kuzminki.model._


class StoredInsertReturning[S, R](
      protected val template: String,
      protected val shape: InsertShape[S],
                    transformer: TypedTransformer[R],
                    db: Conn) extends ListInsert[S]
                                 with Printing {

  protected def render = template

  def run(data: S) = {
    db.selectHead(statement(data)) { row =>
      transformer.transform(row)
    }  
  }

  def runAs[T](data: S)(implicit custom: R => T) = {
    db.selectHead(statement(data)) { row =>
      custom(
        transformer.transform(row)
      )
    }  
  }

  def list(list: List[S]) = {
    db.select(listStatement(list)) { row =>
      transformer.transform(row)
    }  
  }


  def listAs[T](list: List[S])(implicit custom: R => T) = {
    db.select(listStatement(list)) { row =>
      custom(
        transformer.transform(row)
      )
    }  
  }
}