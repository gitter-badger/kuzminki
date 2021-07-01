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


case class AggNumeric(underlying: AnyCol, template: String) extends NumericFunctionSingle
                                                               with Aggregation {
  def asString = Cast.asString(this)
  def round = Round.numeric(this)
  def round(prec: Int) = Round.numeric(this, prec)
}

case class AggInt(underlying: AnyCol, template: String) extends IntFunctionSingle
                                                           with Aggregation {
  def asString = Cast.asString(this)
}

case class AggFloat(underlying: AnyCol, template: String) extends FloatFunctionSingle
                                                             with Aggregation {
  def asString = Cast.asString(this)
  def round = Round.float(this)
}

case class AggDouble(underlying: AnyCol, template: String) extends DoubleFunctionSingle
                                                              with Aggregation {
  def asString = Cast.asString(this)
  def round = Round.double(this)
}

case class AggInstant(underlying: AnyCol, template: String) extends InstantFunctionSingle
                                                               with Aggregation












































