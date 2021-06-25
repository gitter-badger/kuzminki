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


case class AggNumeric(col: AnyCol, func: String) extends NumericFunction with Aggregation {
  def asString = Cast.asString(this)
  def round = Round.numeric(this)
  def round(prec: Int) = Round.numeric(this, prec)
}

case class AggFloat(col: AnyCol, func: String) extends FloatFunction with Aggregation {
  def asString = Cast.asString(this)
  def round = Round.float(this)
}

case class AggDouble(col: AnyCol, func: String) extends DoubleFunction with Aggregation {
  def asString = Cast.asString(this)
  def round = Round.double(this)
}

case class AggInstant(col: AnyCol, func: String) extends InstantFunction with Aggregation












































