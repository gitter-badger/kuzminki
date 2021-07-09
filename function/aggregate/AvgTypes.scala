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

package kuzminki.aggregate.avg

import kuzminki.column.AnyCol
import kuzminki.aggregate.Aggregation
import kuzminki.fn.{Cast, Round}
import kuzminki.function.types._


case class AvgNumeric(underlying: AnyCol) extends NumericFunctionSingle
                                             with Aggregation {
  val template = "avg(%s)"
  def asString = Cast.asString(this)
  def round = Round.numeric(this)
  def round(prec: Int) = Round.numeric(this, prec)
}


case class AvgDouble(underlying: AnyCol) extends DoubleFunctionSingle
                                            with Aggregation {
  val template = "avg(%s)"
  def asString = Cast.asString(this)
  def round = Round.double(this)
}






















