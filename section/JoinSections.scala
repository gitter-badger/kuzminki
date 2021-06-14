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


case class OnSec(leftCol: AnyCol, rightCol: AnyCol) extends Section with NoArgs {
  def expression = "ON %s = %s"
  def render(prefix: Prefix) = expression.format(leftCol.render(prefix), rightCol.render(prefix))
}

case class InnerJoinSec(part: ModelTable) extends SingleRender {
  def expression = "INNER JOIN %s"
}


case class LeftJoinSec(part: ModelTable) extends SingleRender {
  def expression = "LEFT JOIN %s"
}


case class LeftOuterJoinSec(part: ModelTable) extends SingleRender {
  def expression = "LEFT OUTER JOIN %s"
}


case class RightJoinSec(part: ModelTable) extends SingleRender {
  def expression = "RIGHT JOIN %s"
}


case class RightOuterJoinSec(part: ModelTable) extends SingleRender {
  def expression = "RIGHT OUTER JOIN %s"
}


case class FullOuterJoinSec(part: ModelTable) extends SingleRender {
  def expression = "FULL OUTER JOIN %s"
}


case class CrossJoinSec(part: ModelTable) extends SingleRender {
  def expression = "CROSS JOIN %s"
}




















