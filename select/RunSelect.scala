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


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done


class RunSelect[M, R](
      model: M,
      coll: SelectCollector[R]
    ) {

  def cache = coll.cache
  
  def run() = cache.run()

  def runAs[T](implicit custom: R => T) = cache.runAs(custom)

  def headOpt() = cache.headOpt()

  def headOptAs[T](implicit custom: R => T) = cache.headOptAs(custom)

  def head() = cache.head()

  def headAs[T](implicit custom: R => T) = cache.headOptAs(custom)

  def runCount() = cache.runCount()

  def source = cache.source

  // cache where

  def cacheWhere1[P](pick: M => TypeCol[P]) = {
    coll.cacheWhere(new ParamShapeSingle(pick(model)))
  }
  
  def cacheWhere2[P1, P2](pick: M => Tuple2[TypeCol[P1], TypeCol[P2]]) = {
    coll.cacheWhere(new ParamShape2(pick(model)))
  }

  def cacheWhere3[P1, P2, P3](pick: M => Tuple3[TypeCol[P1], TypeCol[P2], TypeCol[P3]]) = {
    coll.cacheWhere(new ParamShape3(pick(model)))
  }

  def cacheWhere4[P1, P2, P3, P4](pick: M => Tuple4[TypeCol[P1], TypeCol[P2], TypeCol[P3], TypeCol[P4]]) = {
    coll.cacheWhere(new ParamShape4(pick(model)))
  }

  def cacheWhere5[P1, P2, P3, P4, P5](pick: M => Tuple5[TypeCol[P1], TypeCol[P2], TypeCol[P3], TypeCol[P4], TypeCol[P5]]) = {
    coll.cacheWhere(new ParamShape5(pick(model)))
  }

  // cache having

  def cacheHaving1[P](pick: M => TypeCol[P]) = {
    coll.cacheHaving(new ParamShapeSingle(pick(model)))
  }
  
  def cacheHaving2[P1, P2](pick: M => Tuple2[TypeCol[P1], TypeCol[P2]]) = {
    coll.cacheHaving(new ParamShape2(pick(model)))
  }

  def cacheHaving3[P1, P2, P3](pick: M => Tuple3[TypeCol[P1], TypeCol[P2], TypeCol[P3]]) = {
    coll.cacheHaving(new ParamShape3(pick(model)))
  }

  def cacheHaving4[P1, P2, P3, P4](pick: M => Tuple4[TypeCol[P1], TypeCol[P2], TypeCol[P3], TypeCol[P4]]) = {
    coll.cacheHaving(new ParamShape4(pick(model)))
  }

  def cacheHaving5[P1, P2, P3, P4, P5](pick: M => Tuple5[TypeCol[P1], TypeCol[P2], TypeCol[P3], TypeCol[P4], TypeCol[P5]]) = {
    coll.cacheHaving(new ParamShape5(pick(model)))
  }

  // renderable

  def render(prefix: Prefix): String = coll.render
  
  def args = coll.args

  def sql(handler: String => Unit): RunSelect[M, R] = {
    handler(render(coll.prefix))
    this
  }
}

























