package kuzminki.model

import io.rdbc.sapi.SqlWithParams


class StoredInsertReturning[P, R](
      protected val template: String,
      protected val paramConv: ParamConv[P],
                    rowConv: RowConv[R],
                    db: Conn
    ) extends InsertStatement[P]
         with InsertParams[P]
         with InsertList[P]
         with InsertPrinting {

  def run(params: P) = {
    db.selectHead(statement(params)) { row =>
      rowConv.fromRow(row)
    }  
  }

  def runAs[T](params: P)(implicit custom: R => T) = {
    db.selectHead(statement(params)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def list(paramsList: List[P]) = {
    db.select(listStatement(paramsList)) { row =>
      rowConv.fromRow(row)
    }  
  }


  def listAs[T](paramsList: List[P])(implicit custom: R => T) = {
    db.select(listStatement(paramsList)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }
}