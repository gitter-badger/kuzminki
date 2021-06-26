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


trait CondShape[P] {
  def cols: Seq[AnyCol]
}


class CondShape2[P1, P2](
      shape: Tuple2[TypeCol[P1], TypeCol[P2]]
    ) extends CondShape[Tuple2[P1, P2]]

  def cols = {
    shape match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }

  def param

class ParamShape2[P1, P2](
      shape: Tuple2[TypeCol[P1], TypeCol[P2]]
    ) extends ParamShape[Tuple2[P1, P2]] {

  def size = 2

  def cols = {
    shape match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }

  def conv = {
    shape match {
      case (col1, col2) =>
        new ParamConv2(col1.conv, col2.conv)
    }
  }
}