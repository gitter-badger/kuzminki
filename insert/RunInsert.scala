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


class RunInsert[M <: Model, P](
      protected val model: M,
      protected val coll: InsertCollector[P]
    ) extends PickInsertReturning[M, P]
         with WhereNotExists[M, P]
         with OnConflict[M, P]
         with InsertSubquery[M, P] {

  def cache = coll.add(InsertBlankValuesSec(coll.paramShape.size)).cacheInsert

  def run(params: P) = cache.run(params)

  def runNum(params: P) = cache.runNum(params)

  def runList(paramsList: List[P]) = cache.runList(paramsList)

  def runListNum(paramsList: List[P]) = cache.runListNum(paramsList)

  def fromSource[T](source: Source[P, T]) = cache.fromSource(source)

  def streamList(paramsList: List[P]) = cache.streamList(paramsList)

  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}


















