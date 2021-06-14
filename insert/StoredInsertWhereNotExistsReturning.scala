/*
* Copyright 2021 Kári Magnússon
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package kuzminki.model

import io.rdbc.sapi.SqlWithParams


class StoredInsertWhereNotExistsReturning[P, R](
      protected val template: String,
      protected val paramConv: ParamConv[P],
      protected val reuse: Reuse,
                    rowConv: RowConv[R],
                    db: Conn
    ) extends InsertStatement[P]
         with InsertParamsReuse[P]
         with InsertPrinting {

  def run(params: P) = {
    db.selectHeadOption(statement(params)) { row =>
      rowConv.fromRow(row)
    }  
  }

  def runAs[T](params: P)(implicit custom: R => T) = {
    db.selectHeadOption(statement(params)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}