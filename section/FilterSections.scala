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

package kuzminki.section

import kuzminki.column.AnyCol
import kuzminki.render.{Renderable, Prefix, NoArgs}

trait FilterSections {

  case class WhereSec(parts: Seq[Renderable]) extends NotEmpty(parts) with MultiPartRender {
    def error = "WHERE cannot be empty"
    val expression = "WHERE %s"
    val glue = " AND "
  }

  object WhereBlankSec extends Section with NoRender with NoArgs {
    val expression = ""
  }

  case class HavingSec(parts: Seq[Renderable]) extends NotEmpty(parts) with MultiPartRender {
    def error = "HAVING cannot be empty"
    val expression = "HAVING %s"
    val glue = " AND "
  }

  object HavingBlankSec extends Section with NoRender with NoArgs {
    val expression = ""
  }
}


