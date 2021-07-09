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

package kuzminki.insert

import akka.stream.scaladsl.Source
import io.rdbc.sapi.SqlWithParams
import kuzminki.rdbc.Driver
import kuzminki.shape.ParamConv


class StoredInsert[P](
      protected val template: String,
      protected val paramConv: ParamConv[P],
                    db: Driver
    ) extends InsertStatement[P]
         with InsertParams[P]
         with InsertList[P] {

  def run(params: P) = {
    db.exec(statement(params))
  }

  def runNum(params: P) = {
    db.execNum(statement(params))
  }

  def runList(paramsList: List[P]) = {
    db.exec(listStatement(paramsList))
  }

  def runListNum(paramsList: List[P]) = {
    db.execNum(listStatement(paramsList))
  }

  def fromSource[T](source: Source[P, T]) = {
    db.fromSource(
      template,
      source.map(tansformParams)
    )
  }

  def streamList(paramsList: List[P]) = fromSource(Source(paramsList))

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}







