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

package kuzminki.filter

import kuzminki.column.TypeCol
import kuzminki.conv.ValConv
import kuzminki.render.{Renderable, Prefix}


trait CacheFilter[T] extends CachePart[T] {
  val col: TypeCol[T]
  def template: String
  def conv = col.conv
  def render(prefix: Prefix) = template.format(col.render(prefix))
  def args = col.args
}


case class CacheEq[T](col: TypeCol[T]) extends CacheFilter[T] {
  def template = s"%s = ?"
}

case class CacheNot[T](col: TypeCol[T]) extends CacheFilter[T] {
  def template = s"%s != ?"
}

case class CacheGt[T](col: TypeCol[T]) extends CacheFilter[T] {
  def template = s"%s > ?"
}

case class CacheLt[T](col: TypeCol[T]) extends CacheFilter[T] {
  def template = s"%s < ?"
}
















