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


object Round {

  def numeric(col: UsableCol) = RoundNumeric(col)
  def numeric(col: UsableCol, size: Int) = RoundDigitsNumeric(col, size)

  def float(col: UsableCol) = RoundFloat(col)
  def float(col: UsableCol, size: Int) = RoundDigitsFloat(col, size)

  def double(col: UsableCol) = RoundDouble(col)
  def double(col: UsableCol, size: Int) = RoundDigitsDouble(col, size)
}


trait RoundInteger extends UsableCol with UnderlyingArgs {
  val template = "round(%s)"
  def asString = Cast.asString(this)
}

case class RoundNumeric(underlying: UsableCol) extends NumericFunction with RoundInteger

case class RoundFloat(underlying: UsableCol) extends FloatFunction with RoundInteger

case class RoundDouble(underlying: UsableCol) extends DoubleFunction with RoundInteger


trait RoundDecimal extends UsableCol with UnderlyingRef{
  val size: Int
  val template = "round(%s, ?)"
  def args = underlying.args ++ Seq(size)
  def asString = Cast.asString(this)
}

case class RoundDigitsNumeric(underlying: UsableCol, size: Int) extends NumericFunction with RoundDecimal

case class RoundDigitsFloat(underlying: UsableCol, size: Int) extends FloatFunction with RoundDecimal

case class RoundDigitsDouble(underlying: UsableCol, size: Int) extends DoubleFunction with RoundDecimal




















