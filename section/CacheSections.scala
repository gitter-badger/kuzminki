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


sealed trait CacheArgs
object CacheCondArgs extends CacheArgs
object CacheOffsetArgs extends CacheArgs


object WhereBlankSec extends Section with NoRender with NoArgs {
  def expression = ""
}

case class WhereCacheSec(cacheConds: Seq[Renderable]) extends CacheCondition {
  def expression = "WHERE %s"
}

case class WhereMixedSec(conds: Seq[Renderable], cacheConds: Seq[Renderable]) extends MixedCondition {
  def expression = "WHERE %s"
}

object HavingBlankSec extends Section with NoRender with NoArgs {
  def expression = ""
}

case class HavingCacheSec(cacheConds: Seq[Renderable]) extends CacheCondition {
  def expression = "HAVING %s"
}

case class HavingMixedSec(conds: Seq[Renderable], cacheConds: Seq[Renderable]) extends MixedCondition {
  def expression = "HAVING %s"
}

object OffsetCacheSec extends Section with NoRender {
  def expression = "OFFSET ?"
  def args = Seq(CacheOffsetArgs)
}





