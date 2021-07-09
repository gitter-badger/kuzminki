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

package kuzminki.select

import scala.concurrent.Future
import akka.stream.scaladsl.Source
import kuzminki.api.KuzminkiException
import kuzminki.render.Prefix
import kuzminki.column.AnyCol
import kuzminki.aggregate.Aggregation
import kuzminki.section.select._


class RunSelect[M, R](
      model: M,
      coll: SelectCollector[R]
    ) extends SelectCacheMethods(model, coll) {

  def cache = coll.cache
  
  def run() = cache.run()

  def runAs[T](implicit custom: R => T) = cache.runAs(custom)

  def headOpt() = cache.headOpt()

  def headOptAs[T](implicit custom: R => T) = cache.headOptAs(custom)

  def head() = cache.head()

  def headAs[T](implicit custom: R => T) = cache.headOptAs(custom)

  def runCount() = cache.runCount()

  def source = cache.source

  // subquery

  private def firstColumn = {
    coll.sections(0) match {
      case SelectSec(parts) =>
        parts(0)
      case _ =>
        throw KuzminkiException("Subquery is invalid")
    }
  }
  
  def asSubquery = {
    firstColumn match {
      case col: AnyCol =>
      case _ =>
        throw KuzminkiException("Subquery column cannot use modifiers")
    }

    new SelectSubquery(coll)
  }
  
  def asAggregation = {
    firstColumn match {
      case col: Aggregation =>
      case _ =>
        throw KuzminkiException("Subquery column must be an aggregation function")
    }

    new AggregationSubquery(coll)
  }

  // renderable

  def render(prefix: Prefix): String = coll.render
  
  def args = coll.args

  def sql(handler: String => Unit): RunSelect[M, R] = {
    handler(render(coll.prefix) + " - " + coll.args)
    this
  }
}

























