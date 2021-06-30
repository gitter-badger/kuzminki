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

import akka.stream.scaladsl._
import akka.{NotUsed, Done}
import io.rdbc.sapi.SqlWithParams


class StoredUpdate[P1, P2](
      template: String,
      changeConv: ParamConv[P1],
      filterConv: ParamConv[P2],
      db: Conn) {

  protected def render = template

  private def transform(params: Tuple2[P1, P2]) = {
    changeConv.fromShape(params._1) ++ filterConv.fromShape(params._2)
  }

  private def statement(params: Tuple2[P1, P2]) = {
    SqlWithParams(
      template,
      transform(params)
    )
  }

  def run(changeParams: P1, filterParams: P2) = {
    db.exec(
      statement(
        (changeParams, filterParams)
      )
    )
  }

  def runNum(changeParams: P1, filterParams: P2) = {
    db.execNum(
      statement(
        (changeParams, filterParams)
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











