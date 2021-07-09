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

package kuzminki.operation

import akka.stream.scaladsl.Source
import io.rdbc.sapi.SqlWithParams
import kuzminki.rdbc.Driver
import kuzminki.shape.ParamConv


class StoredUpdate[P1, P2](
      template: String,
      changes: ParamConv[P1],
      filters: ParamConv[P2],
      db: Driver) {

  private def transform(params: Tuple2[P1, P2]) = {
    changes.fromShape(params._1) ++ filters.fromShape(params._2)
  }

  private def statement(params: Tuple2[P1, P2]) = {
    SqlWithParams(
      template,
      transform(params)
    )
  }

  def run(changeArgs: P1, filterArgs: P2) = {
    db.exec(
      statement(
        (changeArgs, filterArgs)
      )
    )
  }

  def runNum(changeArgs: P1, filterArgs: P2) = {
    db.execNum(
      statement(
        (changeArgs, filterArgs)
      )
    )
  }

  def fromSource[T](source: Source[Tuple2[P1, P2], T]) = {
    db.fromSource(
      template,
      source.map(transform)
    )
  }

  def streamList(params: List[Tuple2[P1, P2]]) = fromSource(Source(params))

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}











