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


object Min {
  def numeric(col: NumericCol) = MinNumeric(col)
  def float(col: FloatCol) = MinFloat(col)
  def double(col: DoubleCol) = MinDouble(col)
  def int(col: IntCol) = MinInt(col)
  def instant(col: InstantCol) = MinInstant(col)
}


case class MinNumeric(underlying: AnyCol) extends NumericFunctionSingle
                                             with Aggregation {
  val template = "min(%s)"
  def asString = Cast.asString(this)
  def round = Round.numeric(this)
  def round(prec: Int) = Round.numeric(this, prec)
}

case class MinInt(underlying: AnyCol) extends IntFunctionSingle
                                         with Aggregation {
  val template = "min(%s)"
  def asString = Cast.asString(this)
}

case class MinFloat(underlying: AnyCol) extends FloatFunctionSingle
                                           with Aggregation {
  val template = "min(%s)"
  def asString = Cast.asString(this)
  def round = Round.float(this)
}

case class MinDouble(underlying: AnyCol) extends DoubleFunctionSingle
                                            with Aggregation {
  val template = "min(%s)"
  def asString = Cast.asString(this)
  def round = Round.double(this)
}

case class MinInstant(underlying: AnyCol) extends InstantFunctionSingle
                                             with Aggregation {
  val template = "min(%s)"
}




































