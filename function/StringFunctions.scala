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



object StringFn {
  def concat(cols: TypeCol[_]*) = StringFnConcat(cols)
}


case class StringFnConcat(cols: Seq[TypeCol[_]]) extends StringFunction {
  def template = "concat(%s)"
  def render(prefix: Prefix) = {
    template.format(
      cols.map(_.render(prefix)).mkString(", ")
    )
  }
  def args = cols.map(_.args).flatten
}