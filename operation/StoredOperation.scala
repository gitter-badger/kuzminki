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


class StoredOperation[S](
      template: String,
      args: Vector[Any],
      conv: ParamConv[S],
      db: Conn) {

  protected def render = template

  private def transform(data: S) = {
    args ++ conv.fromShape(data)
  }

  private def statement(data: S) = {
    SqlWithParams(
      template,
      transform(data)
    )
  }

  def run(data: S) = {
    db.exec(statement(data))
  }

  def runNum(data: S) = {
    db.execNum(statement(data))
  }

  def fromSource[T](source: Source[S, T]) = {
    db.fromSource(
      template,
      source.map(transform)
    )
  }

  def streamList(data: List[S]) = fromSource(Source(data))

  def sql(handler: String => Unit) = {
    handler(template)
    this
  }
}