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

import io.rdbc.sapi.SqlWithParams


trait InsertList[P] {

  protected val template: String
  protected val paramConv: ParamConv[P]
  protected def tansformParams(params: P): Vector[Any]

  private def extend(template: String, rowNum: Int, argNum: Int) = {
    val single = "(%s)".format(Seq.fill(argNum)("?").mkString(", "))
    val multiple = Seq.fill(rowNum)(single).mkString(", ")
    template.replace(single, multiple)
  }

  protected def listStatement(list: List[P]) = {
    list.map(tansformParams) match {
      case Nil =>
        throw KuzminkiException("insert list cannot be empty")
      case head :: Nil =>
        SqlWithParams(template, head)
      case arguments =>
        SqlWithParams(
          extend(template, arguments.size, arguments.head.size),
          arguments.flatten.toVector
        )
    }
  }
}