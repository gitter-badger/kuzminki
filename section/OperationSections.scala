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


case class ReturningSec(parts: Seq[AnyCol]) extends MultiRender {
  def expression = "RETURNING %s"
  def glue = ", "
}

case class CountFromSec(part: ModelTable) extends SingleRender {
  def expression = "SELECT count(*) FROM %s"
}

case class DeleteFromSec(part: ModelTable) extends SingleRender {
  def expression = "DELETE FROM %s"
}

case class UpdateSec(part: ModelTable) extends SingleRender {
  def expression = "UPDATE %s"
}

case class UpdateSetSec(parts: Seq[Assign]) extends MultiRender {
  def expression = "SET %s"
  def glue = ", "
}

// cache

case class UpdateCacheSetSec(parts: Seq[Renderable]) extends Section with NoArgs {
  def expression = "SET %s"
  def render(prefix: Prefix) = expression.format(parts.map(_.render(prefix)).mkString(", "))
}

case class UpdateCacheWhereSec(parts: Seq[Renderable]) extends Section with NoArgs {
  def expression = "WHERE %s"
  def render(prefix: Prefix) = expression.format(parts.map(_.render(prefix)).mkString(", "))
}




























