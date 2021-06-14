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

import akka.Done


object WhereBlankSec extends TextOnly {
  def expression = ""
}

case class WhereCacheSec(cols: Seq[AnyCol]) extends CacheCondition {
  def expression = "WHERE %s"
}

case class WhereMixedSec(conds: Seq[Renderable], cols: Seq[AnyCol]) extends MixedCondition {
  def expression = "WHERE %s"
}

object HavingBlankSec extends TextOnly {
  def expression = ""
}

case class HavingCacheSec(cols: Seq[AnyCol]) extends CacheCondition {
  def expression = "HAVING %s"
}

case class HavingMixedSec(conds: Seq[Renderable], cols: Seq[AnyCol]) extends MixedCondition {
  def expression = "HAVING %s"
}






