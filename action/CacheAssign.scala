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


trait CacheChange[T] extends CachePart[T] {
  val col: TypeCol[T]
  def template = ""
  def format(name: String): String
  def conv = col.conv
  def render(prefix: Prefix) = format(col.render(prefix))
  def args = Seq.empty[Any]
}


case class CacheSet[T](col: TypeCol[T]) extends CacheChange[T] {
  def format(name: String) = s"$name = ?"
}

case class CacheIncrement[T](col: TypeCol[T]) extends CacheChange[T] {
  def format(name: String) = s"$name = $name + ?"
}

case class CacheDecrement[T](col: TypeCol[T]) extends CacheChange[T] {
  def format(name: String) = s"$name = $name - ?"
}








