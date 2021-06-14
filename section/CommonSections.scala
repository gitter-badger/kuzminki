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


case class SelectSec(parts: Seq[AnyCol]) extends NotEmpty(parts) with MultiRender {
  def error = "no columns selected"
  def expression = "SELECT %s"
  def glue = ", "
}

case class FromSec(part: ModelTable) extends SingleRender {
  def expression = "FROM %s"
}

case class WhereSec(parts: Seq[Renderable]) extends NotEmpty(parts) with MultiRender {
  def error = "WHERE cannot be empty"
  def expression = "WHERE %s"
  def glue = " AND "
}

case class GroupBySec(parts: Seq[AnyCol]) extends NotEmpty(parts) with MultiRender {
  def error = "WHERE BY cannot be empty"
  def expression = "GROUP BY %s"
  def glue = ", "
}

case class HavingSec(parts: Seq[Renderable]) extends NotEmpty(parts) with MultiRender {
  def error = "HAVING cannot be empty"
  def expression = "HAVING %s"
  def glue = " AND "
}

case class OrderBySec(parts: Seq[Sorting]) extends NotEmpty(parts) with MultiRender {
  def error = "ORDER BY cannot be empty"
  def expression = "ORDER BY %s"
  def glue = ", "
}

case class OffsetSec(arg: Int) extends SingleArg {
  def expression = "OFFSET ?"
}

case class LimitSec(arg: Int) extends SingleArg {
  def expression = "LIMIT ?"
}