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


trait Assign extends Renderable {
  val col: ModelCol
  def format(name: String): String
  def render(prefix: Prefix) = format(col.render(prefix))
}

case class SetValue(col: ModelCol, value: Any) extends Assign {
  def format(name: String) = s"$name = ?"
  def args = Seq(value)
}

case class SetToNull(col: ModelCol) extends Assign {

  if (col.hasNull == false) {
    throw KuzminkiException(s"Column [${col.name} does not have null")
  }
  
  def format(name: String) = s"$name = NULL"
  def args = Seq.empty[Any]
}

case class Increment(col: ModelCol, value: Any) extends Assign {
  def format(name: String) = s"$name = $name + ?"
  def args = Seq(value)
}

case class Decrement(col: ModelCol, value: Any) extends Assign {
  def format(name: String) = s"$name = $name - ?"
  def args = Seq(value)
}




