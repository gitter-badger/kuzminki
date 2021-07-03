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


object Sum {
  def numeric(col: NumericCol) = SumNumeric(col)
  def float(col: FloatCol) = SumFloat(col)
  def double(col: DoubleCol) = SumDouble(col)
  def short(col: ShortCol) = SumLong(col)
  def int(col: IntCol) = SumLong(col)
  def long(col: LongCol) = SumNumeric(col)
}


case class SumNumeric(underlying: AnyCol) extends NumericFunctionSingle
                                             with Aggregation {
  val template = "sum(%s)"
  def asString = Cast.asString(this)
  def round = Round.numeric(this)
  def round(prec: Int) = Round.numeric(this, prec)
}

case class SumLong(underlying: AnyCol) extends LongFunctionSingle
                                          with Aggregation {
  val template = "sum(%s)"
  def asString = Cast.asString(this)
}

case class SumFloat(underlying: AnyCol) extends FloatFunctionSingle
                                           with Aggregation {
  val template = "sum(%s)"
  def asString = Cast.asString(this)
  def round = Round.float(this)
}

case class SumDouble(underlying: AnyCol) extends DoubleFunctionSingle
                                            with Aggregation {
  val template = "sum(%s)"
  def asString = Cast.asString(this)
  def round = Round.double(this)
}





















